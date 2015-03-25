package relation;

import java.util.ArrayList;

public abstract class UnaryOperation extends Operation {
	public final Column _inputIndex;

	public String toString() {
		return String.format("(%s %s)", opToString(), _inputIndex.toString());
	}

	public UnaryOperation(OpType op, Column inputColumnIndex) {
		_op = op;
		_inputIndex = inputColumnIndex;
	}
	
	public final int numOperands() {
		return 1;
	}
	
	@Override
	public boolean equals(Object op) {
		if (this == op)
			return true;
		if (op == null)
			return false;
		if (!(op instanceof UnaryOperation))
			return false;
		return (((UnaryOperation) op)._inputIndex == this._inputIndex && ((UnaryOperation) op)._op == this._op);
	}
	
	@Override
	public int hashCode() {
		return _inputIndex.hashCode() ^ _op.hashCode();
	}
	
	public boolean usesInput(Column cid) {
		if (_inputIndex.equals(cid))
			return true;
		
		if (_inputIndex.getInfo() instanceof DerivedColumn) {
			DerivedColumn drvdColInfo = (DerivedColumn) _inputIndex.getInfo();
			ArrayList<Column> baseColumns = drvdColInfo.getBaseColumns();
			for (Column c : baseColumns)
				if (c.equals(cid))
					return true;
		}
		
		return false;
	}
	
	@Override
	public final String toSqlString() {
		return String.format("%s(%s)", _op.toString(), _inputIndex.toSqlString());
	}
	
	@Override
	public final boolean equalsLogically(Operation op) {
		if (op == this)
			return true;
		if (op == null)
			return false;
		if (!(op instanceof UnaryOperation))
			return false;
		UnaryOperation uop = (UnaryOperation) op;
		return _inputIndex.equalsLogically(uop._inputIndex) && _op.equals(uop._op);
	}

}

class MinOperation extends UnaryOperation {
	public MinOperation(OpType op, Column inputColumnIndex) {
		super(op, inputColumnIndex);
	}
}

class MaxOperation extends UnaryOperation {
	public MaxOperation(OpType op, Column inputColumnIndex) {
		super(op, inputColumnIndex);
	}
}

class SumOperation extends UnaryOperation {
	public SumOperation(OpType op, Column inputColumnIndex) {
		super(op, inputColumnIndex);
	}
}

class AvgOperation extends UnaryOperation {
	public AvgOperation(OpType op, Column inputColumnIndex) {
		super(op, inputColumnIndex);
	}
}

class CountOperation extends UnaryOperation {
	public CountOperation(OpType op, Column inputColumnIndex) {
		super(op, inputColumnIndex);
	}
}

class DistinctOperation extends UnaryOperation {
	public DistinctOperation(OpType op, Column inputColumnIndex) {
		super(op, inputColumnIndex);
	}
}

class ProvOperation extends UnaryOperation {
	public ProvOperation(OpType op, Column inputColumnIndex) {
		super(op, inputColumnIndex);
	}
}