package experiment;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import utils.MyLogger;

public class Benchmarker implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4290170755214824407L;
	private HashMap<String, Object> maps = new HashMap<String, Object>();

	public final void add(final String key, final double value) {
		if (!maps.containsKey(key))
			maps.put(key, 0.0);
		maps.put(key, ((Double) maps.get(key)) + value);
	}

	public final void add(final String key, final String value) {
		if (!maps.containsKey(key))
			maps.put(key, "");
		maps.put(key, ((String) maps.get(key)) + '|' + value);
	}

	public final HashMap<String, String> get() {
		HashMap<String, String> output = new HashMap<String, String>();
		for (String key : maps.keySet())
			output.put(key, maps.get(key).toString());
		return output;
	}

	public final Object get(final String key) {
		return maps.get(key);
	}

	public final void print() {
		ArrayList<String> keys = new ArrayList<String>(maps.keySet());
		Collections.sort(keys);
		for (String key : keys)
			MyLogger.println(key + " = " + maps.get(key));
	}

	public final Set<String> keySet() {
		return maps.keySet();
	}

	public static void readArrayAndPrintAverage(final String fileName,
			final ArrayList<String> attributes, final String timeseriesOutput,
			final int numOutputs, final String averageOutput)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			Object o = ois.readObject();
			if (o instanceof ArrayList<?>) {
				ArrayList<Benchmarker> exptResults = (ArrayList<Benchmarker>) o;
				Benchmarker.printAverages(exptResults, averageOutput);
				Benchmarker.printTimeSeries(attributes, exptResults,
						timeseriesOutput, numOutputs);
			} else {
				throw new IllegalArgumentException(o.getClass().getName()
						+ " is not the expected class.");
			}
		} finally {
			if (ois != null)
				ois.close();
		}

	}

	public static void printTimeSeries(final ArrayList<String> attributes,
			final ArrayList<Benchmarker> experimentNumbers,
			final String outputFilename, final int numOutputs) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					outputFilename));

			// Print header.
			bw.write("#,");
			for (String attribute : attributes)
				bw.write(attribute + ",");
			bw.write("\n");

			// Print content.
			int interval = experimentNumbers.size() / numOutputs;
			if (interval <= 0)
				interval = 1;
			int count = 0;
			int serial = 0;

			HashMap<String, Double> windowedAverage = new HashMap<String, Double>();
			for (String attribute : attributes)
				windowedAverage.put(attribute, new Double(0));

			for (Benchmarker experiment : experimentNumbers) {
				for (String attribute : attributes)
					windowedAverage.put(attribute,
							windowedAverage.get(attribute)
									+ (Double) experiment.get(attribute));
				count += 1;
				if (count == interval) {
					serial += 1;
					bw.write(serial + ",");
					for (String attribute : attributes)
						bw.write(windowedAverage.get(attribute) / count + ",");
					bw.write("\n");
					for (String attribute : attributes)
						windowedAverage.put(attribute, new Double(0));
					count = 0;
				}
			}

			if (count < interval) {
				serial += 1;
				bw.write(serial + ",");
				for (String attribute : attributes)
					bw.write(windowedAverage.get(attribute) / count + ",");
				bw.write("\n");
				for (String attribute : attributes)
					windowedAverage.put(attribute, new Double(0));
			}

			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printAverages(
			final ArrayList<Benchmarker> experimentNumbers,
			final String outputFilename) {
		HashMap<String, Double> valSum = new HashMap<String, Double>();
		HashMap<String, Double> varianceM = new HashMap<String, Double>();
		HashMap<String, Double> varianceQ = new HashMap<String, Double>();
		int count = 0;
		// TODO: TADA! This is just to get meaningful numbers. Discarding the
		// first few runs while steady state is achieved. Delete the discard
		// variable and other code that is directly dependent on it.
		int discard = (int) (experimentNumbers.size() * 0.20);
		for (Benchmarker exptNumber : experimentNumbers) {
			if (discard > 0) {
				discard -= 1;
				continue;
			}
			count += 1;
			for (String key : exptNumber.keySet()) {
				if (key.contains("not_pruned_policy"))
					continue;
				if (!valSum.containsKey(key))
					valSum.put(key, 0.0);
				if (!varianceM.containsKey(key))
					varianceM.put(key, 0.0);
				if (!varianceQ.containsKey(key))
					varianceQ.put(key, 0.0);
				Object toPrint = exptNumber.get(key);
				if (toPrint instanceof Double) {
					double val = (Double) toPrint;
					double oldSum = valSum.get(key);
					double oldM = varianceM.get(key);
					double oldQ = varianceM.get(key);
					valSum.put(key, oldSum + val);
					varianceM.put(key, oldM + (val - oldM) / count);
					varianceQ.put(key, oldQ
							+ ((count - 1) * (val - oldM) * (val - oldM))
							/ count);
				}
			}
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					outputFilename));

			ArrayList<String> keysToPrint = new ArrayList<String>(
					valSum.keySet());
			Collections.sort(keysToPrint);

			List<String> rowDescriptions = new ArrayList<String>();

			// Print the headers.
			rowDescriptions.add("headers");
			for (String key : keysToPrint)
				bw.write(key + ",");
			bw.write("\n");

			// Print the averages.
			rowDescriptions.add("averages");
			for (String key : keysToPrint) {
				double mean = valSum.get(key) / count;
				MyLogger.println(key + ": " + mean);
				bw.write(mean + ",");
			}
			bw.write("\n");

			// Print the standard variance.
			rowDescriptions.add("variance");
			for (String key : keysToPrint) {
				double variance = varianceQ.get(key) / count;
				bw.write(variance + ",");
			}
			bw.write("\n");

			// Print the numbers for the first query.
			rowDescriptions.add("firstQuery");
			Benchmarker experiment = experimentNumbers.get(0);
			for (String key : keysToPrint)
				bw.write(experiment.get(key) + ",");
			bw.write("\n");

			// Print the numbers for the last query.
			rowDescriptions.add("lastQuery");
			experiment = experimentNumbers.get(experimentNumbers.size() - 1);
			for (String key : keysToPrint)
				bw.write(experiment.get(key) + ",");
			bw.write("\n");

			// Print the row descriptions.
			for (String row : rowDescriptions)
				bw.write(row + ",");
			bw.write("\n");

			// Print number of data points.
			bw.write("NumberOfQueries," + count);

			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}