package relation;

import java.util.ArrayList;

import relation.ColumnOptInfo.Redundancy;
import utils.DataLawyerException;


public class OpGroup extends Op {

	// Indicates the total number of grouping columns.
	public int nGroupingColumns = 0;

	public OpGroup(Relation op) throws DataLawyerException {
		super("GROUP", op.counters);
		_addInput(op);

		// Since all input columns will be part of the output, we copy them to
		// the output during construction. We reorder the columns as we come to
		// know of which columns are the grouping columns.
		for (Column cid : op.getColumns())
			appendColumn(cid, new ColumnOptInfo(op.getColumnOptInfo(cid)));
	}

	/**
	 * Grouping columns have to be called in order. The function rearranges the
	 * columns so that the grouping columns are in the front and in the correct
	 * order.
	 * 
	 * @param cId
	 * @throws DataLawyerException
	 */
	public void addGroupingColumn(Column cId) throws DataLawyerException {
		if (!(cId.getInfo() instanceof DerivedColumn) && !hasColumn(cId))
			throw new DataLawyerException(
					"No such grouping column is present in the input: " + cId
							+ " " + cId.getInfo().getClass().getSimpleName() + "\n" + this.inputs());
		reorderColumn(cId, nGroupingColumns);
		++nGroupingColumns;
	}

	@Override
	public void addOperation(Operation op, ColumnOptInfo optinfo) {
		// We do not mix the grouping and the aggregation operations.

		// Check that the operation is a unary aggregation operation.

		// Check if the operation has already been added.
	}

	@Override
	public void propagateRedundancyDownLocally() throws DataLawyerException {
		boolean aggregateRelevant = false;

		ArrayList<Column> columnsToCheck = new ArrayList<Column>();
		
		// Assert that none of the inputs are DerivedColumns, they should not be.
		for (Column c : input(0).getColumns()) 
			if (c.getInfo() instanceof DerivedColumn)
				throw new DataLawyerException("Invalid tree structure. OpGroup's input can not contain any unaliased DerivedColumn: " + c);

		for (int i = nGroupingColumns; i < getColumns().size(); ++i) {
			Column colId = getColumn(i);

			// We go for this complex code since DerivedColumns may only exist
			// in the OpGroup and not in its input. That is, the input might
			// only have the raw inputs.
			
			if (input(0).hasColumn(colId))
				columnsToCheck.add(colId);
			else if (colId.getInfo() instanceof DerivedColumn) {
				columnsToCheck = ((DerivedColumn) colId.getInfo())
						.getBaseColumns();
				for (int last = columnsToCheck.size() - 1; last >= 0; --last)
					if (columnsToCheck.get(last).getInfo() instanceof ConstColumn)
						columnsToCheck.remove(last);
			} else {
				throw new DataLawyerException("Unsupported column type: "
						+ colId.getInfo().getClass().getSimpleName());
			}

			for (Column colToCheck : columnsToCheck) {
				setInputRedundancy(0, colToCheck, getRedundancy(colId));
				if (getRedundancy(colToCheck) != Redundancy.True)
					aggregateRelevant = true;
			}
		}
		
		boolean someGroupingColumnRelevant = false;
		for (int i = 0; i < nGroupingColumns; ++i) {
			Column colId = getColumn(i);
			Redundancy redundancy = getRedundancy(colId);
			if (redundancy.equals(Redundancy.False)) {
				someGroupingColumnRelevant = true;
				break;
			}
		}
		
		if (aggregateRelevant || someGroupingColumnRelevant) {
			for (int i = 0; i < nGroupingColumns; ++i)
				setRedundancy(getColumn(i), Redundancy.False);
		}


		for (int i = 0; i < nGroupingColumns; ++i) {
			Column colId = getColumn(i);
			
			Redundancy redundancy = getRedundancy(colId);
			
			columnsToCheck.clear();
			if (input(0).hasColumn(colId))
				columnsToCheck.add(colId);
			else if (colId.getInfo() instanceof DerivedColumn) {
				columnsToCheck = ((DerivedColumn) colId.getInfo())
						.getBaseColumns();
				for (int last = columnsToCheck.size() - 1; last >= 0; --last)
					if (columnsToCheck.get(last).getInfo() instanceof ConstColumn)
						columnsToCheck.remove(last);
			} else {
				throw new DataLawyerException("Unsupported column type: "
						+ colId.getInfo().getClass().getSimpleName());
			}

			for (Column colToCheck : columnsToCheck)
				setInputRedundancy(0, colToCheck, redundancy);
		}

		// If no aggregation is done in the future, grouping is redundant.
		if (!aggregateRelevant && !someGroupingColumnRelevant)
			nGroupingColumns = 0;

	}

	@Override
	public boolean allOperationsEmpty() {
		return (nGroupingColumns == 0);
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
		ArrayList<Column> columns_to_delete = new ArrayList<Column>();
		for (int i = 0; i < getColumns().size(); ++i) {
			if (getColumn(i).equals(colId)) {
				columns_to_delete.add(getColumn(i));
				if (i < nGroupingColumns)
					--nGroupingColumns;
			}
		}
		return columns_to_delete;
	}

}