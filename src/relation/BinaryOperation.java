package relation;

import java.util.ArrayList;

/**
 * Abstract representation of a binary operation.
 * 
 * @author prasang
 * 
 */
public abstract class BinaryOperation extends Operation {
	public final Column _leftInputIndex;
	public final Column _rightInputIndex;

	public BinaryOperation(final OpType op, final Column leftInput,
			final Column rightInput) {
		_op = op;
		_leftInputIndex = leftInput;
		_rightInputIndex = rightInput;
	}

	public final String toString() {
		return String.format("(%s %s %s)", opToString(),
				_leftInputIndex.toString(), _rightInputIndex.toString());
	}

	public final int numOperands() {
		return 2;
	}

	@Override
	public final boolean equals(final Object op) {
		if (op == this)
			return true;
		if (op == null)
			return false;
		if (!(op instanceof BinaryOperation))
			return false;
		return (((BinaryOperation) op)._leftInputIndex == this._leftInputIndex
				&& ((BinaryOperation) op)._rightInputIndex == this._rightInputIndex && ((BinaryOperation) op)._op == this._op);
	}

	@Override
	public final int hashCode() {
		return _leftInputIndex.hashCode() ^ _rightInputIndex.hashCode()
				^ _op.hashCode();
	}

	public final boolean usesInput(final Column cid) {
		if (_leftInputIndex.equals(cid) || _rightInputIndex.equals(cid))
			return true;

		if (_leftInputIndex.getInfo() instanceof DerivedColumn) {
			DerivedColumn drvdColInfo = (DerivedColumn) _leftInputIndex
					.getInfo();
			ArrayList<Column> baseColumns = drvdColInfo.getBaseColumns();
			for (Column c : baseColumns)
				if (c.equals(cid))
					return true;
		}

		if (_rightInputIndex.getInfo() instanceof DerivedColumn) {
			DerivedColumn drvdColInfo = (DerivedColumn) _rightInputIndex
					.getInfo();
			ArrayList<Column> baseColumns = drvdColInfo.getBaseColumns();
			for (Column c : baseColumns)
				if (c.equals(cid))
					return true;
		}

		return false;
	}

	@Override
	public final String toSqlString() {
		return String.format("%s %s %s", _leftInputIndex.toSqlString(),
				_op.toString(), _rightInputIndex.toSqlString());
	}

	@Override
	public boolean equalsLogically(final Operation op) {
		if (op == this)
			return true;
		if (op == null)
			return false;
		if (!(op instanceof BinaryOperation))
			return false;
		BinaryOperation bop = (BinaryOperation) op;
		return _leftInputIndex.equalsLogically(bop._leftInputIndex)
				&& _rightInputIndex.equalsLogically(bop._rightInputIndex)
				&& _op.equals(bop._op);
	}

}

class Commutative extends BinaryOperation {
	public Commutative(final OpType op, final Column leftInput,
			final Column rightInput) {
		super(op, leftInput, rightInput);
	}

	@Override
	public final boolean equalsLogically(final Operation op) {
		if (op == this)
			return true;
		if (op == null)
			return false;
		if (!(op instanceof BinaryOperation))
			return false;
		BinaryOperation bop = (BinaryOperation) op;
		return ((_leftInputIndex.equalsLogically(bop._leftInputIndex) && _rightInputIndex
				.equalsLogically(bop._rightInputIndex)) || (_leftInputIndex
				.equalsLogically(bop._rightInputIndex) && _rightInputIndex
				.equalsLogically(bop._leftInputIndex)))
				&& _op.equals(bop._op);
	}
}

class EqOperation extends Commutative {
	public EqOperation(final OpType op, final Column leftInput,
			final Column rightInput) {
		super(op, leftInput, rightInput);
	}
}

class LikeOperation extends Commutative {
	public LikeOperation(final OpType op, final Column leftInput,
			final Column rightInput) {
		super(op, leftInput, rightInput);
	}
}

class NeqOperation extends Commutative {
	public NeqOperation(final OpType op, final Column leftInput,
			final Column rightInput) {
		super(op, leftInput, rightInput);
	}
}

class LtOperation extends BinaryOperation {
	public LtOperation(final OpType op, final Column leftInput,
			final Column rightInput) {
		super(op, leftInput, rightInput);
	}
}

class GtOperation extends BinaryOperation {
	public GtOperation(final OpType op, final Column leftInput,
			final Column rightInput) {
		super(op, leftInput, rightInput);
	}
}

class LeqOperation extends BinaryOperation {
	public LeqOperation(final OpType op, final Column leftInput,
			final Column rightInput) {
		super(op, leftInput, rightInput);
	}
}

class GeqOperation extends BinaryOperation {
	public GeqOperation(final OpType op, final Column leftInput,
			final Column rightInput) {
		super(op, leftInput, rightInput);
	}
}
