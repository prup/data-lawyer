package relation;

import java.util.ArrayList;
import java.util.HashMap;

import relation.ColumnOptMetadata.Redundancy;
import utils.DataLawyerException;

/**
 * {@link Op} to represent the JOIN clause in SQL.
 * 
 * It can model a multi-way equijoin operator.
 * 
 * @author prasang
 * 
 */
public class OpJoin extends Op {

	private HashMap<Operation, ArrayList<Column>> operationRemover = new HashMap<Operation, ArrayList<Column>>();

	public OpJoin(Relation input1, Relation input2) throws DataLawyerException {
		super("JOIN", input1.counters);
		if (input1 == null || input2 == null)
			throw new DataLawyerException(
					"Join operator requires at least two inputs.");
		addInput(input1);
		addInput(input2);
	}

	public void addInput(Relation input) throws DataLawyerException {
		// Add the input relation as an operand.
		_addInput(input);

		// Add the columns of the input relation to the output.
		for (Column c : input.getColumns())
			appendColumn(c, new ColumnOptMetadata(input.getColumnOptInfo(c)));
	}

	@Override
	public void addOperation(Operation op, ColumnOptMetadata optinfo) {
		operations().add(op);
		operationRemover.put(op, new ArrayList<Column>());
	}

	private boolean colUsedInThisJoin(Column colId) {
		for (Operation op : operations())
			if (op.usesInput(colId))
				return true;
		return false;
	}

	@Override
	public void propagateRedundancyDownLocally() throws DataLawyerException {
		for (Column colId : getColumns()) {
			int inputRelation = findInputRelation(colId);
			if (colUsedInThisJoin(colId))
				setInputRedundancy(inputRelation, colId, Redundancy.False);
			else
				setInputRedundancy(inputRelation, colId, getRedundancy(colId));
		}

	}

	@Override
	public ArrayList<Column> sourceColumns(Column colId)
			throws DataLawyerException {
		ArrayList<Column> sourceColIds = new ArrayList<Column>();
		for (int iInput = 0; iInput < numInputs(); ++iInput)
			if (input(iInput).hasColumn(colId))
				sourceColIds.add(colId);
		
		if (sourceColIds.size() == 0)
			throw new DataLawyerException(
					"No matching input source column found for output column with id = "
							+ colId);
		return sourceColIds;
	}

	@Override
	protected ArrayList<Column> getGeneratedColumns(Column colId, Relation childId) {
		return _getGeneratedColumns(colId, childId);
	}

	@Override
	protected boolean allOperationsEmpty() {
		return _allOperationsEmpty();
	}

}