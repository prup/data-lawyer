package relation;

import java.util.ArrayList;

import relation.ColumnOptInfo.Redundancy;
import utils.DataLawyerException;


public class OpHaving extends Op {
	public OpHaving(Op input) throws DataLawyerException {
		super("HAVING", input.counters);
		_addInput(input);

		for (Column cid : input.getColumns())
			appendColumn(cid, new ColumnOptInfo(input.getColumnOptInfo(cid)));
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

	private boolean havingAppliedOnColumnByThisOperator(Column colId) {
		for (Operation op : operations())
			if (op.usesInput(colId))
				return true;
		return false;
	}

	@Override
	public void propagateRedundancyDownLocally() throws DataLawyerException {
		for (Column colId : getColumns()) {
			if (havingAppliedOnColumnByThisOperator(colId))
				setInputRedundancy(0, colId, Redundancy.False);
			else
				setInputRedundancy(0, colId, getRedundancy(colId));
		}
	}

	@Override
	public ArrayList<Column> sourceColumns(Column colId) throws DataLawyerException {
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