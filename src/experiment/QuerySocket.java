package experiment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import parser.ParserWrapper;
import relation.Relation;
import relation.SQLUtils;
import utils.DataLawyerException;
import utils.MyLogger;
import checker.DB;
import checker.Logs;
import checker.PolicyExecutor;
import checker.PolicyTransformer;
import checker.ResultSetPlus;

class QuerySocket {

	public static int PORT = 4444;
	public static char EOF = '\u001a';

	public static String onSuccess = "/Users/prasang/Sites/wwdum/stats/onsuccess.json";
	public static String onFailure = "/Users/prasang/Sites/wwdum/stats/onfailure.json";
	public static String policyAnalysis = "/Users/prasang/Sites/wwdum/stats/policyanalysis.json";

	public static long starttime = -1;

	private static double printTime(final String s) {
		if (starttime == -1) {
			starttime = System.nanoTime();
			return 0;
		}
		double diff = (System.nanoTime() - starttime) / 1000000.0;
		MyLogger.println(s + ": " + diff);
		starttime = System.nanoTime();
		return diff;
	}

	/**
	 * Read the policies from a predefined location and return its parse.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws JSONException
	 * @throws DataLawyerException
	 * @throws IOException
	 */
	private static PolicyTransformer getPolicies(final ExptConfig context)
			throws SQLException, JSONException, DataLawyerException, IOException {

		PolicyTransformer policies = new PolicyTransformer();

		JSONArray policyJSON = ExptConfig.getPoliciesFromJSON().getJSONArray(
				"content");

		for (int policyIndex = 0; policyIndex < policyJSON.length(); ++policyIndex) {
			MyLogger.println("Parsing policy number: " + policyIndex);

			JSONObject policyObject = policyJSON.getJSONObject(policyIndex);

			String policyStr = policyObject.getString("policy");

			ArrayList<String> requiredLogs = new ArrayList<String>();
			for (int logIndex = 0; logIndex < policyObject.getJSONArray(
					"required").length(); ++logIndex)
				requiredLogs.add(policyObject.getJSONArray("required")
						.getString(logIndex));

			HashMap<String, ArrayList<String>> multipleColumns = new HashMap<String, ArrayList<String>>();
			if (policyObject.has("columns")) {
				JSONArray columnMap = policyObject.getJSONArray("columns");
				for (int columnIndex = 0; columnIndex < columnMap.length(); ++columnIndex) {
					for (Object key : columnMap.getJSONObject(columnIndex)
							.keySet()) {
						ArrayList<String> columnNames = new ArrayList<String>();
						JSONArray columnNameArray = columnMap.getJSONObject(
								columnIndex).getJSONArray((String) key);
						for (int colNameIndex = 0; colNameIndex < columnNameArray
								.length(); ++colNameIndex)
							columnNames.add(columnNameArray
									.getString(colNameIndex));
						multipleColumns.put((String) key, columnNames);
					}
				}
			}

			ArrayList<String> knownCompaction = new ArrayList<String>();
			for (int iCompaction = 0; iCompaction < policyObject.getJSONArray(
					"known").length(); ++iCompaction)
				knownCompaction.add(policyObject.getJSONArray("known")
						.getString(iCompaction));

			for (int iCompaction = 0; iCompaction < policyObject.getJSONArray(
					"unknown").length(); ++iCompaction)
				knownCompaction.add(policyObject.getJSONArray("unknown")
						.getString(iCompaction));

			Relation policy = ParserWrapper.parseSQL(policyStr);
			PolicyTransformer.normalizeAsBoolean(policy);

			// TODO: Generalize this if you are going to publish the code.
			HashMap<String, String> compactionTest = new HashMap<String, String>();
			if (policyObject.has("test")) {
				JSONObject tests = policyObject.getJSONObject("test");
				ArrayList<String> indicesOfInterest = new ArrayList<String>();
				indicesOfInterest.add("users");
				indicesOfInterest.add("schema");
				for (String index : indicesOfInterest) {
					if (tests.has(index)) {
						String query = null;
						if (tests.getJSONArray(index).length() > 0)
							query = tests.getJSONArray(index).getString(0);
						for (int qIndex = 1; qIndex < tests.getJSONArray(index)
								.length(); ++qIndex)
							query += " UNION "
									+ tests.getJSONArray(index).getString(
											qIndex);
						compactionTest.put(index, query);
					}
				}
			}

			/*
			// TODO: Remove later. Added for that last experiment about partial policy evaluation?
			HashMap<String, ArrayList<String>> partialPolicies = new HashMap<String, ArrayList<String>>();
			JSONObject partialPoliciesObject = policyObject.getJSONObject("partial");
			String[] logs = {"", Logs.USERS.getName(), Logs.SCHEMA.getName(), Logs.PROVENANCE.getName()};
			for (String logsMaterialized: logs) {
				ArrayList<String> tempPartPolicies = new ArrayList<String>();
				tempPartPolicies.add(partialPoliciesObject.getString(logsMaterialized));
				partialPolicies.put(logsMaterialized, tempPartPolicies);
			}
			policies.addNewPolicy(policy, requiredLogs, knownCompaction, partialPolicies, context);
			*/
			
			policies.addNewPolicy(policy, requiredLogs, knownCompaction, null, context);
		}
		printTime("Time to read the policies: ");
		return policies;
	}

	// private static PolicyTransformer getPoliciesBackup(ExptContext context)
	// throws SQLException, JSONException, DUMException, IOException {
	//
	// PolicyTransformer policies = new PolicyTransformer();
	// ArrayList<Relation> policyList = new ArrayList<Relation>();
	// JSONObject jsonResult = new JSONObject();
	//
	// /* Read the policies' SQL definition from disk. */
	// String field = "Policy - SQL Definition";
	//
	// ArrayList<String> policyStringList = ExptContext
	// .getPoliciesFromJSON(field);
	//
	// for (int policyIndex = 0; policyIndex < policyStringList.size();
	// ++policyIndex) {
	//
	// /*
	// * Only the following four lines are relevant for the non-demo
	// * system.
	// */
	// String policyStr = policyStringList.get(policyIndex);
	// System.out.println("Parsing policy number: " + policyIndex);
	// Relation policy = ParserWrapper.parseSQL(policyStr);
	// PolicyTransformer.normalizeAsBoolean(policy);
	// policyList.add(policy);
	//
	// // JSONObject policyjson = new JSONObject();
	// // ArrayList<Column> baseColumns = new ArrayList<Column>();
	//
	// // Relation booleanPolicy = ParserWrapper.parseSQL(policyStr);
	// //
	// // /* Make queries boolean. Remove unnecessary columns. */
	// // PolicyTransformer.normalizeAsBoolean(booleanPolicy);
	// // policyjson.append("booleanpolicy",
	// // SQLUtils.convertToSQL(booleanPolicy));
	// //
	// // ArrayList<Relation> basicRelations = SQLUtils.getNodeType(
	// // booleanPolicy, Index.class, true);
	// // /*
	// // * Move up the ancestors. when run into an alias, look at columns
	// // * and store them.
	// // */
	// // for (Relation r : basicRelations) {
	// // while (!(r instanceof OpAlias))
	// // r = r._parent;
	// // for (Column column : r.getColumns())
	// // baseColumns.addAll(SQLUtils
	// // .unrollColumn(column, true, true));
	// // }
	// // for (Column column : baseColumns)
	// // policyjson.append("columnsneeded", column.toSqlString());
	// //
	// // /*
	// // * Check if the policy can be incrementally evaluated.
	// // */
	// // if (PolicyTransformer.isIncremental(booleanPolicy, true))
	// // policyjson
	// // .append("othercomment",
	// // "This policy can be computed just on the increment of the log.");
	// // else
	// // policyjson.append("othercomment",
	// // "This policy can not be incrementally computed.");
	// //
	// // jsonResult.put(Integer.toString(policyIndex), policyjson);
	// }
	//
	// /* Begin: Get policy information */
	//
	// /*
	// * FileWriter policyAnalysisWriter = new FileWriter(policyAnalysis);
	// * policyAnalysisWriter.write(jsonResult.toString(2));
	// * policyAnalysisWriter.close();
	// */
	//
	// printTime("Time to read the policies: ");
	//
	// policies.addPolicies(policyList, context);
	//
	// printTime("Time to analyze and input the policies: ");
	//
	// return policies;
	//
	// }

	private static boolean processResults(final ResultSetPlus result,
			final ArrayList<String> policyDescs,
			final ArrayList<String> recommendedActions)
			throws SQLException, JSONException, IOException {

		if (result.isCompliant()) {
			JSONObject jsonOutput = new JSONObject();
			JSONArray jsonresults = new JSONArray();
			ResultSetMetaData rsmtData = result.rSet.getMetaData();
			int ncols = rsmtData.getColumnCount();

			String[] header = new String[ncols];
			for (int i = 1; i <= ncols; ++i)
				header[i - 1] = rsmtData.getColumnLabel(i);

			jsonOutput.append("schema", new JSONArray(header));

			String[] row = new String[ncols];

			while (result.rSet.next()) {
				for (int i = 1; i <= ncols; ++i)
					row[i - 1] = result.rSet.getString(i);
				jsonresults.put(new JSONArray(row));
			}

			jsonOutput.put("tuples", jsonresults);

			FileWriter file = new FileWriter(QuerySocket.onSuccess);
			file.write(jsonOutput.toString(2));
			file.close();

			return true;
		} else {
			// Print diagnostic information.
			for (int i = 0; i < result.success.size(); ++i) {
				if (result.success.get(i))
					continue;
				JSONObject jsonOutput = new JSONObject();

				jsonOutput.append("failedpolicydesc", policyDescs.get(i));
				jsonOutput.append("suggestions", recommendedActions.get(i));

				ResultSetMetaData rsmtData = result.rSet.getMetaData();
				int ncols = rsmtData.getColumnCount();

				JSONObject jsonOutputCounterExamples = new JSONObject();

				String[] header = new String[ncols];
				for (int j = 1; j <= ncols; ++j)
					header[j - 1] = rsmtData.getColumnLabel(j);
				jsonOutputCounterExamples.append("schema",
						new JSONArray(header));

				String[] row = new String[ncols];
				JSONArray jsonTuples = new JSONArray();
				while (result.rSet.next()) {
					for (int j = 1; j <= ncols; ++j)
						row[j - 1] = result.rSet.getString(j);
					jsonTuples.put(new JSONArray(row));
				}
				jsonOutputCounterExamples.put("tuples", jsonTuples);

				jsonOutput.put("counterexamples", jsonOutputCounterExamples);

				FileWriter file = new FileWriter(QuerySocket.onFailure);
				file.write(jsonOutput.toString(2));
				file.close();
				break;
			}

			result.abort(null);

			return false;
		}

	}

	public static void serverMode() throws IOException, SQLException,
			DataLawyerException, InterruptedException {

		ServerSocket serverSocket = null;

		ArrayList<String> policyDescs = null;
		ArrayList<String> recommendedActions = null;

		/* Begin: Cleanup before experiment begins. */
		printTime("Initialize: ");

		DB.getDB().createLGFs();
		DB.getDB().cleanUpBeforeExperiment(true);

		printTime("Time to clean up the logs: ");
		/* End: Cleanup before experiment begins. */

		/* Begin: Get policy information */
		policyDescs = ExptConfig
				.getPoliciesFromJSON("Policy - Text Description");
		recommendedActions = ExptConfig
				.getPoliciesFromJSON("Recommended Action On Policy Violation");

		ExptConfig context = new ExptConfig(
				"/Users/prasang/Sites/wwdum/expts.json", null);

		// Get the policies.
		PolicyTransformer policies = getPolicies(context);

		try {
			serverSocket = new ServerSocket(QuerySocket.PORT);
			System.out.println("Started server.");
		} catch (Exception e) {
			System.err.println("Could not listen on port: " + QuerySocket.PORT);
			System.exit(-1);
		}

		while (true) {
			Socket clientSocket = null;
			try {
				clientSocket = serverSocket.accept();
				System.out.println("Received connection.");
			} catch (IOException e) {
				System.out.println("Accept failed: " + QuerySocket.PORT);
				System.exit(-1);
			}
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
					true);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

			String inputLine;
			String query = "";
			// Initiate conversation with client
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
				// TODO: Hack. I don't know why single quotes are being escaped
				inputLine = inputLine.replace("\\", "");
				query += inputLine.replace(";", "") + "\n";
				if (inputLine.contains(";")) {
					System.out.println("Begin processing query: " + query);
					break;
				}
			}

			ResultSetPlus result = PolicyExecutor.ExecuteQuery(query, policies,
					context, null);
			boolean isSuccess = processResults(result, policyDescs,
					recommendedActions);
			if (isSuccess)
				out.println("success");
			else
				out.println("failure");

			System.out.println("Finished processing.");
			result.close();
			context.next();
			clientSocket.close();
		}

		// serverSocket.close();
	}

	private static void localMode(final String timeseries, final String average)
			throws IOException, SQLException, DataLawyerException,
			InterruptedException, ClassNotFoundException {

		int nQueries = 0;
		MyTimer queryTimer = new MyTimer();
		ArrayList<Benchmarker> experimentNumbers = new ArrayList<Benchmarker>();

		// 2. Get the queries.

		ExptConfig context = new ExptConfig("wwdum/exptconfig/expts.json",
				"wwdum/exptconfig/users.json");

		/* Starting the cleanup before the experiment begins. */
		printTime("Initialize: ");

		DB.getDB().createLGFs();

		DB.getDB().cleanUpBeforeExperiment(context.TOCLEANUP);

		printTime("Time to clean up the logs: ");
		/* Finishing the cleanup before the experiment begins. */

		// 1. Get the policies.

		PolicyTransformer policies = getPolicies(context);

		for (Relation policy : policies.getOnlyPolicies()) {
			System.out.println(policy.getId() + " "
					+ SQLUtils.convertToSQL(policy));
		}

		int iterCount = 0;

		printTime("Starting experiment");

		// 3. Iterate over the queries.
		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"data/individualtimes"));
		double totalTime = 0;
		nQueries = 0;

		int nSuccess = 0;
		int nFailures = 0;

		String query = null;

		while (context.queries.hasNext()) {

			MyLogger.getLog().info(
					"Query id being processed: " + nQueries + " and query is: "
							+ query);

			if (iterCount % 100 == 0)
				System.out.println(iterCount);

			iterCount += 1;

			++nQueries;

			query = context.queries.next();
			Benchmarker exptNumber = new Benchmarker();

			// This is to warm up the cache before executing the first query.
			/*
			 * if (nQueries == 1 && context.OPTIMIZER.equals("interleaved")) for
			 * (int numReps = 0; numReps < 2; ++numReps)
			 * PolicyExecutor.ExecuteQuery(query, policies, context, new
			 * Benchmarker());
			 */

			queryTimer.reset();
			queryTimer.start();

			// 3a. Execute the query.
			ResultSetPlus result = PolicyExecutor.ExecuteQuery(query, policies,
					context, exptNumber);

			if (result.isCompliant()) {
				++nSuccess;
			} else {
				result.abort(exptNumber);
				++nFailures;
			}

			queryTimer.end();

			exptNumber.add("log_user_size",
					DB.getDB().getLogSize(Logs.USERS.getName()));
			exptNumber.add("log_schema_size",
					DB.getDB().getLogSize(Logs.SCHEMA.getName()));
			exptNumber.add("log_prov_size",
					DB.getDB().getLogSize(Logs.PROVENANCE.getName()));

			exptNumber.add("endToEnd", queryTimer.read());

			result.close();

			if (nQueries > 0)
				experimentNumbers.add(exptNumber);

			// exptNumber.print();

			bw.write(exptNumber.get("endToEnd") + "\n");
			bw.flush();

			totalTime += (Double) exptNumber.get("endToEnd");

			context.next();
		}

		printTime("Experiment over after processing " + nQueries + " queries.");

		bw.close();

		System.out.println("Total time taken: " + totalTime);
		System.out.println("Optimizer type: " + context.OPTIMIZER);

		ObjectOutputStream ooStream = new ObjectOutputStream(
				new FileOutputStream(context.TO_SERIALIZE_NUMBERS));
		ooStream.writeObject(experimentNumbers);
		ooStream.close();

		ArrayList<String> columns = new ArrayList<String>();
		columns.add("endToEnd");
		columns.add("queryCompute");
		Benchmarker.readArrayAndPrintAverage(context.TO_SERIALIZE_NUMBERS,
				columns, timeseries, 50, average);

		System.out.println("Number of successes: " + nSuccess);
		System.out.println("Number of failures: " + nFailures);

	}

	public static void main(final String[] args) throws IOException,
			SQLException,
			DataLawyerException, InterruptedException, ClassNotFoundException {
		System.out.println("Starting experiments!");
		if (args.length != 2)
			System.err.println("Number of arguments given is incorrect.");
		else {
			String timeseries = args[0];
			String average = args[1];
			localMode(timeseries, average);
		}
	}
}
