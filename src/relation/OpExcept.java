package relation;

import java.util.ArrayList;

import relation.ColumnOptInfo.Redundancy;
import utils.DataLawyerException;


/**
 * TODO: CHECK! Reason out its behavior on paper and re-check everything!
 * 
 * @author prasang
 * 
 */

public class OpExcept extends Op {

	public OpExcept(Relation first, Relation second) throws DataLawyerException {
		super("EXCEPT", first.counters);
		if (unionCompatibility(first, second)) {
			_addInput(first);
			_addInput(second);
		}
		for (Column c : first.getColumns())
			appendColumn(c, new ColumnOptInfo(first.getColumnOptInfo(c)));
	}

	static boolean unionCompatibility(Relation first, Relation second) {
		if (first.getColumns().size() != second.getColumns().size())
			return false;
		for (int i = 0; i < first.getColumns().size(); ++i) {
			Column firstcolumn = first.getColumn(i);
			Column secondcolumn = second.getColumn(i);
			if (firstcolumn.getInfo() instanceof ConstColumn
					&& secondcolumn.getInfo().getClass()
							.equals(secondcolumn.getInfo().getClass()))
				continue;
			if (!firstcolumn
					.getInfo()
					.getNameUnAliased()
					.equalsIgnoreCase(secondcolumn.getInfo().getNameUnAliased()))
				return false;
		}
		return true;
	}

	@Override
	public void addOperation(Operation op, ColumnOptInfo optinfo)
			throws DataLawyerException {
		throw DataLawyerException.operationNotAllowed();
	}

	@Override
	public ArrayList<Column> sourceColumns(Column col) throws DataLawyerException {
		ArrayList<Column> toret = new ArrayList<Column>();
		for (Column c : input(0).getColumns())
			if (c.equals(col))
				toret.add(col);
		for (Column c : input(1).getColumns())
			if (c.getInfo().getNameUnAliased()
					.equalsIgnoreCase(col.getInfo().getNameUnAliased()))
				toret.add(col);
		if (toret.isEmpty())
			throw new DataLawyerException("No source column found for output column: "
					+ col);
		return toret;
	}

	@Override
	public void propagateRedundancyDownLocally() throws DataLawyerException {
		// All input columns are important. Why?
		for (Relation input : inputs())
			for (Column c : input.getColumns())
				input.setRedundancy(c, Redundancy.False);
	}

	@Override
	protected ArrayList<Column> getGeneratedColumns(Column colId, Relation input) {
		ArrayList<Column> toret = new ArrayList<Column>();
		for (Column c : getColumns()) {
			if (input.equals(this.input(0)) && c.equals(colId))
				toret.add(c);
			if (input.equals(this.input(1))
					&& c.getInfo()
							.getNameUnAliased()
							.equalsIgnoreCase(
									colId.getInfo().getNameUnAliased()))
				toret.add(c);
		}
		return toret;
	}

	@Override
	protected boolean allOperationsEmpty() {
		return false;
	}

}
