package relation;

import java.sql.SQLException;
import java.util.ArrayList;

import checker.DB;


import utils.DataLawyerException;

public class Index extends Relation {

	private String schema;
	
	public Index(String table, String schema, Counters counters)
			throws DataLawyerException, SQLException {
		super(table, counters);
		this.schema = schema;

		ArrayList<String> columns = DB.getDB().getColumns(table, schema);
		if (columns == null)
			throw new DataLawyerException(
					"No table found: " + table);
		for (String col : columns) {
			IndexColInfo tcol = new IndexColInfo(col, this);
			Column c = new Column(tcol, this.counters);
			appendColumn(c, new ColumnOptInfo());
		}
	}

	@Override
	protected String toStringOperator(String tab) {
		return "";
	}

	public String toSqlString() {
		if (schema != null)
			return schema + "." + getName();
		return getName();
	}

}
