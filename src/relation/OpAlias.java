package relation;

import java.util.ArrayList;

import utils.DataLawyerException;


public class OpAlias extends Op {

	public OpAlias(Relation input, String alias) throws DataLawyerException {
		super(alias, input.counters);
		_addInput(input);
		for (Column c : input.getColumns())
			appendAfterAliasing(c, input.getColumnOptInfo(c));
	}

	public final void appendAfterAliasing(Column inputcolumn,
			ColumnOptInfo optinfo) {
		// TODO: Also if inputColumn is of type that has no implicit output name
		// (like Aggregates and Functions), assign a name automatically. Since
		// the underlying Op must be OpProject rename inside the operator.
		Column newCol = Column.getAliasedColumn(this, inputcolumn.getInfo()
				.getNameUnAliased(), inputcolumn, counters, false);
		appendColumn(newCol, new ColumnOptInfo(optinfo));
	}

	@Override
	public void addOperation(Operation op, ColumnOptInfo optinfo)
			throws DataLawyerException {
		throw new DataLawyerException("Operation denied.");
	}

	@Override
	public boolean allOperationsEmpty() {
		return (numInputs() == 0);
	}

	@Override
	public ArrayList<Column> sourceColumns(Column c) throws DataLawyerException {
		ArrayList<Column> sourceIds = new ArrayList<Column>();
		if (input(0).hasColumn(c))
			sourceIds.add(c);
		if (c.getInfo() instanceof AliasColInfo) {
			AliasColInfo cinfo = (AliasColInfo) c.getInfo();
			if (input(0).hasColumn(cinfo.getInput()))
				sourceIds.add(cinfo.getInput());
		}
		if (sourceIds.isEmpty())
			throw DataLawyerException.noSuchInputColumn(c);
		return sourceIds;
	}

	@Override
	public void propagateRedundancyDownLocally() throws DataLawyerException {
		for (Column c : getColumns())
			for (Column inputcols : sourceColumns(c))
				setInputRedundancy(0, inputcols, getRedundancy(c));
	}

	public String toSqlString() throws DataLawyerException {
		String subquery = SQLUtils.convertToSQL(input(0));
		subquery = subquery.replaceAll("\n", "\n\t");
		if (input(0) instanceof Index)
			return String.format("\t %s as %s", subquery, getName());
		else
			return String.format("\t(%s) as %s", subquery, getName());
	}

	@Override
	protected ArrayList<Column> getGeneratedColumns(Column c, Relation child) {
		ArrayList<Column> todelete = _getGeneratedColumns(c, child);
		for (Column cout : getColumns())
			if (cout.getInfo() instanceof AliasColInfo) {
				AliasColInfo cinfo = (AliasColInfo) cout.getInfo();
				if (c.equals(cinfo.getInput()))
					todelete.add(cout);
			}
		return todelete;
	}

}
