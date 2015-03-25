package checker;

import java.sql.SQLException;

/**
 * TODO: Make and fix this API. Also, make DB_Pgsql and DB_sqlserver nested
 * classes here.
 * 
 * @author prasang
 */

public final class DB {

	private static Postgres mydb = null;

	private DB() {
	}

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
