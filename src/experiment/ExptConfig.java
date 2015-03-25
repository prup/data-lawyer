package experiment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.activation.UnsupportedDataTypeException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ExptConfig {
	
	private static final String POLICYFILENAME = "wwdum/exptconfig/policies.json";

	public static ArrayList<String> getPoliciesFromJSON(
			final String flatfieldname)
			throws JSONException, FileNotFoundException {

		JSONObject json = getPoliciesFromJSON();

		ArrayList<String> policies = new ArrayList<String>();
		for (int i = 0; i < json.getJSONArray("content").length(); ++i) {
			JSONObject policy = json.getJSONArray("content").getJSONObject(i);
			String policyString = policy.getString(flatfieldname).trim()
					.replace('\n', ' ');
			policies.add(policyString);
		}

		return policies;
	}

	public static JSONObject getPoliciesFromJSON()
			throws JSONException, FileNotFoundException {
		return new JSONObject(new JSONTokener(new FileReader(
				POLICYFILENAME)));
	}

	
	int qid;
	private final long startingTime;
	public final QueryIterator queries;

	/* Experiment parameters */
	public final boolean TO_MATERIALIZE;
	public final String OPTIMIZER;
	public final double STARTING_TIME_OFFSET;
	public final int STARTING_QID_OFFSET;
	public final boolean TOCLEANUP;
	public final String TO_SERIALIZE_NUMBERS;
	public final TurnOff TO_TURN_OFF;

	public enum TurnOff {
		TIME, INTERLEAVED, COMPACTION, NONE
	};
	
	public ExptConfig(final String parameterFile, final String queriesFileName)
			throws JSONException, FileNotFoundException {
		JSONObject params = new JSONObject(new JSONTokener(new FileReader(
				parameterFile)));
		JSONObject queriesJson = new JSONObject(new JSONTokener(new FileReader(
				queriesFileName)));
		queries = QueryIterator.readFromJSON(queriesJson);

		TO_MATERIALIZE = params.getBoolean("materialize");
		OPTIMIZER = params.getString("optimizer");
		STARTING_TIME_OFFSET = params.getDouble("starting_time_offset");
		STARTING_QID_OFFSET = params.getInt("starting_qid_offset");
		TOCLEANUP = params.getBoolean("tocleanup");
		TO_SERIALIZE_NUMBERS = params.getString("serialize_to");
		
		if (params.getString("to_turn_off").equalsIgnoreCase("time"))
			TO_TURN_OFF = TurnOff.TIME;
		else if (params.getString("to_turn_off").equalsIgnoreCase("interleaved"))
			TO_TURN_OFF = TurnOff.INTERLEAVED;
		else if (params.getString("to_turn_off").equalsIgnoreCase("compact"))
			TO_TURN_OFF = TurnOff.COMPACTION;
		else if (params.getString("to_turn_off").equalsIgnoreCase("none"))
			TO_TURN_OFF = TurnOff.NONE;
		else 
			throw new IllegalArgumentException(
					"to_turn_off can not have value: "
							+ params.getString("to_turn_off"));
			

		startingTime = System.nanoTime();
		qid = STARTING_QID_OFFSET;
	}

	public final int getQid() {
		return qid;
	}

	public final int getUid() {
		return queries.getUid();
	}

	public final double getTS() {
		return STARTING_TIME_OFFSET
				+ ((double) (System.nanoTime() - startingTime)) / 1000000000;
	}

	public final void next() throws UnsupportedDataTypeException {
		++qid;
	}

}
