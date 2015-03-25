/**
 * 
 */
package checker;

/**
 * @author prasang
 * 
 */
public enum Logs {
	CLOCK("clock", null, "ts FLOAT8 PRIMARY KEY"),
	OUTPUT("output", "output_temp", "qid INT, otid text, reqd BOOLEAN"), 
	PROVENANCE(
			"provenance", "provenance_temp",
			"qid INT, otid text, irid text, itid TID, reqd BOOLEAN"),
	REJECTED(
			"rejects", null,
			"qid INT PRIMARY KEY, uid INT, ts FLOAT8, qstring text"),
	SCHEMA(
			"schema", "schema_temp",
			"qid INT, ocid text, icid text, irid text, "
					+ "agg BOOLEAN, reqd BOOLEAN"),
	USERS(
			"users", "users_temp",
			"qid INT PRIMARY KEY, uid INT, ts FLOAT8, "
			+ "qstring text, reqd BOOLEAN");

	public static Logs of(final String name) {
		for (Logs log : Logs.values())
			if (LogUtils.match(name, log.getName()))
				return log;
		throw new IllegalArgumentException("Unsupported log type: " + name);
	}

	private String name;
	private String schema;

	private String tempName;

	private Logs(final String name, final String tempName, final String schema) {
		if (name == null || schema == null)
			throw new IllegalStateException();
		this.name = name;
		this.tempName = tempName;
		this.schema = schema;
	}

	public String getName() {
		return name;
	}

	public String schema() {
		return schema;
	}

	public String tempName() {
		return tempName;
	}
}
