package utils;

import relation.Column;

public class DataLawyerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5489790214573688258L;

	public DataLawyerException(final String errorString) {
		super(errorString);
	}

	public static DataLawyerException operationNotAllowed() {
		return new DataLawyerException("Operation not permiited.");
	}

	public static DataLawyerException noSuchInputColumn(final Column cid) {
		return new DataLawyerException("No such input column: "
				+ cid.toString());
	}

	public static DataLawyerException logicallyImpossible() {
		return new DataLawyerException(
				"Theoretically, reaching this part of the the code is impossible.");
	}

	public static DataLawyerException incorrectParseTree(
			final String expectedTreeName) {
		return new DataLawyerException(String.format(
				"Parser error: Expected a %s clause.", expectedTreeName));
	}

}