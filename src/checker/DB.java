package checker;

import java.sql.SQLException;

/**
 * TODO: Either make this an abstract class or an interface that all database
 * instances must follow.
 * 
 * @author prasang
 */

public final class DB {

	private static Postgres mydb = null;

	/** Only one instance of the database can be instantiated at a time. */
	private DB() {
	}

	/**
	 * Currently, only PostgreSQL is supported. Thus, this method does not take
	 * any parameters.
	 * 
	 * @return Returns a database instance, {@link Postgres} as of now.
	 * 
	 * 
	 */
	public static Postgres getDB() {
		if (mydb == null) {
			try {
				mydb = new Postgres();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mydb;
	}

}
