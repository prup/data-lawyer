package relation;

import java.util.ArrayList;

import utils.DataLawyerException;


public class OpUnion extends Op {

	public OpUnion(Relation first, Relation second) throws DataLawyerException {
		super("UNION", first.counters);
		if (OpExcept.unionCompatibility(first, second)) {
			_addInput(first);
			_addInput(second);
		}
		for (Column c : first.getColumns())
			appendColumn(c, new ColumnOptInfo(first.getColumnOptInfo(c)));
	}

	public void addRelation(Relation r) throws DataLawyerException {
		if (OpExcept.unionCompatibility(input(0), r))
			_addInput(r);
	}

	@Override
	public void addOperation(Operation op, ColumnOptInfo optinfo)
			throws DataLawyerException {
		throw DataLawyerException.operationNotAllowed();
	}

	@Override
	protected boolean allOperationsEmpty() {
		return false;
	}

	@Override
	protected ArrayList<Column> getGeneratedColumns(Column colId, Relation input) {
		ArrayList<Column> toret = new ArrayList<Column>();
		for (Column c : getColumns()) {
			if (input.equals(this.input(0)) && c.equals(colId))
				toret.add(c);
			for (int i = 1; i < numInputs(); ++i)
				if (input.equals(this.input(i))
						&& c.getInfo()
								.getNameUnAliased()
								.equalsIgnoreCase(
										colId.getInfo().getNameUnAliased()))
					toret.add(c);
		}
		return toret;
	}

	@Override
	public void propagateRedundancyDownLocally() throws DataLawyerException {
		// TODO: This operator behaves like a project, probably?
		for (Column col : getColumns()) {
			for (Column c : input(0).getColumns())
				if (c.equals(col))
					input(0).setRedundancy(c, getRedundancy(col));
			for (int i = 1; i < numInputs(); ++i) {
				for (Column c : input(i).getColumns())
					if (c.getInfo().getNameUnAliased()
							.equalsIgnoreCase(col.getInfo().getNameUnAliased()))
						input(i).setRedundancy(c, getRedundancy(col));
			}
		}
	}

	@Override
	public ArrayList<Column> sourceColumns(Column col) throws DataLawyerException {
		ArrayList<Column> toret = new ArrayList<Column>();
		for (Column c : input(0).getColumns())
			if (c.equals(col))
				toret.add(col);
		for (int i = 1; i < numInputs(); ++i) {
			for (Column c : input(i).getColumns())
				if (c.getInfo().getNameUnAliased()
						.equalsIgnoreCase(col.getInfo().getNameUnAliased()))
					toret.add(c); // TODO: Check if this should be c or col?
		}
		if (toret.isEmpty())
			throw new DataLawyerException("No source column found for output column: "
					+ col);
		return toret;
	}

}
