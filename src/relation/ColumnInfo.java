package relation;

import java.util.ArrayList;

import org.antlr.runtime.tree.Tree;

import utils.DataLawyerException;
import utils.StringUtils;


enum ValType {
	INT, VARCHAR, BOOLEAN, FLOAT;
}

/**
 * We do not support column aliasing. Useless feature anyway.
 * 
 * @author prasang
 * 
 */
public abstract class ColumnInfo {

	public static boolean isArithmeticOp(String op) {
		String[] arithmeticOps = { "+", "-", "*", "/", "||" };
		for (int i = 0; i < arithmeticOps.length; ++i)
			if (arithmeticOps[i].equalsIgnoreCase(op))
				return true;
		return false;
	}

	protected final String _name;
	protected final Relation _relation;

	public ColumnInfo(String colName, Relation relation) {
		_name = colName == null ? colName : colName.toLowerCase();
		_relation = relation;
	}

	public final Relation getRelation() {
		return _relation;
	}

	@Override
	public final String toString() {
		return (getNameAliased());
	}

	@Override
	public abstract boolean equals(Object col);


	public static ConstColumn getConstantColumn(String value)
			throws DataLawyerException {
		if (StringUtils.isInteger(value))
			return new IntConstColumn(Integer.parseInt(value));
		else if (StringUtils.isDecimal(value))
			return new FloatConstColumn(Float.parseFloat(value));
		else if (StringUtils.isBoolean(value))
			return new BoolConstColumn(Boolean.parseBoolean(value));
		else if (StringUtils.isVarchar(value))
			return new StringConstColumn(StringUtils.stripSingleQuotes(value));
		else
			throw new DataLawyerException("Could not determine the constant's type: "
					+ value);
	}

	public static DerivedColumn getDerivedColumn(String fnName,
			ArrayList<Column> inputs) {
		if (isArithmeticOp(fnName)) {
			if (inputs.size() != 2)
				throw new IllegalArgumentException();
			return new DerivedArithmeticColumn(fnName, inputs.get(0),
					inputs.get(1));
		} else
			return new DerivedColumn(fnName, inputs);
	}

	public static boolean IsConstant(String value) {
		return StringUtils.isInteger(value) || StringUtils.isDecimal(value) || StringUtils.isBoolean(value)
				|| StringUtils.isVarchar(value);
	}

	/**
	 * Print a string that can be used in a valid SQL statement.
	 * 
	 * @return
	 */
	public abstract String getNameAliased();

	public abstract String getSqlDefinition();

	/**
	 * Returns the name of the column
	 * 
	 * @return
	 */
	public final String getNameUnAliased() {
		return _name;
	}

	public abstract boolean equalsByTree(Tree tree);

	public static boolean isAggregate(ColumnInfo info) {
		return (info instanceof AggColInfo);
	}

	/**
	 * Returns true for columns in input's columns, for ConstColumn, and for
	 * DerivedColumn where all inputs are either constants or input's columns.
	 * 
	 * @param input
	 * @param c
	 * @return
	 * @throws DataLawyerException
	 */
	public static boolean allInputsKnown(Relation input, Column c)
			throws DataLawyerException {
		if (input == null || c == null)
			return false;
		if (input.hasColumn(c))
			return true;
		ColumnInfo cinfo = c.getInfo();
		if (cinfo instanceof AggColInfo)
			return false;
		else if (cinfo instanceof AliasColInfo)
			return false;
		else if (cinfo instanceof ConstColumn)
			return true;
		else if (cinfo instanceof DerivedColumn) {
			boolean inputsKnown = true;
			DerivedColumn drvdColInfo = (DerivedColumn) cinfo;
			for (Column inputC : drvdColInfo.inputs)
				inputsKnown &= allInputsKnown(input, inputC);
			return inputsKnown;
		} else if (cinfo instanceof IndexColInfo)
			return false;
		else
			throw new DataLawyerException("Unsupported ColumnInfo type: "
					+ cinfo.getClass().getSimpleName());
	}

	public static boolean isOverallConstant(Column c) {
		if (c.getInfo() instanceof ConstColumn)
			return true;
		if (!(c.getInfo() instanceof DerivedColumn))
			return false;
		DerivedColumn drvdColInfo = (DerivedColumn) c.getInfo();
		boolean isConstant = true;
		for (Column inC: drvdColInfo.inputs)
			isConstant &= isOverallConstant(inC);
		return isConstant;
	}

	public abstract boolean equalsLogically(ColumnInfo rightColInfo);

	public static boolean isIndexColumn(Column lastCol) {
		return (lastCol.getInfo() instanceof IndexColInfo);
	}
}

class DerivedArithmeticColumn extends DerivedColumn {

	public DerivedArithmeticColumn(String fnName, Column leftInput,
			Column rightInput) {
		super(fnName, new ArrayList<Column>());
		if (!isArithmeticOp(fnName))
			throw new IllegalArgumentException();
		inputs.add(leftInput);
		inputs.add(rightInput);
	}

	@Override
	public String getNameAliased() {
		return String.format("%s %s %s", inputs.get(0).getInfo()
				.getNameAliased(), fnName, inputs.get(1).getInfo()
				.getNameAliased());
	}

	@Override
	public boolean equalsByTree(Tree tree) {
		if (tree == null)
			return false;
		String op = tree.getText();
		if (op == null)
			return false;
		if (!op.equalsIgnoreCase(fnName))
			return false;
		if (tree.getChildCount() != inputs.size())
			return false;
		for (int i = 0; i < inputs.size(); ++i) {
			Column c = inputs.get(i);
			if (!c.getInfo().equalsByTree(tree.getChild(i)))
				return false;
		}
		return true;
	}

}

class DerivedColumn extends ColumnInfo {
	protected String fnName;
	public ArrayList<Column> inputs;

	public DerivedColumn(String fnName, ArrayList<Column> inputs) {
		super(null, null);
		if (fnName == null)
			throw new IllegalArgumentException("Function name can not be null.");
		this.fnName = fnName;
		this.inputs = inputs;
	}

	@Override
	public boolean equals(Object col) {
		if (col == this)
			return true;
		if (col == null)
			return false;
		if (!(col instanceof DerivedColumn))
			return false;
		DerivedColumn inColumn = (DerivedColumn) col;
		if (!this.fnName.equalsIgnoreCase(inColumn.fnName))
			return false;
		if (inputs.size() != inColumn.inputs.size())
			return false;
		for (int i = 0; i < inputs.size(); ++i)
			if (!inputs.get(i).equals(inColumn.inputs.get(i)))
				return false;
		return true;
	}
	
	@Override
	public boolean equalsLogically(ColumnInfo colInfo) {
		if (colInfo == this)
			return true;
		if (colInfo == null)
			return false;
		if (!(colInfo instanceof DerivedColumn))
			return false;
		DerivedColumn inColumn = (DerivedColumn) colInfo;
		if (!this.fnName.equalsIgnoreCase(inColumn.fnName))
			return false;
		if (inputs.size() != inColumn.inputs.size())
			return false;
		for (int i = 0; i < inputs.size(); ++i)
			if (!inputs.get(i).equalsLogically(inColumn.inputs.get(i)))
				return false;
		return true;
	}


	@Override
	public String getNameAliased() {
		String inputString = "";
		for (Column c : inputs)
			inputString += c.getInfo().getNameAliased() + ", ";
		inputString = inputString.substring(0, inputString.length() - 2);
		return String.format("%s(%s)", fnName, inputString);
	}

	@Override
	public String getSqlDefinition() {
		return getNameAliased();
	}

	@Override
	public boolean equalsByTree(Tree tree) {
		if (tree == null)
			return false;
		String op = tree.getText();
		if (op == null)
			return false;
		if (!op.equalsIgnoreCase("function"))
			return false;

		op = tree.getChild(0).getText();
		if (!op.equalsIgnoreCase(fnName))
			return false;

		if (tree.getChildCount() != inputs.size() + 1)
			return false;
		// TODO: WHy did it initially start counting from 1 to inputs.size() (include both ends).
		for (int i = 0; i < inputs.size(); ++i) {
			Column c = inputs.get(i);
			if (!c.getInfo().equalsByTree(tree.getChild(i + 1)))
				return false;
		}
		return true;
	}

	public ArrayList<Column> getBaseColumns() {
		ArrayList<Column> toRet = new ArrayList<Column>();
		for (Column c : inputs) {
			if (c.getInfo() instanceof DerivedColumn) { 
				DerivedColumn colInfo = (DerivedColumn) c.getInfo();
				toRet.addAll(colInfo.getBaseColumns());
			} else 
				toRet.add(c);
		}
		return toRet;
	}

}

abstract class ConstColumn extends ColumnInfo {

	public ConstColumn() {
		super(null, null);
	}

	@Override
	public String getSqlDefinition() {
		return getNameAliased();
	}

	@Override
	public final boolean equalsByTree(Tree tree) {
		if (tree == null)
			return false;
		String val = tree.getText();
		if (val == null)
			return false;
		if (tree.getChildCount() != 0)
			return false;
		return val.equalsIgnoreCase(this.getNameAliased());
	}
	
	@Override
	public final boolean equalsLogically(ColumnInfo colInfo) {
		return equals(colInfo);
	}

}

class IntConstColumn extends ConstColumn {
	public int _value;

	public IntConstColumn(int value) {
		super();
		_value = value;
	}

	@Override
	public String getNameAliased() {
		return Integer.toString(_value);
	}

	@Override
	public boolean equals(Object col) {
		if (this == col)
			return true;
		if (col == null)
			return false;
		if (!(col instanceof IntConstColumn))
			return false;
		return _value == ((IntConstColumn) col)._value;
	}
}

class FloatConstColumn extends ConstColumn {
	public float _value;

	public FloatConstColumn(float value) {
		super();
		_value = value;
	}

	@Override
	public String getNameAliased() {
		return Float.toString(_value);
	}

	@Override
	public boolean equals(Object col) {
		if (this == col)
			return true;
		if (col == null)
			return false;
		if (!(col instanceof FloatConstColumn))
			return false;
		return _value == ((FloatConstColumn) col)._value;
	}

}

class StringConstColumn extends ConstColumn {
	public String _value;

	public StringConstColumn(String value) {
		super();
		_value = value;
	}

	@Override
	public String getNameAliased() {
		return String.format("'%s'", _value);
	}

	@Override
	public boolean equals(Object col) {
		if (this == col)
			return true;
		if (col == null)
			return false;
		if (!(col instanceof StringConstColumn))
			return false;
		return _value.equals(((StringConstColumn) col)._value);
	}
}

class BoolConstColumn extends ConstColumn {
	public boolean _value;

	public BoolConstColumn(boolean value) {
		super();
		_value = value;
	}

	@Override
	public String getNameAliased() {
		return Boolean.toString(_value);
	}

	@Override
	public boolean equals(Object col) {
		if (this == col)
			return true;
		if (col == null)
			return false;
		if (!(col instanceof BoolConstColumn))
			return false;
		return _value == ((BoolConstColumn) col)._value;
	}

}

class IndexColInfo extends ColumnInfo {

	public IndexColInfo(String colName, Relation rid) throws DataLawyerException {
		super(colName, rid);
		if (colName == null || rid == null)
			throw new NullPointerException("Input arguments contain a null.");
		if (!(rid instanceof Index) && !(rid instanceof OpAlias))
			throw new DataLawyerException("Invalid relation type.");
	}

	@Override
	public boolean equals(Object col) {
		if (this == col)
			return true;
		if (this == null)
			return false;
		if (!(col instanceof IndexColInfo))
			return false;
		IndexColInfo tabCol = (IndexColInfo) col;
		return _relation.equals(tabCol._relation)
				&& _name.equalsIgnoreCase(tabCol._name);
	}

	@Override
	public String getNameAliased() {
		return _relation.getName() + "." + _name;
	}

	@Override
	public String getSqlDefinition() {
		return getNameAliased();
	}

	@Override
	public boolean equalsByTree(Tree tree) {
		if (tree == null)
			return false;
		String name = tree.getText();
		if (name == null)
			return false;
		if (tree.getChildCount() != 0)
			return false;

		String relname = null;
		if (name.contains(".")) {
			int dotindex = name.lastIndexOf('.');
			relname = name.substring(0, dotindex);
			name = name.substring(dotindex + 1);
		}

		if (!_name.equalsIgnoreCase(name))
			return false;

		if (relname != null)
			return _relation.getName().equalsIgnoreCase(relname);

		return true;

	}
	
	@Override
	public boolean equalsLogically(ColumnInfo colInfo) {
		if (colInfo == this)
			return true;
		if (colInfo == null)
			return false;
		if (!(colInfo instanceof IndexColInfo))
			return false;
		IndexColInfo indColInfo = (IndexColInfo) colInfo;
		return _relation.getName().equalsIgnoreCase(indColInfo._relation.getName())
				&& _name.equalsIgnoreCase(indColInfo._name);	}

}

class AggColInfo extends ColumnInfo {
	public final UnaryOperation _op;

	public AggColInfo(String opname, Column input) throws DataLawyerException {
		super(null, null);
		if (opname == null)
			throw new IllegalArgumentException(
					"The aggregate function can not be null.");
		_op = UnaryOperation.getUnary(opname, input);
	}

	public AggColInfo(UnaryOperation op) {
		super(null, null);
		if (op == null)
			throw new IllegalArgumentException(
					"The aggregate function can not be null.");
		_op = op;
	}

	public UnaryOperation getOperation() {
		return _op;
	}

	@Override
	public boolean equals(Object col) {
		if (col == this)
			return true;
		if (col == null)
			return false;
		if (!(col instanceof AggColInfo))
			return false;
		AggColInfo aggCol = (AggColInfo) col;
		return (_op.equals(aggCol._op));
	}
	
	@Override
	public boolean equalsLogically(ColumnInfo colInfo) {
		if (colInfo == this)
			return true;
		if (colInfo == null)
			return false;
		if (!(colInfo instanceof AggColInfo))
			return false;
		AggColInfo aggColInfo = (AggColInfo) colInfo;
		return (_op._op.equals(aggColInfo._op._op) && getSourceColumn().equalsLogically(aggColInfo.getSourceColumn()));
	}


	public Column getSourceColumn() {
		return _op._inputIndex;
	}

	@Override
	public String getNameAliased() {
		return _op.toSqlString();
	}

	@Override
	public String getSqlDefinition() {
		return getNameAliased();
	}

	@Override
	public boolean equalsByTree(Tree tree) {
		if (tree == null)
			return false;
		String op = tree.getText();
		if (op == null)
			return false;
		if (!op.equalsIgnoreCase(_op.opToString()))
			return false;
		if (tree.getChildCount() != 1)
			return false;
		return _op._inputIndex.getInfo().equalsByTree(tree.getChild(0));
	}

}

class AliasColInfo extends ColumnInfo {

	private final Column input;
	private final boolean _isRenaming;

	public AliasColInfo(String colName, OpAlias alias, Column input,
			boolean isRenaming) {
		super(colName, alias);
		this.input = input;
		_isRenaming = isRenaming;
	}

	@Override
	public boolean equals(Object col) {
		if (this == col)
			return true;
		if (col == null)
			return false;
		if (!(col instanceof AliasColInfo))
			return false;
		AliasColInfo rename = (AliasColInfo) col;
		return this._name.equalsIgnoreCase(rename._name)
				&& this._relation.equals(rename._relation)
				&& this.input.equals(rename.input)
				&& _isRenaming == rename._isRenaming;
	}
	
	@Override
	public boolean equalsLogically(ColumnInfo colInfo) {
		if (colInfo == this)
			return true;
		if (colInfo == null)
			return false;
		if (!(colInfo instanceof AliasColInfo))
			return false;
		AliasColInfo aliasColInfo = (AliasColInfo) colInfo;
		return input.equalsLogically(aliasColInfo.input);
	}


	@Override
	public String getNameAliased() {
		// TODO: Figure out what happens with the line below. Why does it not work?
	//	return _relation.getName() + "." + _name;
		if (_relation != null)
			return _relation.getName() + "." + _name;
		else 
			return _name;
	}

	@Override
	public String getSqlDefinition() {
		if (_isRenaming) {
			String inputName = input.toSqlString();
			if (input.getInfo() instanceof AliasColInfo)
				inputName = input.getInfo().getNameAliased();
			return String.format("%s AS %s", inputName, this._name);
		} else
			return getNameAliased();
	}

	public final Column getInput() {
		return input;
	}

	@Override
	public boolean equalsByTree(Tree tree) {
		if (tree == null)
			return false;
		String op = tree.getText();
		if (op == null)
			return false;
		if (op.equalsIgnoreCase("as") && !_isRenaming)
			return false;
		if (_isRenaming) {
			if (tree.getChildCount() != 2)
				return false;
			String alias = tree.getChild(1).getText();
			if (alias == null)
				return false;
			if (!alias.equalsIgnoreCase(_name))
				return false;

			return input.getInfo().equalsByTree(tree.getChild(0));
		} else {
			if (tree.getChildCount() != 0)
				return false;

			String relname = null;
			String name = op;
			if (name.contains(".")) {
				int dotindex = name.lastIndexOf('.');
				relname = name.substring(0, dotindex);
				name = name.substring(dotindex + 1);
			}

			if (!_name.equalsIgnoreCase(name))
				return false;

			if (relname != null)
				return _relation.getName().equalsIgnoreCase(relname);

			return true;
		}
	}

}
