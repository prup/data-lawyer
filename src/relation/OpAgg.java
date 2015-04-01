package relation;

import java.util.ArrayList;

import utils.DataLawyerException;

/**
 * {@link Op} to represent various aggregation operations defined as
 * {@link UnaryOperation}.
 * 
 * @author prasang
 * 
 */
public class OpAgg extends Op {

	public OpAgg(Relation op) throws DataLawyerException {
		super("AGGREGATE", op.counters);
		_addInput(op);

		// We assume that the query does not aggregate on the grouping columns
		// and that it never projects out the grouping column.
		if (op instanceof OpGroup) {
			OpGroup gOp = (OpGroup) op;
			for (Column c : gOp.getColumns().subList(0, gOp.nGroupingColumns))
				appendColumn(c, new ColumnOptMetadata(gOp.getColumnOptInfo(c)));
		}
	}

	/**
	 * Given an aggregation operation, check if it truly is an aggregation
	 * operation and then add the aggregated operator to the output and the
	 * columnReferenceTable.
	 */
	@Override
	public void addOperation(Operation op, ColumnOptMetadata optinfo)
			throws DataLawyerException {
		if (op.numOperands() > 1)
			throw new DataLawyerException(
					"Can not add binary operations to the aggregate operator.");
		AggColInfo cinfo = new AggColInfo((UnaryOperation) op);
		Column c = new Column(cinfo, counters);
		operations().add(op);
		appendColumn(c, new ColumnOptMetadata(optinfo));
	}

	public boolean aggregatedByThisOperator(Column colId) {
		ColumnMetadata col = colId.getInfo();
		if (col instanceof AggColInfo)
			return operations().contains(((AggColInfo) col)._op);
		return false;
	}

	@Override
	public void propagateRedundancyDownLocally() throws DataLawyerException {

		for (Column outputColId : getColumns()) {
			Column inputColId = outputColId;
			if (aggregatedByThisOperator(outputColId)) {
				inputColId = ((AggColInfo) outputColId.getInfo())
						.getSourceColumn();

				if (inputColId.getInfo() instanceof DerivedColumn) {
					DerivedColumn drvdColInfo = (DerivedColumn) inputColId
							.getInfo();
					ArrayList<Column> inputColumns = drvdColInfo
							.getBaseColumns();
					for (Column inC : inputColumns)
						if (!(inC.getInfo() instanceof ConstColumn))
							setInputRedundancy(0, inC,
									getRedundancy(outputColId));
				} else
					setInputRedundancy(0, inputColId,
							getRedundancy(outputColId));

			} else
				setInputRedundancy(0, inputColId, getRedundancy(outputColId));
		}
	}

	@Override
	public ArrayList<Column> sourceColumns(Column colId)
			throws DataLawyerException {

		ArrayList<Column> sourceColIds = new ArrayList<Column>();
		if (aggregatedByThisOperator(colId)) {
			Column sourceColId = ((AggColInfo) colId.getInfo())
					.getSourceColumn();
			if (sourceColId.getInfo() instanceof DerivedColumn) {
				DerivedColumn drvdColInfo = (DerivedColumn) sourceColId
						.getInfo();
				for (Column srcCol : drvdColInfo.getBaseColumns())
					if (!(srcCol.getInfo() instanceof ConstColumn))
						sourceColIds.add(srcCol);
			} else
				sourceColIds.add(sourceColId);

		} else if (input(0).hasColumn(colId))
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
		for (Column cid : getColumns()) {
			// If the column is copied directly to the output, delete it.
			if (cid.equals(colId))
				columns_to_delete.add(cid);
			else {
				// If not directly copied, it must participate in an aggregate.
				ColumnMetadata col = cid.getInfo();
				if (col instanceof AggColInfo) {
					AggColInfo aggCol = (AggColInfo) col;
					if (aggCol._op.usesInput(colId))
						columns_to_delete.add(cid);
				}
			}
		}
		return columns_to_delete;
	}

	@Override
	protected boolean allOperationsEmpty() {
		return _allOperationsEmpty();
	}

}