package relation;

import java.util.ArrayList;

import relation.ColumnOptMetadata.Redundancy;
import relation.Operation.OpType;
import utils.DataLawyerException;

/**
 * Abstract class to model an operator. Requires as input a set of operations
 * and a set of inputs.
 * 
 * This formulation of the Operator allows us to create super-operators. This is
 * probably useful for representing unnormalized Datalog programs.
 * 
 * @author prasang
 * 
 */
public abstract class Op extends Relation {

	private ArrayList<Relation> _inputs = new ArrayList<Relation>();
	private ArrayList<Operation> _operations = new ArrayList<Operation>();

	public Op(String name, Counters counters) throws DataLawyerException {
		super(name, counters);
	}

	protected final void _addInput(Relation input) throws DataLawyerException {
		if (input != null) {
			if (!input.counters.equals(this.counters))
				throw new DataLawyerException(
						"Adding input with an incompatible counter.");
			_inputs.add(input);
			input.setParent(this);
		}
	}

	/**
	 * Checks if the current operator is doing no operation on the input
	 * relation(s). The implementations are very specific to the operator being
	 * used.
	 * 
	 * @return
	 */
	protected final boolean _allOperationsEmpty() {
		return operations().isEmpty();
	}

	/**
	 * Given the input column, figure out the output columns that are
	 * contributed to by the input column.
	 * 
	 * @param c
	 * @param child
	 * @return
	 */
	protected final ArrayList<Column> _getGeneratedColumns(Column c,
			Relation child) {
		ArrayList<Column> cols_to_delete = new ArrayList<Column>();
		for (Column cid : getColumns())
			if (cid.equals(c))
				cols_to_delete.add(cid);
		return cols_to_delete;
	}

	public abstract void addOperation(Operation op, ColumnOptMetadata optinfo)
			throws DataLawyerException;

	protected abstract boolean allOperationsEmpty();

	public final void deleteInputColumnRecursive(Column colId, Relation input)
			throws DataLawyerException {

		ArrayList<Operation> opsToDelete = getOperationsToDelete(colId, input);

		for (Operation op : opsToDelete)
			_operations.remove(op);

		// In the case of joins, there are implicit equality predicates which
		// may be lost if we naively delete the equality predicate related to a
		// deleted column.
		if (this instanceof OpJoin) {
			// TODO: Will fail in cases where the equality is done on derived
			// columns or where an operation other than equality is used.
			for (int i = 0; i < opsToDelete.size(); ++i) {
				BinaryOperation bopFirst = (BinaryOperation) opsToDelete.get(i);
				if (bopFirst._op != OpType.EQ)
					continue;
				Column otherColumnFirst = null;
				if (bopFirst._leftInputIndex.equals(colId))
					otherColumnFirst = bopFirst._rightInputIndex;
				else if (bopFirst._rightInputIndex.equals(colId))
					otherColumnFirst = bopFirst._leftInputIndex;
				else
					throw new IllegalArgumentException(
							"Weird comparison in theh join predicate.");
				for (int j = i + 1; j < opsToDelete.size(); ++j) {
					BinaryOperation bopSecond = (BinaryOperation) opsToDelete
							.get(j);
					if (bopSecond._op != OpType.EQ)
						continue;
					Column otherColumnSecond = null;
					if (bopSecond._leftInputIndex.equals(colId))
						otherColumnSecond = bopSecond._rightInputIndex;
					else if (bopSecond._rightInputIndex.equals(colId))
						otherColumnSecond = bopSecond._leftInputIndex;
					else
						throw new IllegalArgumentException(
								"Weird comparison in theh join predicate.");
					boolean exists = false;
					for (Operation op : operations()) {
						if (op._op != Operation.OpType.EQ)
							continue;
						BinaryOperation bop = (BinaryOperation) op;
						if (bop._leftInputIndex.equals(otherColumnFirst)
								&& bop._rightInputIndex
										.equals(otherColumnSecond)
								|| bop._leftInputIndex
										.equals(otherColumnSecond)
								&& bop._rightInputIndex
										.equals(otherColumnFirst)) {
							exists = true;
							break;
						}
					}
					if (exists)
						continue;
					this.addOperation(Operation.getBinary("=",
							otherColumnFirst, otherColumnSecond),
							new ColumnOptMetadata());
				}
			}
		}

		for (Column cid : getGeneratedColumns(colId, input)) {
			deleteColumn(cid);
			if (_parent != null)
				_parent.deleteInputColumnRecursive(cid, this);
		}

		if (allOperationsEmpty() && !(this instanceof OpProject)
				&& !(this instanceof OpJoin)) // Remove this operator.
			_parent.replaceInput(this, this.input(0));
	}

	/**
	 * Mostly used by the join.
	 * 
	 * @param colId
	 * @return
	 */
	public final int findInputRelation(Column colId) {
		for (int iInput = 0; iInput < _inputs.size(); ++iInput)
			if (_inputs.get(iInput).hasColumn(colId))
				return iInput;
		return -1;
	}

	protected abstract ArrayList<Column> getGeneratedColumns(Column colId,
			Relation input);

	/**
	 * Given the input column, figure out the operations that make use of the
	 * column.
	 * 
	 * @param colId
	 * @param input
	 * @return
	 */
	private final ArrayList<Operation> getOperationsToDelete(Column colId,
			Relation input) {
		ArrayList<Operation> ops_to_delete = new ArrayList<Operation>();
		for (Operation op : _operations)
			if (op.usesInput(colId))
				ops_to_delete.add(op);
		return ops_to_delete;
	}

	public final Relation input(int index) {
		return _inputs.get(index);
	}

	public ArrayList<Relation> inputs() {
		return _inputs;
	}

	public final int numInputs() {
		return _inputs.size();
	}

	public ArrayList<Operation> operations() {
		return _operations;
	}

	public abstract void propagateRedundancyDownLocally()
			throws DataLawyerException;

	// Replaces the input child Relation at index childId by the Relation
	// newInput.
	public final void replaceInput(Relation oldChild, Relation newChild) {
		for (int i = 0; i < _inputs.size(); ++i)
			if (_inputs.get(i).equals(oldChild)) {
				_inputs.remove(i);
				_inputs.add(i, newChild);
				newChild.setParent(this);

				// If the old child's parent is myself, only then make it null.
				// Ideally this operation should be atomic.
				if (oldChild._parent.equals(this))
					oldChild.setParent(null);
			}
	}

	/**
	 * We check if the column has not been set redundant (due to another output
	 * column). If so, we don't modify it's redundancy.
	 * 
	 * @param iInput
	 * @param c
	 * @param redundancy
	 * @throws DataLawyerException
	 */
	protected final void setInputRedundancy(int iInput, Column c,
			Redundancy redundancy) throws DataLawyerException {
		// Handle complex columns.
		ArrayList<Column> inputColumns = _inputs.get(iInput).getColumns();
		if (inputColumns.contains(c)) {
			if (_inputs.get(iInput).getRedundancy(c) != Redundancy.False)
				_inputs.get(iInput).setRedundancy(c, redundancy);
		} else if (c.getInfo() instanceof DerivedColumn) {

		}
	}

	/**
	 * Get all the input column ids that contribute to the output column id
	 * passed in as a parameter.
	 * 
	 * @param colId
	 *            : Output column id.
	 * @return
	 * @throws DataLawyerException
	 */
	public abstract ArrayList<Column> sourceColumns(Column colId)
			throws DataLawyerException;

	@Override
	protected String toStringOperator(String tab) {
		String output = " [";
		for (Operation op : _operations)
			output += op.toString();
		output += "]";
		for (Relation r : _inputs)
			output += "\n" + r.toStringTabbed(tab + _TAB);
		return output;
	}

	public void deleteInput(Relation toDelete, boolean recursive)
			throws DataLawyerException {
		inputs().remove(toDelete);
		toDelete._parent = null;
		if (_parent == null)
			return;
		if (numInputs() == 0) {
			for (Column column : getColumns())
				_parent.deleteInputColumnRecursive(column, this);
			_parent.deleteInput(this, true);
		}
	}

}
