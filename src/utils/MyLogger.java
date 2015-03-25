package utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {
	
	public static void println(final Object o) {
		if (toPrint)
			System.out.println(o);
	}
	
	public static void println() {
		if (toPrint)
			System.out.println();
	}

	private static Logger LOGGER;
	
	private static Logger SQLLOGGER;
	
	private static boolean toPrint = true;
	
	public static Logger getLog() {
		if (LOGGER == null) {
			LOGGER = Logger.getLogger("Info logging");
			FileHandler fh = null;
			try {
				fh = new FileHandler("log/dum.log", 100000, 1, false);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fh.setFormatter(new SimpleFormatter());
			
			LOGGER.setUseParentHandlers(false);
			LOGGER.addHandler(fh);
		}
		return LOGGER;
	} 
	
	public static void logSQL(final String sql) {
		
		if (SQLLOGGER == null) {
			SQLLOGGER = Logger.getLogger("SQL logging");
			FileHandler fh = null;
			try {
				fh = new FileHandler("log/sql.log", 100000, 1, false);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fh.setFormatter(new SimpleFormatter());
			
			SQLLOGGER.setUseParentHandlers(false);
			SQLLOGGER.addHandler(fh);
		}
		// SQLLOGGER.info(sql + ";");
		
	}
	
}
