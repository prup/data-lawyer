package checker;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.postgresql.util.PSQLException;

import utils.MyLogger;

/**
 * Stands in for PostgreSQL. Maintains one persistent connection with the
 * database to evaluate policies.
 * 
 * @author prasang
 * 
 */
public class Postgres {

	/**
	 * To add a new log generating function. 1. Name it and its temporary
	 * relation. 2. If applicable, define the INSERT statements in DB_pgsql. 3.
	 * Define the log in createLGFs. 4. (Recommended) Define a function to
	 * update the log.
	 */

	// How many invocations of the same query are needed before we create a
	// preparedstatement for the query.
	private static final Integer THRESHOLD = 2;

	public static void main(final String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		Postgres db = new Postgres();
		System.out.println("Successfully connected!");
		// db.createLGFs();
		db.printAllRelations();
		// db.doConnectionTest();
		db.close();

		String test = "UPDATE TABLE %1$s AS t SET t.reqd = TRUE "
				+ "FROM log_compaction AS l "
				+ "WHERE l.%2$s = r.tid AND t.reqd = FALSE";
		System.out.println(String.format(test, "hey", "you"));
	}

	private Connection conn;
	private String dbname = "MIMIC2";

	private PreparedStatement _insertToQueryLog, _insertToUserLog,
			_insertToQueryTempLog, _insertToUserTempLog;

	private String password = "pluck";
	private String schema = "mimic2v26";
	private String user = "prasang";

	protected Postgres() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");

		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"
				+ dbname, user, password);
		conn.setAutoCommit(false);

		Statement stmnt = conn.createStatement();
		try {
			String query = "set search_path='mimic2v26'";
			stmnt.executeUpdate(query);
			MyLogger.logSQL(query);
		} finally {
			stmnt.close();
		}
		conn.commit();

		String insertStmnt = "INSERT INTO %s VALUES (?, ?, ?, ?, ?);";
		_insertToUserLog = conn.prepareStatement(String.format(insertStmnt,
				schema + "." + Logs.USERS.getName()));
		_insertToUserTempLog = conn.prepareStatement(String.format(insertStmnt,
				Logs.USERS.tempName()));

		insertStmnt = "INSERT INTO %s VALUES (?, ?, ?, ?, ?, ?);";
		_insertToQueryLog = conn.prepareStatement(String.format(insertStmnt,
				schema + "." + Logs.SCHEMA.getName()));
		_insertToQueryTempLog = conn.prepareStatement(String.format(
				insertStmnt, Logs.SCHEMA.tempName()));

		preparedCache = new HashMap<String, PreparedStatement>();
		queryCount = new HashMap<String, Integer>();
	}

	public final void abortTransaction() throws SQLException {
		conn.rollback();
	}

	/* Frequently used operations. */
	public final int cardinality(final String relation) throws SQLException {
		Statement stmnt = conn.createStatement();
		ResultSet rs = null;
		try {
			String count = "SELECT COUNT(*) FROM %s;";
			String query = String.format(count, relation);
			rs = stmnt.executeQuery(query);
			MyLogger.logSQL(query);
			rs.next();
			return rs.getInt(1);
		} finally {
			if (rs != null)
				rs.close();
			stmnt.close();
		}
	}

	public final void cleanUpBeforeExperiment(final boolean toCleanup)
			throws SQLException {
		Statement stmnt = conn.createStatement();
		try {
			if (toCleanup) {
				String deleteAllStmnt = "TRUNCATE TABLE %s;";
				for (Logs log : Logs.values()) {
					String query = String.format(deleteAllStmnt, schema + "."
							+ log.getName());
					stmnt.execute(query);
				}
			} else {
				String truncateUser = "TRUNCATE TABLE users;";
				String copyFromBackup = "INSERT INTO users "
						+ "(SELECT qid, uid, ts, qstring, FALSE FROM users10000);";
				stmnt.execute(truncateUser);
				MyLogger.logSQL(truncateUser);
				stmnt.execute(copyFromBackup);
				MyLogger.logSQL(copyFromBackup);
			}
			conn.commit();
			MyLogger.logSQL("commit");
		} finally {
			stmnt.close();
		}
	}

	private void close() throws SQLException {
		conn.close();
	}

	public final void commitTransaction() throws SQLException {
		conn.commit();
	}

	public final void createLGFs() throws SQLException {
		for (Logs log : Logs.values()) {
			createTable(schema + "." + log.getName(), log.schema());
			if (log.tempName() != null)
				createTempTable(log.tempName(), log.schema());
		}
		createTable(schema + "." + "groups", "uid INT, gid text");
		String registerProvenanceUDF = "DROP FUNCTION IF EXISTS "
				+ "insert_to_prov_temp(int, text, text, tid[]); "
				+ "CREATE FUNCTION insert_to_prov_temp(int, text, text, tid[]) "
				+ "RETURNS void AS $$ INSERT INTO provenance_temp "
				+ "(SELECT $1, $2, $3, prov_value, FALSE "
				+ "FROM unnest($4) as prov_value) " + "$$ LANGUAGE SQL;";
		execute(registerProvenanceUDF);
		MyLogger.logSQL(registerProvenanceUDF);
		conn.commit();
	}

	private void createTable(final String relation, final String definition)
			throws SQLException {
		Statement stmnt = conn.createStatement();
		try {
			String sqlStmnt = "CREATE TABLE IF NOT EXISTS %s (%s);";
			String query = String.format(sqlStmnt, relation, definition);
			stmnt.execute(query);
			MyLogger.logSQL(query);
		} catch (PSQLException e) {
			System.err.println("Could not create table: " + relation);
			throw e;
		} finally {
			stmnt.close();
		}
	}

	private void createTempTable(final String relation, final String definition)
			throws SQLException {
		Statement stmnt = conn.createStatement();
		try {
			String sqlStmnt = "CREATE TEMP TABLE IF NOT EXISTS %s (%s) "
					+ "ON COMMIT DELETE ROWS;";
			String query = String.format(sqlStmnt, relation, definition);
			stmnt.execute(query);
			MyLogger.logSQL(query);
		} catch (PSQLException e) {
			System.err.println("Can not create this temp table: " + relation);
			throw e;
		} finally {
			stmnt.close();
		}

	}

	public final void doConnectionTest() throws SQLException {
		String[] relationNames = { "admissions", "d_caregivers" };
		for (String relation : relationNames)
			System.out.println(cardinality(schema + "." + relation));
	}

	public final boolean emptyOutput(final String query) throws SQLException {
		ResultSet rs = null;
		try {
			rs = executeQuery(query);
			boolean b = !rs.isBeforeFirst();
			return b;
		} finally {
			if (rs != null) {
				if (rs.getStatement() instanceof PreparedStatement)
					rs.close();
				else
					rs.getStatement().close();
			}
		}
	}

	private HashMap<String, PreparedStatement> preparedCache;
	private HashMap<String, Integer> queryCount;

	public final boolean execute(final String query) throws SQLException {
		Statement stmnt = conn.createStatement();
		try {
			MyLogger.logSQL(query);
			return stmnt.execute(query);
		} catch (SQLException e) {
			System.err.println("Offending query: " + e.getMessage());
			return true;
			// throw e;
		} finally {
			stmnt.close();
		}
	}

	public final ResultSet executeQuery(final String query) throws SQLException {
		if (preparedCache.containsKey(query)) {
			MyLogger.logSQL(query);
			return preparedCache.get(query).executeQuery();
		} else if (queryCount.containsKey(query)) {
			if (queryCount.get(query) >= THRESHOLD) {
				PreparedStatement stmnt = conn.prepareStatement(query);
				stmnt.setFetchSize(10);
				preparedCache.put(query, stmnt);
			} else
				queryCount.put(query, queryCount.get(query) + 1);
		} else
			queryCount.put(query, 1);

		try {
			Statement stmnt = conn.createStatement();
			stmnt.setFetchSize(10);
			MyLogger.logSQL(query);
			return stmnt.executeQuery(query);
		} catch (OutOfMemoryError e) {
			System.err.println("Executing query: " + query);
			throw e;
		} catch (SQLException e) {
			System.err.println("Query executed was: " + query);
			throw e;
		}
	}

	public final int executeUpdate(final String query) throws SQLException {
		Statement stmnt = conn.createStatement();
		try {
			MyLogger.logSQL(query);
			return stmnt.executeUpdate(query);
		} catch (SQLException e) {
			System.err.println("Offending query: " + e.getMessage());
			return 0;
			// throw e;
		} finally {
			stmnt.close();
		}
	}

	/*
	 * This function checks if table is present in the database.
	 */
	private boolean existsRelation(String table) throws SQLException {
		ResultSet rs = null;
		try {
			table = separateSchemaAndName(table)[1];
			rs = conn.getMetaData().getTables(null, null, table, null);
			return rs.next();
		} finally {
			if (rs != null)
				rs.getStatement().close();
		}
	}

	/*
	 * This function retrieves the column names belonging to a particular
	 * relation from the metadata.
	 * 
	 * TODO: We aren't using schema. It's here for completeness.
	 */
	public final ArrayList<String> getColumns(final String table,
			final String schema) throws SQLException {
		Statement st = conn.createStatement();
		ResultSet rset = null;
		try {
			if (!existsRelation(table))
				return null;
			ArrayList<String> columns = new ArrayList<String>();
			String query;
			if (schema == null)
				query = ("select column_name from information_schema.columns "
						+ "where table_name='"
						+ separateSchemaAndName(table)[1] + "';");
			else
				query = ("select column_name from information_schema.columns "
						+ "where table_name='"
						+ separateSchemaAndName(table)[1]
						+ "' and table_schema='" + schema + "';");
			MyLogger.logSQL(query);
			rset = st.executeQuery(query);
			while (rset.next())
				columns.add(rset.getString(1));
			MyLogger.getLog().finest(
					"Columns in table: " + table + " are: "
							+ columns.toString());
			return columns;
		} finally {
			if (rset != null)
				rset.close();
			st.close();
		}
	}

	public final void insertToProvenanceLog(final String addProvenance)
			throws SQLException {
		Statement stmnt = conn.createStatement();
		try {
			MyLogger.logSQL(addProvenance);
			stmnt.executeQuery(addProvenance);
		} finally {
			stmnt.close();
		}
	}

	/*
	 * public void insertToOutputLog(boolean toTemp, boolean reqd, String
	 * deltaQuery) throws SQLException { Statement stmnt =
	 * _con.createStatement(); try { String table; if (toTemp) table =
	 * _lgf_output_temp; else table = _lgf_output; String updateQuery =
	 * String.format("INSERT INTO %s %s", table, deltaQuery);
	 * DUMLog.logSQL(updateQuery); stmnt.executeUpdate(updateQuery); } finally {
	 * stmnt.close(); } }
	 */

	public final void insertToQueryLog(final int qid, final String ocid,
			final String icid, final String irid, final boolean toTemp,
			final boolean agg, final boolean reqd) throws SQLException {
		MyLogger.getLog().finest(
				"Adding to query log: " + qid + " " + ocid + " " + icid + " "
						+ irid + " " + agg);
		int numRowsInserted;
		if (toTemp) {
			_insertToQueryTempLog.setInt(1, qid);
			_insertToQueryTempLog.setString(2, ocid);
			_insertToQueryTempLog.setString(3, icid);
			_insertToQueryTempLog.setString(4, irid);
			_insertToQueryTempLog.setBoolean(5, agg);
			_insertToQueryTempLog.setBoolean(6, reqd);
			numRowsInserted = _insertToQueryTempLog.executeUpdate();
			MyLogger.logSQL(_insertToQueryTempLog.toString());
		} else {
			_insertToQueryLog.setInt(1, qid);
			_insertToQueryLog.setString(2, ocid);
			_insertToQueryLog.setString(3, icid);
			_insertToQueryLog.setString(4, irid);
			_insertToQueryLog.setBoolean(5, agg);
			_insertToQueryLog.setBoolean(6, reqd);
			numRowsInserted = _insertToQueryLog.executeUpdate();
			MyLogger.logSQL(_insertToQueryLog.toString());
		}
		if (numRowsInserted == 0)
			MyLogger.getLog().severe("An insert to schema log failed: ");
	}

	public final void generateUserLog(final int qid, final int uid,
			final double ts, final String query, final boolean toTemp,
			final boolean reqd) throws SQLException {
		MyLogger.getLog().finest(
				"Adding to user log: " + qid + " " + uid + " " + ts + " "
						+ query);
		int numRowsInserted;
		if (toTemp) {
			_insertToUserTempLog.setInt(1, qid);
			_insertToUserTempLog.setInt(2, uid);
			_insertToUserTempLog.setDouble(3, ts);
			_insertToUserTempLog.setString(4, query);
			_insertToUserTempLog.setBoolean(5, reqd);
			numRowsInserted = _insertToUserTempLog.executeUpdate();
			MyLogger.logSQL(_insertToUserTempLog.toString());
		} else {
			_insertToUserLog.setInt(1, qid);
			_insertToUserLog.setInt(2, uid);
			_insertToUserLog.setDouble(3, ts);
			_insertToUserLog.setString(4, query);
			_insertToUserLog.setBoolean(5, reqd);
			numRowsInserted = _insertToUserLog.executeUpdate();
			MyLogger.logSQL(_insertToUserLog.toString());
		}

		if (numRowsInserted == 0)
			MyLogger.getLog().severe("An insert to users log failed: ");
	}

	public final void printAllRelations() throws SQLException, IOException {
		HashMap<String, String[]> outputDesc = new HashMap<String, String[]>();

		String filename = "/Users/prasang/Sites/wwdum/stats/mimic.json";
		String[] relationNamesArray1 = { "d_caregivers", "d_parammap_items",
				"db_schema", "parameter_mapping", "comorbidity_scores",
				"icustay_detail", "demographic_detail", "d_chartitems_detail",
				"icustay_days", "icustayevents", "icd9", "d_demographicitems",
				"ioevents", "d_careunits", "labevents", "chartevents",
				"d_codeditems", "procedureevents", "d_chartitems",
				"demographicevents", "a_chartdurations", "drgevents",
				"censusevents", "microbiologyevents", "medevents",
				"a_iodurations", "poe_order", "poe_med", "totalbalevents",
				"d_ioitems", "deliveries", "a_meddurations", "d_meditems",
				"additives", "d_patients", "noteevents", "d_labitems",
				"admissions" };
		outputDesc.put(filename, relationNamesArray1);

		filename = "/Users/prasang/Sites/wwdum/stats/activitylog.json";
		String[] relationNamesArray2 = { "users", "rejects", "schema",
				"provenance", "clock" };
		outputDesc.put(filename, relationNamesArray2);

		String sql = "SELECT * FROM %s LIMIT 5";

		for (String filekey : outputDesc.keySet()) {
			String[] relations = outputDesc.get(filekey);

			JSONArray overallArray = new JSONArray();
			JSONObject overallObject = new JSONObject();

			for (int relindex = 0; relindex < relations.length; ++relindex) {
				String relation = relations[relindex];
				String toExec = String.format(sql, relation);

				ResultSet rs = DB.getDB().executeQuery(toExec);
				MyLogger.logSQL(toExec);
				try {

					JSONObject jsonOutput = new JSONObject();
					JSONArray jsonresults = new JSONArray();

					jsonOutput.put("name", relation);

					ResultSetMetaData rsmtData = rs.getMetaData();
					int ncols = rsmtData.getColumnCount();

					String[] header = new String[ncols];
					for (int i = 1; i <= ncols; ++i)
						header[i - 1] = rsmtData.getColumnLabel(i);

					jsonOutput.append("schema", new JSONArray(header));

					String[] row = new String[ncols];

					while (rs.next()) {
						for (int i = 1; i <= ncols; ++i)
							row[i - 1] = rs.getString(i);
						jsonresults.put(new JSONArray(row));
					}

					jsonOutput.put("tuples", jsonresults);

					overallArray.put(jsonOutput);
				} finally {
					if (rs != null)
						rs.getStatement().close();
				}
			}

			overallObject.put("results", overallArray);

			FileWriter file = new FileWriter(filekey);
			file.write(overallObject.toString(2));
			file.close();

		}

	}

	public final String[] separateSchemaAndName(final String name) {
		String[] names = { null, name };
		if (name.contains(".")) {
			names = name.split("\\.");
			if (names.length != 2)
				throw new IllegalArgumentException(name
						+ " is not a syntactically correct table name.");
		}
		return names;
	}

	private Random random1 = new Random();

	public final void truncateTempTable(final String tempTable,
			final boolean toCommit) throws SQLException {
		Statement stmnt = conn.createStatement();
		try {
			String query = null;
			double threshold = 0.1;
			if (random1.nextDouble() < threshold) {
				query = "TRUNCATE " + tempTable;
			} else {
				query = "DELETE FROM " + tempTable;
			}
			stmnt.execute(query);
			MyLogger.logSQL(query);
			if (toCommit) {
				conn.commit();
				MyLogger.logSQL("commit");
			}
		} finally {
			stmnt.close();
		}
	}

	public final int getLogSize(final String lgf) throws SQLException {
		Statement stmnt = conn.createStatement();
		ResultSet rs = null;
		try {
			String query = String.format("SELECT count(*) FROM %s", lgf);
			rs = stmnt.executeQuery(query);
			MyLogger.logSQL(query);

			if (rs.next())
				return rs.getInt(1);
			else
				throw new SQLException("Result set must return the count "
						+ "of the query in the provided log.");
		} finally {
			if (rs != null)
				rs.close();
			stmnt.close();
		}
	}

}
