package checker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import relation.BinaryOperation;
import relation.Column;
import relation.ColumnInfo;
import relation.ColumnOptInfo.Redundancy;
import relation.Index;
import relation.Op;
import relation.OpAlias;
import relation.OpGroup;
import relation.OpJoin;
import relation.Operation;
import relation.Operation.OpType;
import relation.Relation;
import relation.SQLUtils;
import utils.DataLawyerException;
import experiment.Benchmarker;
import experiment.ExptConfig;
import experiment.MyTimer;

/**
 * Params pertaining to policies. Usually a 1 to 1 correspondence with the
 * policy json.
 * 
 * @author prasang
 * 
 */
class PolicyParameters {
	public ArrayList<String> _compactionQueries = new ArrayList<String>();
	public HashMap<String, ArrayList<String>> _partialPolicies = new HashMap<String, ArrayList<String>>();
	public boolean _incremental = false;
	public Set<Logs> _requiredLogs = new HashSet<Logs>();

	public PolicyParameters(final Relation policy,
			final ArrayList<String> requiredLogs,
			final ArrayList<String> compaction,
			final HashMap<String, ArrayList<String>> partialPolicies)
			throws DataLawyerException {
		for (String log : requiredLogs)
			_requiredLogs.add(Logs.of(log));
		_compactionQueries = compaction;
		if (_requiredLogs.isEmpty())
			assert (PolicyTransformer.isIncremental(policy, true));
		_incremental = _requiredLogs.isEmpty();
		_partialPolicies = partialPolicies;
	}

	public Set<Logs> getLogsToMaterialize(final LogUtils logs)
			throws SQLException, DataLawyerException {
		// Test that all the logs that are required have been generated, if
		// not return null.
		boolean properSubset = true;
		for (Logs index : _requiredLogs)
			if (!logs.generatedLogs().contains(index)) {
				properSubset = false;
				break;
			}
		if (!properSubset)
			return null;
		return _requiredLogs;
	}

	public HashMap<String, ArrayList<String>> getPartialPolicies() {
		return _partialPolicies;
	}
}

/**
 * The policy class. Stores policies and all sorts of static analysis on top of
 * them.
 * 
 * @author prasang
 * 
 */
public class PolicyTransformer {

	/**
	 * Returns the smallest set of subqueries that make the policy
	 * time-depedent, if that is the case.
	 * 
	 * @param policy
	 * @return
	 * @throws DataLawyerException
	 */
	public static final ArrayList<Relation> getTimedependentSubqueries(
			final Relation policy) throws DataLawyerException {
		ArrayList<Relation> toRet = new ArrayList<Relation>();
		if (isIncremental(policy, true))
			return toRet;
		if (isIncremental(policy, false)) {
			for (Relation input : SQLUtils.getNodeType(policy, OpAlias.class,
					false))
				toRet.addAll(getTimedependentSubqueries(input));
		} else
			toRet.add(policy);
		return toRet;
	}

	/**
	 * Test if a policy is incremental.
	 * 
	 * With ignoreAlias = true, it will test the whole policy.
	 * 
	 * With ignoreAlias = false, it will test until it sees an alias. Said
	 * another way, it will treat an alias as an extensional database and tell
	 * you if the policy is time-independent.
	 * 
	 * @param policy
	 * @param ignoreAlias
	 * @return
	 * @throws DataLawyerException
	 */
	public static final boolean isIncremental(final Relation policy,
			final boolean ignoreAlias) throws DataLawyerException {
		// Check all join operators.
		ArrayList<Relation> joins = SQLUtils.getNodeType(policy, OpJoin.class,
				ignoreAlias);
		for (Relation r : joins) {
			OpJoin join = (OpJoin) r;
			if (!isIncrementalSafeJoin(join, LogUtils.PKEYNAME))
				return false;
		}

		// Check all group by operators.
		for (Relation r : SQLUtils.getNodeType(policy, OpGroup.class,
				ignoreAlias)) {
			OpGroup group = (OpGroup) r;

			if (group.nGroupingColumns == 0)
				return false;

			// Just make sure that the primary grouping column is the key.
			Column baseColumn = SQLUtils.getBaseColumn(group.getColumn(0),
					true, false);
			if (!LogUtils.PKEYNAME.equalsIgnoreCase(baseColumn.getInfo()
					.getNameUnAliased()))
				return false;
		}

		return true;
	}

	/**
	 * For each log relation, make sure that there is a join on the primary key
	 * indicated by the second input parameter.
	 * 
	 * TODO: Handle the fact that a multiplicity of columns can be primary keys.
	 * Ideally, for a join, what we need to ask is if it is a primary key and if
	 * it is, to which base relation does it belong?
	 * 
	 * @param join
	 * @param key
	 * @return
	 * @throws DataLawyerException
	 */
	private static boolean isIncrementalSafeJoin(final OpJoin join,
			final String key) throws DataLawyerException {

		// In joins_map, if relation R.key = S.key, then S is present in R's
		// list and vice versa.
		HashMap<Index, ArrayList<Index>> joinsMap = new HashMap<Index, ArrayList<Index>>();

		ArrayList<Relation> logs = SQLUtils
				.getNodeType(join, Index.class, true);
		ArrayList<Relation> notLogs = new ArrayList<Relation>();

		for (Relation rid : logs)
			if (!LogUtils.isLog(rid.getName()))
				notLogs.add(rid);

		for (Relation rid : notLogs)
			logs.remove(rid);

		// If no input relations are log relations, the policy is
		// incrementally-safe by definition.
		if (logs.isEmpty())
			return true;

		// At this point, logs contains those relations which are part of the
		// logs database.

		for (Relation rid : logs)
			joinsMap.put((Index) rid, new ArrayList<Index>());

		// The following goes through all the equality comparisons and
		// records the ones involving the key.
		for (Operation op : join.operations()) {
			BinaryOperation bop = (BinaryOperation) op;
			if (!op._op.equals(OpType.EQ))
				continue;
			ColumnInfo lcolinfo = SQLUtils.getBaseColumn(bop._leftInputIndex,
					true, false).getInfo();
			ColumnInfo rcolinfo = SQLUtils.getBaseColumn(bop._rightInputIndex,
					true, false).getInfo();
			if (key.equalsIgnoreCase(lcolinfo.getNameUnAliased())
					&& key.equalsIgnoreCase(rcolinfo.getNameUnAliased())) {
				joinsMap.get(lcolinfo.getRelation()).add(
						(Index) rcolinfo.getRelation());
				joinsMap.get(rcolinfo.getRelation()).add(
						(Index) lcolinfo.getRelation());
			}
		}

		boolean finished = false;
		Index start = joinsMap.keySet().iterator().next();
		while (!finished) {
			finished = true;
			ArrayList<Index> joinedWith = joinsMap.get(start);
			ArrayList<Index> transitivelyJoinedWith = new ArrayList<Index>();
			for (Index other_rid : joinedWith)
				transitivelyJoinedWith.addAll(joinsMap.get(other_rid));

			for (Index newRid : transitivelyJoinedWith) {
				if (!newRid.equals(start) && !joinedWith.contains(newRid)) {
					finished = false;
					joinedWith.add(newRid);
				}
			}
		}

		return (joinsMap.get(start).size() == joinsMap.keySet().size() - 1);

	}

	/**
	 * Given a non-boolean query, make it boolean.
	 * 
	 * @param query
	 * @throws DataLawyerException
	 */
	public static void normalizeAsBoolean(Relation query) throws DataLawyerException {
		for (Column c : query.getColumns()) {
			// TODO: This apparently does not work on constant columns? The hack
			// we have is to treat Unknown and True as the same.
			query.setRedundancy(c, Redundancy.True);
		}
		pushRedundancyDown(query);

		/*
		 * TODO: We are removing this check to speed up experiments. if
		 * (hasUnknownRedundancy(query)) System.err.println(
		 * "Some columns had unknown redundancy after pushing redundancy down."
		 * );
		 */

		for (Relation r : SQLUtils.flatten(query)) {
			for (Column c : r.getColumns())
				if ((r.getRedundancy(c).equals(Redundancy.True) || r
						.getRedundancy(c).equals(Redundancy.Unknown))
						&& r._parent != null) {
					r._parent.deleteInputColumnRecursive(c, r);
				}
		}
	}

	private static void pushRedundancyDown(final Relation r)
			throws DataLawyerException {
		if (!(r instanceof Op))
			return;
		Op op = (Op) r;
		op.propagateRedundancyDownLocally();
		for (Relation input : op.inputs()) {
			for (Column cid : input.getColumns())
				if (input.getRedundancy(cid) == Redundancy.Unknown)
					input.setRedundancy(cid, Redundancy.True);
			pushRedundancyDown(input);
		}
	}

	private final HashMap<Relation, HashMap<String, ArrayList<String>>> partialPolicies;
	private final HashMap<Relation, PolicyParameters> policyMap;
	private final ArrayList<Relation> storedSimplePolicies;

	public PolicyTransformer() {
		policyMap = new HashMap<Relation, PolicyParameters>();
		storedSimplePolicies = new ArrayList<Relation>();
		partialPolicies = new HashMap<Relation, HashMap<String, ArrayList<String>>>();
	}

	/**
	 * Adds a new policy and the parameters read from the policy json file.
	 * 
	 * @param policy
	 * @param requiredLogs
	 * @param compactionQuery
	 * @param partialPolicies
	 * @param config
	 * @throws DataLawyerException
	 * @throws SQLException
	 */
	public void addNewPolicy(final Relation policy,
			final ArrayList<String> requiredLogs,
			final ArrayList<String> compactionQuery,
			final HashMap<String, ArrayList<String>> partialPolicies,
			final ExptConfig config) throws DataLawyerException, SQLException {
		storedSimplePolicies.add(policy);
		policyMap.put(policy, new PolicyParameters(policy, requiredLogs,
				compactionQuery, partialPolicies));
		generatePartialPolicies(policy, partialPolicies, config);
	}

	/**
	 * Generate partial policies for the given policy.
	 * 
	 * @param policy
	 * @param partialPolicies2
	 * @param config
	 * @throws DataLawyerException
	 * @throws SQLException
	 */
	private void generatePartialPolicies(final Relation policy,
			final HashMap<String, ArrayList<String>> partialPolicies2,
			final ExptConfig config) throws DataLawyerException, SQLException {
		// Define the key to be the list of generated logs.

		// No log.
		ArrayList<String> zeroLog = new ArrayList<String>();

		// User log.
		ArrayList<String> oneLog = new ArrayList<String>();
		oneLog.add(Logs.USERS.getName());

		// User and schema logs.
		ArrayList<String> twoLog = new ArrayList<String>();
		twoLog.add(Logs.SCHEMA.getName());
		twoLog.add(Logs.USERS.getName());

		// All logs.
		ArrayList<String> threeLog = new ArrayList<String>();
		threeLog.add(Logs.PROVENANCE.getName());
		threeLog.add(Logs.SCHEMA.getName());
		threeLog.add(Logs.USERS.getName());

		if (config.OPTIMIZER.equalsIgnoreCase("interleaved")) {

			// Oct 18th: The following code is only to test the impact of
			// partial policies on log compation queries.
			// System.out.println("THIS IS TEMPORARY. MAKE SURE YOU DO NOT RUN NORMAL EXPERIMENTS ON THIS.");
			// partialPolicies.put(policy, partialPolicies2);

			// TODO: Uncomment the following. Remove the above extraneous stuff.
			partialPolicies.put(policy,
					new HashMap<String, ArrayList<String>>());
			partialPolicies.get(policy).put(
					"",
					SQLUtils.convertToSQL(SQLUtils.getPartialPolicies(policy,
							zeroLog)));
			partialPolicies.get(policy).put(
					Logs.USERS.getName(),
					SQLUtils.convertToSQL(SQLUtils.getPartialPolicies(policy,
							oneLog)));
			partialPolicies.get(policy).put(
					Logs.SCHEMA.getName(),
					SQLUtils.convertToSQL(SQLUtils.getPartialPolicies(policy,
							twoLog)));
			partialPolicies.get(policy).put(
					Logs.PROVENANCE.getName(),
					SQLUtils.convertToSQL(SQLUtils.getPartialPolicies(policy,
							threeLog)));
		}
	}

	public final HashMap<Relation, PolicyParameters> getFullPolicies() {
		return policyMap;
	}

	public final ArrayList<Relation> getOnlyPolicies() {
		return storedSimplePolicies;
	}

	public final ArrayList<String> partialPolicies(final Relation policy,
			final String logName) {
		return partialPolicies.get(policy).get(logName);
	}

	/**
	 * Returns the table that is related to the column provided.
	 * 
	 * @param column
	 *            : the column name.
	 * @param isPermanent
	 *            : isPermanent indicates if we want the name of the on-disk
	 *            relation or of the temporary relation.
	 * @return
	 */
	private String getTable(String column, final boolean isPermanent) {
		column = column.trim().toLowerCase();
		if (column.contains("users"))
			return isPermanent ? Logs.USERS.getName() : Logs.USERS.tempName();
		else if (column.contains("schema"))
			return isPermanent ? Logs.SCHEMA.getName() : Logs.SCHEMA.tempName();
		else if (column.contains("prov"))
			return isPermanent ? Logs.PROVENANCE.getName() : Logs.PROVENANCE
					.tempName();
		else
			throw new IllegalArgumentException(
					"This is not a valid column name for log_compaction: "
							+ column);
	}

	/**
	 * Generates the "required" logs. Updates the log compaction query to refer
	 * to both the on-disk head and the in-memory tail of the log. Runs the
	 * compaction query. Marks the tuples for retention.
	 * 
	 * @param logs
	 * @param userQuery
	 * @param benchmarker
	 * @param config
	 * @return
	 * @throws SQLException
	 * @throws DataLawyerException
	 */
	public final Set<Logs> getLogsToMaterialize(final LogUtils logs,
			final Relation userQuery, final Benchmarker benchmarker,
			final ExptConfig config) throws SQLException, DataLawyerException {
		MyTimer timer = new MyTimer();
		timer.start();

		Set<Logs> logsToStore = new HashSet<Logs>();
		for (Relation policy : policyMap.keySet()) {
			// This increments the log appropriately.
			// TODO: The advanced pruning mechanism should fit into the
			// following call.
			Set<Logs> required = policyMap.get(policy).getLogsToMaterialize(
					logs);
			if (required == null)
				continue;
			if (required.isEmpty())
				continue;
			for (Logs log : required)
				if (!logsToStore.contains(log))
					logsToStore.add(log);

			for (String query : policyMap.get(policy)._compactionQueries) {
				query = logs.replaceNameWithViewWithCtid(query, false, config);
				DB.getDB().executeUpdate("DROP TABLE IF EXISTS log_compaction");
				DB.getDB().executeUpdate(query);
				ArrayList<String> getColumns = DB.getDB().getColumns(
						"log_compaction", null);
				for (String column : getColumns) {
					String update = "UPDATE %1$s AS t SET reqd = TRUE "
							+ "FROM log_compaction AS l "
							+ "WHERE l.%2$s = t.ctid AND t.reqd = FALSE";
					DB.getDB().executeUpdate(
							String.format(update, getTable(column, true),
									column));
					DB.getDB().executeUpdate(
							String.format(update, getTable(column, false),
									column));
				}
			}
		}
		timer.end();
		benchmarker.add("compaction_test", timer.read());
		return logsToStore;
	}

}
