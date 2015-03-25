package experiment;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utils.StringUtils;

/**
 * Reads in the description of a single query template and constructs an
 * iterator to return fully formed instances of the query.
 * 
 * @author prasang
 * 
 */
class Query implements Iterator<String> {

	private String baseString;

	private ArrayList<Object> currentContext;

	private boolean hasFinished = false;

	private boolean hasStarted = false;

	private ArrayList<String> params;
	private ArrayList<String> paramtypes;

	int uid;
	private ArrayList<Object> values;

	public Query(final String baseString, final int uid,
			final ArrayList<String> params, final ArrayList<String> values,
			final ArrayList<String> paramtypes) {
		this.baseString = baseString;
		this.uid = uid;
		this.params = params;
		this.paramtypes = paramtypes;
		this.values = new ArrayList<Object>();
		for (int i = 0; i < paramtypes.size(); ++i) {
			String paramtype = paramtypes.get(i);
			this.values.add(parseValue(paramtype, values.get(i)));
		}
		this.currentContext = new ArrayList<Object>();
		rewind();
	}

	private String getCurrentValue(final String valtype, final Object val,
			final Object currval) {
		if (valtype.equals("point"))
			return (String) val;
		else if (valtype.equals("set") || valtype.equals("range"))
			return ((ArrayList<?>) val).get((Integer) currval).toString();
		else
			throw new IllegalArgumentException("Valtype can not be: " + valtype);

	}

	@Override
	public boolean hasNext() {
		if (!hasStarted) {
			// TODO: Buggy this is.
			return true;
		}
		if (hasFinished)
			return false;

		for (int i = 0; i < values.size(); ++i) {
			Object currVal = currentContext.get(i);
			Object valRange = values.get(i);
			String valType = paramtypes.get(i);
			if (isLast(valType, valRange, currVal)) {
				continue;
			} else {
				return true;
			}
		}
		hasFinished = true;

		return false;
	}

	private Object initializeContext(final String valtype, final Object val) {
		if (valtype.equals("point"))
			return (String) val;
		else if (valtype.equals("set") || valtype.equals("range"))
			return 0;
		else
			throw new IllegalArgumentException("Valtype can not be: " + valtype);
	}

	private boolean isLast(final String valtype, final Object val,
			final Object currVal) {
		if (valtype.equals("point"))
			return true;
		if (valtype.equals("set") || valtype.equals("range"))
			return ((Integer) currVal).intValue() == ((ArrayList<?>) val)
					.size() - 1;
		else
			throw new IllegalArgumentException("Valtype can not be: " + valtype);
	}

	@Override
	public String next() {

		if (!hasStarted)
			hasStarted = true;
		else {
			for (int i = 0; i < values.size(); ++i) {
				Object currVal = currentContext.get(i);
				Object valRange = values.get(i);
				String valType = paramtypes.get(i);
				if (isLast(valType, valRange, currVal)) {
					currentContext.set(i, initializeContext(valType, valRange));
					if (i == values.size() - 1)
						hasFinished = true;
				} else {
					currentContext.set(i,
							updateCurrentContext(valType, valRange, currVal));
					break;
				}
			}
		}

		String toRet = new String(baseString);
		for (int i = 0; i < params.size(); ++i) {
			Object currVal = currentContext.get(i);
			Object valRange = values.get(i);
			String valType = paramtypes.get(i);

			toRet = toRet.replace("?" + params.get(i),
					getCurrentValue(valType, valRange, currVal));
		}
		return toRet;

	}

	private Object parseValue(final String paramtype, String string) {
		string = string.trim();
		if (paramtype.equals("point"))
			return string;
		else if (paramtype.equals("set"))
			return rangeOrSetParser(string, ',', "{}");
		else if (paramtype.equals("range")) {
			ArrayList<String> tuple = rangeOrSetParser(string, ',', "[]");
			System.out.println(tuple);
			if (tuple.size() != 3)
				throw new IllegalArgumentException(
						"Ranges have to specified as "
								+ "\"[start, end, increment (has to be positive)]\" "
								+ "and all must be numeric. "
								+ "end is not included in the answer.");
			if (StringUtils.isInteger(tuple.get(0))
					&& StringUtils.isInteger(tuple.get(1))
					&& StringUtils.isInteger(tuple.get(2))) {
				int start = Integer.parseInt(tuple.get(0));
				int end = Integer.parseInt(tuple.get(1));
				int inc = Integer.parseInt(tuple.get(2));
				if (inc <= 0)
					throw new IllegalArgumentException(
							"Increment can not be less than or equal to zero: "
									+ inc);
				ArrayList<Integer> retVal = new ArrayList<Integer>();
				for (; start < end; start += inc)
					retVal.add(start);
				return retVal;
			} else if (StringUtils.isDecimal(tuple.get(0))
					|| StringUtils.isDecimal(tuple.get(1))
					|| StringUtils.isDecimal(tuple.get(2))) {
				double start = Double.parseDouble(tuple.get(0));
				double end = Double.parseDouble(tuple.get(1));
				double inc = Double.parseDouble(tuple.get(2));
				if (inc <= 0)
					throw new IllegalArgumentException(
							"Increment can not be less than or equal to zero: "
									+ inc);
				ArrayList<Double> retVal = new ArrayList<Double>();
				for (; start < end; start += inc)
					retVal.add(start);
				return retVal;
			} else
				throw new IllegalArgumentException(
						"This is not a valid input to range: " + tuple);

		} else
			throw new IllegalArgumentException("Valtype can not be: "
					+ paramtype);
	}

	private ArrayList<String> rangeOrSetParser(String string,
			final char delimiter, final String enclosers) {
		if (string.charAt(0) != enclosers.charAt(0)
				&& string.charAt(string.length() - 1) != enclosers.charAt(1))
			throw new IllegalArgumentException(
					"set type must be eclosed in curly braces.");
		string = string.substring(1, string.length() - 1);
		String[] splitset = string.split("" + delimiter);
		ArrayList<String> setval = new ArrayList<String>();
		for (int i = 0; i < splitset.length; ++i)
			setval.add(splitset[i].trim());
		return setval;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException(
				"This is meant to be read only.");
	}

	public void rewind() {
		currentContext.clear();
		for (int i = 0; i < params.size(); ++i) {
			currentContext.add(initializeContext(paramtypes.get(i),
					values.get(i)));
		}
	}

	@Override
	public String toString() {
		return baseString + "\n" + params.toString() + "\n"
				+ paramtypes.toString() + "\n" + values.toString() + "\n"
				+ currentContext.toString();
	}

	private Object updateCurrentContext(final String valtype, final Object val,
			final Object currval) {
		if (valtype.equals("point"))
			return (String) val;
		else if (valtype.equals("set") || valtype.equals("range"))
			return (((Integer) currval) + 1) % ((ArrayList<?>) val).size();
		else
			throw new IllegalArgumentException("Valtype can not be: " + valtype);
	}

}

/**
 * Takes in a combined description of queries and iterates through the queries
 * in a round-robin fashion.
 * 
 * @author prasang
 * 
 */
class QueryIterator implements Iterator<String> {

	public static QueryIterator readFromJSON(final JSONObject queriesInJson)
			throws JSONException, FileNotFoundException {
		JSONArray json = queriesInJson.getJSONArray("content");
		ArrayList<Query> queries = new ArrayList<Query>();

		for (int i = 0; i < json.length(); ++i) {
			String baseString = json.getJSONObject(i).getString("sql");
			int uid = json.getJSONObject(i).getInt("user");
			JSONObject paramsJson = null;
			ArrayList<String> params = new ArrayList<String>();
			ArrayList<String> paramtypes = new ArrayList<String>();
			ArrayList<String> values = new ArrayList<String>();
			if (json.getJSONObject(i).has("params")) {
				paramsJson = json.getJSONObject(i).getJSONObject("params");
				for (Object key : paramsJson.keySet())
					params.add((String) key);
				for (String param : params) {
					paramtypes.add(paramsJson.getJSONObject(param).getString(
							"type"));
					values.add(paramsJson.getJSONObject(param).getString("val"));
				}
			}
			queries.add(new Query(baseString, uid, params, values, paramtypes));
		}
		return new QueryIterator(queries);
	}
	private int currIndex;
	private int currUid;

	private ArrayList<Query> queries;

	public QueryIterator(final ArrayList<Query> queries) {
		this.queries = queries;
		currIndex = 0;
		currUid = -1;
	}

	public int getUid() {
		return currUid;
	}

	@Override
	public boolean hasNext() {
		if (queries == null)
			return false;
		if (queries.isEmpty())
			return false;
		int finishedQueries = 0;
		// Current index tries to point to the location that is likely to give
		// the next query.
		int index = currIndex;
		while (true) {
			if (finishedQueries > queries.size())
				return false;
			if (queries.get(index).hasNext())
				return true;
			else {
				index = (index + 1) % queries.size();
				++finishedQueries;
			}
		}

	}

	@Override
	public String next() {
		String toRet = null;
		if (queries.get(currIndex).hasNext()) {
			toRet = queries.get(currIndex).next();
			currUid = queries.get(currIndex).uid;
			currIndex = (currIndex + 1) % queries.size();
		} else {
			int finishedQueries = 0;
			while (true) {
				if (finishedQueries > queries.size())
					break;
				currIndex = (currIndex + 1) % queries.size();
				if (queries.get(currIndex).hasNext()) {
					toRet = queries.get(currIndex).next();
					currUid = queries.get(currIndex).uid;
					currIndex = (currIndex + 1) % queries.size();
					break;
				} else
					++finishedQueries;
			}
		}
		return toRet;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
