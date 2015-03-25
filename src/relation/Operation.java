package relation;

import utils.DataLawyerException;

/**
 * Making the _inputIndices final for safety. We do not expect to change it once
 * we have initialized it. Note that this contract only makes sense when
 * _inputColumns themselves do not change in the class AST. So it is necessary
 * to check that they are also final.
 */
public abstract class Operation {
	
	// What about + and -?
	
	public enum OpType {
		LIKE, EQ, NEQ, LT, GT, LEQ, GEQ, MAX, MIN, SUM, AVG, COUNT, DISTINCT, PROV;

		@Override
		public final String toString() {
			switch (this) {
			case LIKE: return "like";
			case EQ	: return "=";
			case NEQ: return "<>";
			case LT	: return "<";
			case GT	: return ">";
			case LEQ: return "<=";
			case GEQ: return ">=";
			case MAX: return "max";
			case MIN: return "min";
			case SUM: return "sum";
			case AVG: return "avg";
			case COUNT: return "count";
			case DISTINCT: return "distinct";
			case PROV: return "public.prov";
			default: return null;
			}
		}
	}
	

	public OpType _op;

	public static UnaryOperation getUnary(String op, Column inputColumnIndex)
			throws DataLawyerException {
		op = op.toLowerCase();
		if (op.equals("max"))
			return new MaxOperation(OpType.MAX, inputColumnIndex);
		else if (op.equals("min"))
			return new MinOperation(OpType.MIN, inputColumnIndex);
		else if (op.equals("sum"))
			return new SumOperation(OpType.SUM, inputColumnIndex);
		else if (op.equals("avg"))
			return new AvgOperation(OpType.AVG, inputColumnIndex);
		else if (op.equals("count"))
			return new CountOperation(OpType.COUNT, inputColumnIndex);
		else if (op.equals("distinct"))
			return new DistinctOperation(OpType.DISTINCT, inputColumnIndex);
		else if (op.equals("public.prov"))
			return new ProvOperation(OpType.PROV, inputColumnIndex);
		else
			throw new DataLawyerException(
					"This operator is not supported or is not unary: " + op);
	}
	
	public static boolean IsAggregate(String op) {
		op = op.toLowerCase();
		return (op.equals("sum") || op.equals("max") || op.equals("sum") || op.equals("avg") || op.equals("count") || op.equals("distinct") || op.equals("public.prov"));
	}

	public static BinaryOperation getBinary(String op, Column lInput, Column rInput)
			throws DataLawyerException {
		op = op.toLowerCase();
		if (op.equals("="))
			return new EqOperation(OpType.EQ, lInput, rInput);
		else if (op.equalsIgnoreCase("like"))
			return new LikeOperation(OpType.LIKE, lInput, rInput);
		else if (op.equals("<>"))
			return new NeqOperation(OpType.NEQ, lInput, rInput);
		else if (op.equals("<"))
			return new LtOperation(OpType.LT, lInput, rInput);
		else if (op.equals(">"))
			return new GtOperation(OpType.GT, lInput, rInput);
		else if (op.equals("<="))
			return new LeqOperation(OpType.LEQ, lInput, rInput);
		else if (op.equals(">="))
			return new GeqOperation(OpType.GEQ, lInput, rInput);
		else
			throw new DataLawyerException(
					"This operator is not supported or is not binary: " + op);
	}

	public abstract String toString();
	
	public abstract int numOperands();

	protected String opToString(){
		switch (_op) {
		case EQ:
			return "=";
		case LIKE:
			return "LIKE";
		case NEQ:
			return "<>";
		case LT:
			return "<";
		case GT:
			return ">";
		case LEQ:
			return "<=";
		case GEQ:
			return ">=";
		case MIN:
			return "MIN";
		case MAX:
			return "MAX";
		case SUM:
			return "SUM";
		case AVG:
			return "AVG";
		case COUNT:
			return "COUNT";
		case DISTINCT:
			return "DISTINCT";
		case PROV:
			return "public.PROV";
		default:
			throw new IllegalArgumentException(
					"This operation is not supported by the parser: " + _op);
		}
	}
	
	@Override
	public abstract boolean equals(Object op);
	
	@Override
	public abstract int hashCode();
	
	public abstract boolean usesInput(Column cid);
	
	public abstract String toSqlString();

	public abstract boolean equalsLogically(Operation opR);

}

