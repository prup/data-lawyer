package utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

	private StringUtils() {
	}

	public static String join(final List<String> l, final String delim) {
		if (l.size() == 0)
			return "";
		StringBuffer sbuf = new StringBuffer();
		for (String s: l)
			sbuf.append(s + delim);
		return sbuf.substring(0, sbuf.length() - delim.length());
	}
	
	public static void main(final String[] args) {
		ArrayList<String> test = new ArrayList<String>();
		String delim = ", ";
		System.out.println(StringUtils.join(test, delim));
		test.add("1");
		System.out.println(StringUtils.join(test, delim));
		test.add("2");
		System.out.println(StringUtils.join(test, delim));
	}
	
	public static boolean isInteger(final String str) {
		return str.matches("-?\\d+"); // match a number with optional '-' and
										// decimal.
	}

	public static boolean isDecimal(final String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional
												// '-' and decimal.
	}

	public static boolean isVarchar(final String str) {
		if (str.length() >= 2)
			return (str.charAt(0) == '\'' && str.charAt(str.length() - 1) == '\'');
		return false;
	}

	public static String stripSingleQuotes(final String str) {
		return str.substring(1, str.length() - 1);
	}

	public static boolean isBoolean(final String str) {
		return (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false"));
	}

}
