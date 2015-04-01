package relation;

import java.util.ArrayList;

import utils.DataLawyerException;

/**
 * {@link Op} to represent the SELECT clause in SQL.
 * 
 * It models the projection operation in relational algebra and works by only
 * permitting a subset, possibly empty, of input columns to appear in the
 * output.
 * 
 * @author prasang
 * 
 */
public class OpProject extends Op {

	public OpProject(Relation input) throws DataLawyerException {
		super("PROJECT", input.counters);
		_addInput(input);
	}

	/**
	 * This operation is not supported.
	 */
	@Override
	public final void addOperation(Operation op, ColumnOptMetadata optinfo)
			throws DataLawyerException {
		throw DataLawyerException.operationNotAllowed();
	}

	/**
	 * For ProjectOperator, we need to check if the output has the same columns
	 * as the input.
	 */
	@Override
	public boolean allOperationsEmpty() {
		if (getColumns().size() != input(0).getColumns().size())
			return false;
		for (Column inputcol : input(0).getColumns())
			if (!hasColumn(inputcol))
				return false;
		return true;
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
			if (cinfo.getInput().getInfo() instanceof DerivedColumn) {
				DerivedColumn drvdColInfo = (DerivedColumn) cinfo.getInput()
						.getInfo();
				ArrayList<Column> inputColumns = drvdColInfo.getBaseColumns();
				for (Column inC : inputColumns)
					if (input(0).hasColumn(inC))
						sourceIds.add(inC);
			}
			if (c.getInfo() instanceof ConstColumn) {
				// Do nothing.
			}

		}
		if (c.getInfo() instanceof DerivedColumn) {
			DerivedColumn drvdColInfo = (DerivedColumn) c.getInfo();
			ArrayList<Column> inputColumns = drvdColInfo.getBaseColumns();
			for (Column inC : inputColumns)
				if (input(0).hasColumn(inC))
					sourceIds.add(inC);
		}
		if (c.getInfo() instanceof ConstColumn)
			return sourceIds;
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

	@Override
	protected ArrayList<Column> getGeneratedColumns(Column c, Relation child) {
		ArrayList<Column> todelete = _getGeneratedColumns(c, child);
		for (Column cout : getColumns())
			if (cout.getInfo() instanceof AliasColInfo) {
				AliasColInfo cinfo = (AliasColInfo) cout.getInfo();
				if (c.equals(cinfo.getInput()))
					todelete.add(cout);
				else if (cinfo.getInput().getInfo() instanceof DerivedColumn) {
					DerivedColumn cinfo2 = (DerivedColumn) cinfo.getInput()
							.getInfo();
					// TODO: All this use of getBaseColumns needs to be
					// improved.
					// Right now, this assumes that the input of a DerivedColumn
					// can
					// not be a DerviedColumn.
					for (Column inputC : cinfo2.getBaseColumns())
						if (c.equals(inputC))
							todelete.add(cout);
				}
			} else if (cout.getInfo() instanceof DerivedColumn) {
				DerivedColumn cinfo = (DerivedColumn) cout.getInfo();
				for (Column inputC : cinfo.getBaseColumns())
					if (c.equals(inputC))
						todelete.add(cout);
			}
		return todelete;
	}

}