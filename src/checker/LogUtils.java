package checker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import parser.ParserWrapper;
import relation.Column;
import relation.ColumnInfo;
import relation.Relation;
import relation.SQLUtils;
import utils.DataLawyerException;
import utils.MyLogger;
import experiment.Benchmarker;
import experiment.ExptConfig;
import experiment.MyTimer;

/**
 * For DRMs we assume that the schema of the log is fixed. This is another
 * invariant of our design.
 * 
 * This is not complete. What we really need a breakdown of datalog statements
 * in relational terms. That would be truly complete. With an escape hatch for
 * UDFs, of course.
 * 
 * @author prasang
 * 
 */
class LogUtils {

	// We want the schema from the database catalog here. Ideally one should
	// query the database, and cache the information.

	// Instead, we hard code the catalog information in the constructors, and
	// check externally.
	// Specifically, we manually ensure, using unit-tests, that we faithfully
	// reproduce the catalog in our classes.

	// TODO: Replace all references to "qid" by pkeyName in DB_pgsql.java
	public static final String PKEYNAME = "qid";

	public static boolean isLog(final String relationName) {
		for (Logs log : Logs.values())
			if (log.getName().equalsIgnoreCase(relationName))
				return true;
		return false;
	}

	/**
	 * Smart match. Strips away schema if part of the name before matching.
	 * 
	 * @param rel1
	 * @param rel2
	 * @return
	 */
	public static boolean match(String rel1, String rel2) {
		rel1 = rel1.trim().toLowerCase();
		rel2 = rel2.trim().toLowerCase();
		if (rel1.equals(rel2))
			return true;
		if (rel1.contains("."))
			rel1 = rel1.substring(rel1.lastIndexOf('.') + 1);
		if (rel2.contains("."))
			rel2 = rel2.substring(rel2.lastIndexOf('.') + 1);
		return (rel1.equals(rel2));
	}

	private static String replace(final String string, String name,
			final String replaceWith) {
		name = "\\b" + name + "\\b";
		return Pattern.compile(name, Pattern.CASE_INSENSITIVE).matcher(string)
				.replaceAll(replaceWith);
	}

	private static String replaceNameWithView(final String logName,
			final String query, final String substitutionType,
			final boolean toAddCtid) {
		String columns = null;
		if (toAddCtid)
			columns = "*, ctid";
		else
			columns = "*";

		Logs log = Logs.of(logName);
		// TODO: Just a hack for one experiment. Used to avoid replacing
		// users_temp with users_temp_temp.
		if (query.toLowerCase().contains(log.tempName().toLowerCase())) {
			System.err.println("Found temp in query to substitute.");
			return query;
		}

		if (substitutionType.equals("temp"))
			return replace(query, log.getName(), log.tempName());
		else if (substitutionType.equals("union"))
			return replace(query, log.getName(), "(SELECT " + columns
					+ " FROM " + log.tempName() + " union SELECT " + columns
					+ " FROM " + log.getName() + ")");
		else if (substitutionType.equals("merged"))
			return query;
		else
			throw new IllegalArgumentException("Unsupported viewType: "
					+ substitutionType);
	}

	private double clockTime = -1;

	private Set<Logs> generatedLogs = new HashSet<Logs>();

	private void createLogTailTable(final Logs log) throws SQLException {
		if (generatedLogs.contains(log))
			return;
		DB.getDB().truncateTempTable(log.tempName(), false);
		generatedLogs.add(log);
	}

	/**
	 * Returns the permanent name of those logs that have been generated in this
	 * turn.
	 * 
	 * @return
	 */
	public Set<Logs> generatedLogs() {
		return generatedLogs;
	}

	public void generateLog(final Logs log, Relation query,
			final Benchmarker benchmarker, final ExptConfig config)
			throws SQLException, DataLawyerException {

		if (generatedLogs.contains(log))
			return;

		updateClock(config);

		boolean isTemp = !config.TO_MATERIALIZE;

		// This code is invoked either when the log is a non-lgf or empty.
		if (log == null)
			return;

		if (log.equals(Logs.USERS)) {
			MyLogger.getLog().info("Generating the log: " + log.name());

			int qid = config.getQid();
			int uid = config.getUid();
			createLogTailTable(log);
			MyTimer queryTimer = new MyTimer();
			queryTimer.reset();
			queryTimer.start();
			DB.getDB().generateUserLog(qid, uid, getCurrentClockTime(),
					SQLUtils.convertToSQL(query), isTemp, false);
			queryTimer.end();
			benchmarker.add("compute_" + Logs.USERS.name(), queryTimer.read());
		} else if (log.equals(Logs.SCHEMA)) {
			MyLogger.getLog().info("Generating the log: " + log.name());

			int qid = config.getQid();
			createLogTailTable(log);
			MyTimer queryTimer = new MyTimer();
			queryTimer.reset();
			queryTimer.start();
			for (Column c : query.getColumns()) {
				// TODO: This is buggy. Do something about it.
				// The bug is in constant columns. When we encounter them, we
				// need to answser what generated them?
				// Right now, I assume that nothing generated them. I am going
				// to add a null column here.
				String ocid = c.getInfo().getNameUnAliased();
				ArrayList<Column> unrolledColumns = SQLUtils.unrollColumn(c,
						true, true);
				boolean agg = false;
				for (Column tempC : unrolledColumns)
					if (ColumnInfo.isAggregate(tempC.getInfo()))
						agg = true;
				for (Column lastCol : unrolledColumns) {
					if (!ColumnInfo.isIndexColumn(lastCol))
						continue;
					String irid = lastCol.getInfo().getRelation().getName();
					String icid = lastCol.getInfo().getNameUnAliased();
					DB.getDB().insertToQueryLog(qid, ocid, icid, irid, isTemp,
							agg, false);
				}
			}
			queryTimer.end();
			benchmarker.add("compute_" + log, queryTimer.read());
		}
		// else if (match(lgf, DB.getDB()._lgf_output)) {
		// DUMLog.getLog().info(
		// "Generating the log: " + lgf + " adding to "
		// + DB.getDB()._lgf_output);
		// int qid = experiment.getQid();
		// createTempTable(lgf);
		// MyTimer queryTimer = new MyTimer();
		// String updateSQL = SQLUtils.addOutput(query, qid);
		// queryTimer.reset();
		// queryTimer.start();
		// DB.getDB().insertToOutputLog(isTemp, false, updateSQL);
		// queryTimer.end();
		// exptNumber.add("compute_" + lgf, queryTimer.read());
		// }
		else if (log.equals(Logs.PROVENANCE)) {

			MyLogger.getLog().info("Generating the log: " + log.name());

			String queryString = SQLUtils.convertToSQL(query);
			query = ParserWrapper.parseSQL(queryString);
			createLogTailTable(log);
			String provstatementString = SQLUtils.addProvenance(query,
					config.getQid(), isTemp);
			MyTimer queryTimer = new MyTimer();
			queryTimer.reset();
			queryTimer.start();
			DB.getDB().insertToProvenanceLog(provstatementString);
			queryTimer.end();
			benchmarker.add("compute_" + log, queryTimer.read());
		} else {
			new DataLawyerException("No such log generating function exists.");
		}
	}

	/*
	 * public String getLogTailName(String logName) { if
	 * (!generatedLogs.containsKey(logName)) return null; return
	 * generatedLogs.get(logName).viewName; }
	 */

	public void generateLog(final String log, final Relation query,
			final Benchmarker benchmarker, final ExptConfig config)
			throws SQLException, DataLawyerException {
		Logs logToUse = null;
		if (match(log, Logs.USERS.getName()))
			logToUse = Logs.USERS;
		else if (match(log, Logs.SCHEMA.getName()))
			logToUse = Logs.SCHEMA;
		else if (match(log, Logs.PROVENANCE.getName()))
			logToUse = Logs.PROVENANCE;
		generateLog(logToUse, query, benchmarker, config);
	}

	private double getCurrentClockTime() {
		return clockTime;
	}

	public String replaceNameWithView(final String view, final String query,
			boolean isIncremental, final ExptConfig config) {
		// Does not add PostgreSQL ctids.
		return substituteLogWithViewHelper(view, query, isIncremental, false,
				config);
	}

	public String replaceNameWithViewWithCtid(String query,
			final boolean isIncremental, final ExptConfig config) {
		// Add PostgreSQL ctids.
		for (Logs index : generatedLogs)
			query = substituteLogWithViewHelper(index.getName(), query,
					isIncremental, true, config);
		return query;
	}

	/**
	 * Replaces an lgf with either its in-memory tail, or the on-disk head, or a
	 * union of both.
	 * 
	 * @param viewName
	 * @param query
	 * @param isIncremental
	 * @param addsCtid
	 * @param config
	 * 
	 * @return
	 */
	private String substituteLogWithViewHelper(final String viewName,
			final String query, boolean isIncremental, boolean addsCtid,
			final ExptConfig config) {
		// TODO: Replace String viewName with Logs log.
		if (!viewName.equalsIgnoreCase(Logs.USERS.getName())
				&& !viewName.equalsIgnoreCase(Logs.SCHEMA.getName())
				&& !viewName.equalsIgnoreCase(Logs.PROVENANCE.getName()))
			return query;
		String subsType = null;
		if (config.TO_MATERIALIZE)
			subsType = "merged";
		else {
			if (isIncremental)
				subsType = "temp";
			else
				subsType = "union";
		}
		for (Logs log : generatedLogs) {
			if (log.getName().equalsIgnoreCase(viewName))
				return replaceNameWithView(viewName, query, subsType, addsCtid);
		}
		// Why do we end up here? It happens when we try substitution on
		// partial policies by looking at lgfs in the original policy.
		// We do we not ask for substitutions directly on the partial
		// policies? We can! But, traversing the policy to find its base
		// relations is expensive and what we do here turns out to be
		// cheaper.
		MyLogger.getLog().warning(
				"Error if this is part of one of the log? " + viewName);
		return query;
	}

	private void updateClock(final ExptConfig config) throws SQLException {
		if (clockTime != -1)
			return;
		clockTime = config.getTS();
		DB.getDB().executeUpdate("DELETE from clock");
		DB.getDB().executeUpdate("INSERT INTO clock VALUES(" + clockTime + ")");
	}
}