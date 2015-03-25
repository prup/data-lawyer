package relation;

// TODO: Create an abstract SelectionOperator class and make WhereOperator and HavingOperator subclasses of it, with no additional operations.

import java.util.ArrayList;

import relation.ColumnOptInfo.Redundancy;
import utils.DataLawyerException;


public class OpWhere extends Op {

	public OpWhere(Relation input) throws DataLawyerException {
		super("WHERE", input.counters);
		_addInput(input);

		for (Column c : input.getColumns())
			appendColumn(c, new ColumnOptInfo(input.getColumnOptInfo(c)));
	}

	@Override
	public void addOperation(Operation op, ColumnOptInfo optinfo) throws DataLawyerException {
		if (!(op instanceof BinaryOperation))
			throw DataLawyerException.operationNotAllowed();
		BinaryOperation bop = (BinaryOperation) op;
		operations().add(bop);
		if (!hasColumn(bop._leftInputIndex))
			addOptColInfo(bop._leftInputIndex, new ColumnOptInfo());
		if (!hasColumn(bop._rightInputIndex))
			addOptColInfo(bop._rightInputIndex, new ColumnOptInfo());
	}

	@Override
	public void propagateRedundancyDownLocally() throws DataLawyerException {
		for (Column colId : getColumns()) {
			if (whereAppliedOnColumnByThisOperator(colId))
				setInputRedundancy(0, colId, Redundancy.False);
			else
				setInputRedundancy(0, colId, getRedundancy(colId));
		}
	}

	public boolean whereAppliedOnColumnByThisOperator(Column colId) {
		for (Operation op : operations())
			if (op.usesInput(colId))
				return true;
		return false;
	}

	@Override
	public ArrayList<Column> sourceColumns(Column colId)
			throws DataLawyerException {
		ArrayList<Column> sourceColIds = new ArrayList<Column>();
		if (input(0).hasColumn(colId))
			sourceColIds.add(colId);
		else
			throw new DataLawyerException(
					"No matching input source column found for output column with id = "
							+ colId);
		return sourceColIds;
	}

	@Override
	protected ArrayList<Column> getGeneratedColumns(Column colId, Relation child) {
		return _getGeneratedColumns(colId, child);
	}

	@Override
	protected boolean allOperationsEmpty() {
		return _allOperationsEmpty();
	}

}