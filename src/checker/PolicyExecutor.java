package checker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.activation.UnsupportedDataTypeException;

import parser.ParserWrapper;
import relation.Index;
import relation.Op;
import relation.OpUnion;
import relation.Relation;
import relation.SQLUtils;
import utils.DataLawyerException;
import utils.ListUtils;
import utils.MyLogger;
import experiment.Benchmarker;
import experiment.ExptConfig;
import experiment.ExptConfig.TurnOff;
import experiment.MyTimer;

public class PolicyExecutor {

	public static ArrayList<String> getIndexes(Relation policy) {
		ArrayList<String> indices = new ArrayList<String>();
		if (policy instanceof Index)
			indices.add(((Index) policy).toSqlString());
		else {
			Op op = (Op) policy;
			for (int iInput = 0; iInput < op.numInputs(); ++iInput)
				ListUtils.union(indices, getIndexes(op.input(iInput)));
		}
		return indices;
	}

	private static Relation unionedPolicy = null;
	private static String unionedPolicySQL = null;
	private static ArrayList<String> unionedPolicyIndices = null;

	private static HashMap<Relation, Boolean> incrementalNessMap = new HashMap<Relation, Boolean>();

	private static boolean isIncremental(final Relation r) throws DataLawyerException {
		if (!incrementalNessMap.containsKey(r))
			incrementalNessMap.put(r, PolicyTransformer.isIncremental(r, true));
		return incrementalNessMap.get(r);
	}

	/**
	 * TODO: Need to handle the case where there are no policies to execute for
	 * all execution strategies.
	 * 
	 * @param context
	 * @param policies
	 * @param results
	 * @param log
	 * @param exptNumber
	 * @return
	 * @throws DataLawyerException
	 * @throws SQLException
	 */
	private static ResultSetPlus unionTest(final ExptConfig context,
			final PolicyTransformer policies, final ResultSetPlus results,
			final LogUtils log, final Benchmarker exptNumber)
			throws DataLawyerException, SQLException {
		if (unionedPolicySQL == null) {
			if (policies.getOnlyPolicies().isEmpty()) {
				// TODO: Handle this.
			} else if (policies.getOnlyPolicies().size() == 1)
				unionedPolicy = policies.getOnlyPolicies().get(0);
			else {
				unionedPolicy = new OpUnion(policies.getOnlyPolicies().get(0),
						policies.getOnlyPolicies().get(1));
				for (int i = 2; i < policies.getOnlyPolicies().size(); ++i)
					((OpUnion) unionedPolicy).addRelation(policies
							.getOnlyPolicies().get(i));
			}

			unionedPolicySQL = SQLUtils.convertToSQL(unionedPolicy);
			unionedPolicyIndices = getIndexes(unionedPolicy);
		}

		String policyString = null;
		for (String index : unionedPolicyIndices) {
			log.generateLog(index, results.query, exptNumber, context);
			policyString = log.replaceNameWithView(index, unionedPolicySQL,
					isIncremental(unionedPolicy), context);
		}

		try {
			MyTimer queryTimer = new MyTimer();
			queryTimer.reset();
			queryTimer.start();
			ResultSet rs = DB.getDB().executeQuery(policyString);
			queryTimer.end();
			String key = "policyEvalTime" + unionedPolicy.getId();
			exptNumber.add(key, queryTimer.read());

			if (rs.isBeforeFirst()) {
				results.addPolicyOutcome(false);
				results.addResultSet(rs);
			} else {
				results.addPolicyOutcome(true);
				// We just close the result set when we are using
				// preparedstatements.
				if (rs.getStatement() instanceof PreparedStatement)
					rs.close();
				else
					// We also close the statement when we are not using
					// preparedstatements.
					rs.getStatement().close();
			}
		} catch (SQLException e) {
			throw e;
		}

		if (!results.isCompliant())
			MyLogger.getLog().info("Some policy failed");

		return results;
	}

	private static ResultSetPlus iterativeTest(final ExptConfig context,
			final PolicyTransformer policies, final ResultSetPlus results,
			final LogUtils log, final Benchmarker exptNumber,
			boolean timeIndependent) throws DataLawyerException, SQLException {
		for (Relation policy : policies.getOnlyPolicies()) {

			String policyString = SQLUtils.convertToSQL(policy);

			ArrayList<String> indices = getIndexes(policy);
			for (String index : indices) {
				log.generateLog(index, results.query, exptNumber, context);

				if (timeIndependent)
					policyString = log.replaceNameWithView(index, policyString,
							isIncremental(policy), context);
				else
					policyString = log.replaceNameWithView(index, policyString,
							false, context);
			}

			try {
				MyTimer queryTimer = new MyTimer();
				queryTimer.reset();
				queryTimer.start();
				ResultSet rs = DB.getDB().executeQuery(policyString);
				queryTimer.end();
				String key = "policyEvalTime" + policy.getId();
				exptNumber.add(key, queryTimer.read());

				if (rs.isBeforeFirst()) {
					results.addPolicyOutcome(false);
					results.addResultSet(rs);
				} else {
					results.addPolicyOutcome(true);
					if (rs != null) {
						if (rs.getStatement() instanceof PreparedStatement)
							rs.close();
						else
							rs.getStatement().close();
					}
				}
			} catch (SQLException e) {
				throw e;
			}
			if (!results.isCompliant()) {
				MyLogger.getLog().info(
						"Policy number that failed in iterative tes: "
								+ results.success.size());
				break;
			}
		}

		return results;
	}

	private static ResultSetPlus interleavedTest(final ExptConfig context,
			final PolicyTransformer policies, final ResultSetPlus results,
			final LogUtils log, final Benchmarker exptNumber)
			throws SQLException, DataLawyerException {

		MyLogger.getLog().info("Doing an interleaved test.");

		HashMap<Relation, Boolean> policiesToCheck = new HashMap<Relation, Boolean>();
		for (Relation policy : policies.getOnlyPolicies())
			policiesToCheck.put(policy, true);

		// Iterate over the different logs.
		ArrayList<String> logsToGenerate = new ArrayList<String>();
		logsToGenerate.add("");
		logsToGenerate.add(Logs.USERS.getName());
		logsToGenerate.add(Logs.SCHEMA.getName());
		for (String pLog : logsToGenerate)
			executeAndPrune(policiesToCheck, policies, context, results, log,
					pLog, exptNumber);

		// Iterate over the policies inside the log-iteration.

		// Generate log-specific output and test if empty.

		for (Relation policy : policiesToCheck.keySet()) {
			if (!policiesToCheck.get(policy))
				continue;

			MyLogger.getLog().info(
					"Policy id: " + policy.getId() + " not pruned.");

			String policyString = SQLUtils.convertToSQL(policy);

			ArrayList<String> indices = getIndexes(policy);
			for (String index : indices) {
				log.generateLog(index, results.query, exptNumber, context);
				// Need more smarts here. Check if incrementally computable.
				if (context.TO_TURN_OFF == TurnOff.TIME)
					policyString = log.replaceNameWithView(index, policyString,
							false, context);
				else
					policyString = log.replaceNameWithView(index, policyString,
							isIncremental(policy), context);
			}

			exptNumber.add("not_pruned_policy " + policy.getId(), "null");

			MyTimer queryTimer = new MyTimer();
			queryTimer.reset();
			queryTimer.start();
			try {
				ResultSet rs = DB.getDB().executeQuery(policyString);
				if (rs.isBeforeFirst()) {
					results.addPolicyOutcome(false);
					results.addResultSet(rs);
				} else {
					results.addPolicyOutcome(true);
					if (rs != null) {
						if (rs.getStatement() instanceof PreparedStatement)
							rs.close();
						else
							rs.getStatement().close();
					}
				}
			} catch (SQLException e) {
				throw e;
			}
			queryTimer.end();
			String key = "policyEvalTime" + policy.getId();
			exptNumber.add(key, queryTimer.read());

			if (!results.isCompliant()) {
				MyLogger.getLog().info(
						"Policy number that failed in iterative tes: "
								+ results.success.size());
				break;
			}
		}

		return results;

	}

	private static HashMap<Relation, Boolean> executeAndPrune(
			final HashMap<Relation, Boolean> policiesToCheck,
			final PolicyTransformer policies, final ExptConfig context,
			final ResultSetPlus results, final LogUtils log,
			final String generatedLogs, final Benchmarker exptNumber)
			throws SQLException, DataLawyerException {

		for (Relation policy : policiesToCheck.keySet()) {
			if (!policiesToCheck.get(policy))
				continue;
			ArrayList<String> partialPolicies = policies.partialPolicies(
					policy, generatedLogs);
			if (partialPolicies.isEmpty())
				continue;

			log.generateLog(generatedLogs, results.query, exptNumber, context);

			MyTimer queryTimer = new MyTimer();
			queryTimer.reset();
			queryTimer.start();
			for (String policyString : partialPolicies) {
				ResultSet rs = null;
				try {
					for (String index : getIndexes(policy))
						policyString = log.replaceNameWithView(index,
								policyString, isIncremental(policy), context);

					rs = DB.getDB().executeQuery(policyString);
					if (!rs.isBeforeFirst()) {
						policiesToCheck.put(policy, false);
						exptNumber.add("pruned_policy " + policy.getId(),
								generatedLogs);
						break;
					}
					if (!results.isCompliant()) {
						MyLogger.getLog().info(
								"Policy number that failed in iterative test: "
										+ results.success.size());
						break;
					}
				} catch (SQLException e) {

					throw e;
				} finally {
					if (rs != null) {
						if (rs.getStatement() instanceof PreparedStatement)
							rs.close();
						else
							rs.getStatement().close();
					}
				}
			}
			queryTimer.end();
			String key = "policyEvalTime" + policy.getId();
			exptNumber.add(key, queryTimer.read());
		}
		return policiesToCheck;
	}

	public static ResultSetPlus ExecuteQuery(final String query,
			final PolicyTransformer policies, final ExptConfig config,
			final Benchmarker benchmarker) throws DataLawyerException, SQLException,
			UnsupportedDataTypeException {
		ResultSetPlus result = new ResultSetPlus(ParserWrapper.parseSQL(query));
		LogUtils logs = new LogUtils();

		/**
		 * 1. It looks at the policies and decides which log-generating
		 * functions to invoke. This has to be stateful since if a
		 * log-generating function has been generated once before, we don't want
		 * to generate it again.
		 * 
		 * 2. It transforms the policies into a set of SQL statements and runs
		 * them and checks the results.
		 * 
		 * 3. Do we need to worry about caching the intermediate results, if
		 * any? What does this return? It returns a yes/no vector detailing if
		 * the policy-fragment turned out to be empty or not.
		 */
		if (config.OPTIMIZER.equalsIgnoreCase("none"))
			result.addPolicyOutcome(true);
		else if (config.OPTIMIZER.equalsIgnoreCase("union"))
			/**
			 * Algorithm 1: Union all boolean policies and execute them in one
			 * go.
			 */
			unionTest(config, policies, result, logs, benchmarker);
		else if (config.OPTIMIZER.equalsIgnoreCase("serial"))
			/**
			 * Algorithm 2: Execute the boolean policies in a random sequence.
			 */
			iterativeTest(config, policies, result, logs, benchmarker, false);
		else if (config.OPTIMIZER.equalsIgnoreCase("interleaved"))
			/**
			 * Algorithm 3: Interleaved execution of policies.
			 */
			if (config.TO_TURN_OFF == TurnOff.INTERLEAVED)
				iterativeTest(config, policies, result, logs, benchmarker, true);
			else
				interleavedTest(config, policies, result, logs, benchmarker);
		else
			throw new IllegalArgumentException("The configuration parameter, "
					+ config.OPTIMIZER + ", was not recognized.");

		if (result.isCompliant()) {
			MyTimer queryTimer = new MyTimer();
			queryTimer.reset();
			queryTimer.start();

			// We compute a count over the query to ensure that the database
			// computes the whole query.
			result.addResultSet(DB.getDB().executeQuery(
					"SELECT COUNT(*) FROM (" + query
							+ ") AS random_temp_for_count"));
			queryTimer.end();
			benchmarker.add("queryCompute", queryTimer.read());

			queryTimer.reset();
			queryTimer.start();

			if (config.OPTIMIZER.equals("interleaved")
					&& config.TO_TURN_OFF != TurnOff.COMPACTION) {
				// Log compaction.
				Set<Logs> logsToMaterialize = policies.getLogsToMaterialize(
						logs, result.query, benchmarker, config);
				for (Logs log : logsToMaterialize) {
					logs.generateLog(log, result.query, benchmarker, config);
					result.preTxCommitCommands("DELETE FROM " + log.getName()
							+ " WHERE reqd = FALSE");
					result.preTxCommitCommands("INSERT INTO " + log.getName()
							+ " SELECT * FROM " + log.tempName()
							// TODO: Debug this.
							+ " WHERE reqd = TRUE");
					result.preTxCommitCommands("UPDATE " + log.getName()
							+ " SET reqd = FALSE");
				}
			} else {
				// No compaction.
				for (Logs index : logs.generatedLogs()) {
					if (index.tempName() == null)
						continue;
					logs.generateLog(index, result.query, benchmarker, config);
					result.preTxCommitCommands("INSERT INTO " + index.getName()
							+ " SELECT * FROM " + index.tempName());
				}
			}
			result.commit(benchmarker);
			queryTimer.end();
			benchmarker.add("compaction", queryTimer.read());
		}

		return result;
	}

}
