package relation;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.runtime.tree.Tree;

import relation.ColumnOptMetadata.Redundancy;
import utils.DataLawyerException;
import utils.MyLogger;

/**
 * Models a relation with a set of {@link Column}s.
 * 
 * @author prasang
 * 
 */
public abstract class Relation {

	/**
	 * The indentation character to use for pretty printing {@link Relation}.
	 */
	protected static final String _TAB = "\t";

	private final String _name;

	/**
	 * The parent operator, if any.
	 */
	public Op _parent = null;

	private final int _rid;

	private final ArrayList<Column> columns;

	private final HashMap<Column, ColumnOptMetadata> _opt_metadata;

	/**
	 * The id generator for this {@link Relation}.
	 */
	public final Counters counters;

	/**
	 * 
	 * @param name
	 *            Name of this {@link Relation}.
	 * @param counters
	 *            Counter to generate ids for this {@link Relation} and its
	 *            {@link Column}s.
	 * @throws DataLawyerException
	 */
	public Relation(String name, Counters counters) throws DataLawyerException {
		this._name = name;
		this.counters = counters;
		columns = new ArrayList<Column>();
		_rid = counters._nextRelationId.incrementAndGet();
		_opt_metadata = new HashMap<Column, ColumnOptMetadata>();
	}

	/**
	 * Add a new {@link Column} to this {@link Relation}, if it does not exist.
	 * The order, in which the columns were added, is preserved.
	 * 
	 * @param c
	 *            {@link Column} to add.
	 * @param opt_metadata
	 *            {@link ColumnOptMetadata} of the added {@link Column}.
	 */
	public final void appendColumn(Column c, ColumnOptMetadata opt_metadata) {
		if (!columns.contains(c)) {
			columns.add(c);
			_opt_metadata.put(c, opt_metadata);
		}
	}

	/**
	 * 
	 * Deletes the specified {@link Column} and throws an exception if no such
	 * Column is found.
	 * 
	 * @param c
	 *            {@link Column} to delete.
	 * @throws DataLawyerException
	 *             If the column to delete is not found.
	 */
	public final void deleteColumn(Column c) throws DataLawyerException {
		if (!columns.contains(c))
			throw new DataLawyerException(
					"Column being deleted does not exist: " + c.toString());
		columns.remove(c);
		_opt_metadata.remove(c);
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Relation))
			return false;
		return this._rid == ((Relation) o)._rid;
	}

	/**
	 * Return the output column in position i.
	 * 
	 * @param i
	 * @return
	 */
	public final Column getColumn(int i) {
		return columns.get(i);
	}

	public final Column getColumn(Tree columnTree) throws DataLawyerException {
		Column toRet = null;
		for (Column c : columns) {
			if (c.getInfo().equalsByTree(columnTree)) {
				if (toRet == null)
					toRet = c;
				else
					throw new DataLawyerException("Ambiguous column: " + toRet
							+ " vs " + c + " while parsing column: "
							+ columnTree);
			}
		}
		if (toRet == null) {
			MyLogger.getLog().info(
					"This column not found: " + columnTree.toString());
			MyLogger.getLog().info("Known columns were: " + columns.toString());
		}

		return toRet;
	}

	/**
	 * 
	 * @return the list of all columns for this relation.
	 */
	public final ArrayList<Column> getColumns() {
		return columns;
	}

	/**
	 * 
	 * @return the unique id for this relation.
	 */
	public final int getId() {
		return _rid;
	}

	/**
	 * 
	 * @return the name of this relation.
	 */
	public String getName() {
		return _name;
	}

	public Redundancy getRedundancy(Column c) throws DataLawyerException {
		if (hasColumn(c))
			return getColumnOptInfo(c)._redundancy;
		else
			throw new DataLawyerException("Column not found: " + c
					+ " in relation: " + _name);
	}

	public final ArrayList<Column> getSourceColumns(Column c)
			throws DataLawyerException {
		ArrayList<Column> sources = new ArrayList<Column>();

		if (c.getInfo() instanceof ConstColumn) {
			;
		} else if (c.getInfo() instanceof IndexColInfo)
			sources.add(c);
		else if (c.getInfo() instanceof AggColInfo) {
			AggColInfo cinfo = (AggColInfo) c.getInfo();
			sources.addAll(this.getSourceColumns(cinfo.getSourceColumn()));
		} else
			throw new DataLawyerException("Unsupported column type.");

		return sources;
	}

	public final boolean hasColumn(Column c) {
		return columns.contains(c);
	}

	@Override
	public final int hashCode() {
		return this._rid;
	}

	/**
	 * 
	 * If the previous operator is not a project, it adds a project operator. It
	 * then projects out the column colId. Cases to watch out for: parent is
	 * null; parent is not null but is not a ProjectOperator; and, parent is
	 * ProjectOperator that has already projected out the column.
	 * 
	 * Note that we need to explicitly copy all columns of the input to the
	 * output of the project since the default behavior of the project
	 * instantiation is to not copy anything to the output.
	 * 
	 * @param c
	 *            Column to project.
	 * @throws DataLawyerException
	 */
	public final void projectOut() throws DataLawyerException {

		// Check if the operator has any redundant column.
		boolean hasProjectableColumn = false;
		for (Column c : columns)
			hasProjectableColumn |= getColumnOptInfo(c)._redundancy
					.equals(Redundancy.True);

		// Sanity check.
		if (hasProjectableColumn
				&& ((this instanceof OpAlias) || (this instanceof Index)))
			throw new DataLawyerException("Can not perform a project on: "
					+ this.getClass().getSimpleName());

		if (hasProjectableColumn) {
			OpProject prOp = null;

			// Add a new project Operator above this subtree.
			if (_parent == null) {
				prOp = new OpProject(this);
				for (Column c : columns)
					prOp.appendColumn(c,
							new ColumnOptMetadata(this.getColumnOptInfo(c)));
			} else if (!(_parent instanceof OpProject)) {
				Op currParent = _parent;

				// This will replace _parent to prOp.
				prOp = new OpProject(this);
				for (Column c : columns)
					prOp.appendColumn(c,
							new ColumnOptMetadata(this.getColumnOptInfo(c)));

				currParent.replaceInput(this, prOp);
			}

			// For the redundant columns, remove them from the introduced
			// project Operator.
			for (Column c : columns)
				if (prOp.hasColumn(c)
						&& getColumnOptInfo(c)._redundancy
								.equals(Redundancy.True)) {
					prOp.deleteColumn(c);
					if (_parent != null)
						_parent.deleteInputColumnRecursive(c, this);
				}
		}

		// Recurse up!
		if (_parent != null)
			_parent.projectOut();
	}

	protected void addOptColInfo(Column c, ColumnOptMetadata colOptInfo) {
		if (_opt_metadata.containsKey(c))
			return;
		_opt_metadata.put(c, colOptInfo);
	}

	public final ColumnOptMetadata getColumnOptInfo(Column c) {
		if (c.getInfo() instanceof ConstColumn)
			return new ColumnOptMetadata();
		if (!_opt_metadata.containsKey(c))
			throw new IllegalArgumentException("Column: " + c.toString()
					+ " not found in column set: "
					+ _opt_metadata.keySet().toArray().toString());
		return _opt_metadata.get(c);
	}

	/**
	 * Way too many implicit assumptions here. Simplify this. // TODO
	 * 
	 * @param c
	 * @param newPos
	 */
	public final void reorderColumn(Column c, int newPos) {
		if (c.getInfo() instanceof DerivedColumn) {
			DerivedColumn drvdColumn = (DerivedColumn) c.getInfo();
			ArrayList<Column> toDelete = drvdColumn.getBaseColumns();
			for (Column cin : toDelete)
				if (hasColumn(cin))
					columns.remove(cin);

			columns.add(newPos, c);
			_opt_metadata.put(c, new ColumnOptMetadata());
		} else {
			columns.remove(c);
			columns.add(newPos, c);
		}
	}

	public final void setParent(Op parent) {
		_parent = parent;
	}

	public final void setRedundancy(Column c, Redundancy redundancy)
			throws DataLawyerException {
		if (hasColumn(c))
			getColumnOptInfo(c)._redundancy = redundancy;
		else
			throw new DataLawyerException("Column not found: " + c);
	}

	@Override
	public final String toString() {
		String additionalInfo = "";
		// additionalInfo += "Output columns: " + getColumns().toString() +
		// "\n";
		// additionalInfo += "OptColInfo: " + _opt_metadata.keySet().toString()
		// + "\n";

		return additionalInfo + toStringTabbed(_TAB);
	}

	protected abstract String toStringOperator(String tab);

	protected final String toStringTabbed(String tab) {
		String output = tab + "(" + _name + ": ";
		output += "[";
		for (Column c : getColumns())
			output += c.toString() + ":" + getColumnOptInfo(c) + ", ";
		if (getColumns().size() > 0)
			output = output.substring(0, output.length() - 2);
		output += "]";
		output += toStringOperator(tab);
		output += ")";

		return output;
	}

}
