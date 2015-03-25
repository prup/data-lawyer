package relation;

/**
 * This class is supposed to be immutable. Be careful about defining setters.
 * 
 * @author prasang
 * 
 */
public class Column {

	private final int _id;

	private final ColumnInfo _info;

	/**
	 * @param id
	 *            The id of the column.
	 * @param metadata
	 *            The metadata that contains the information about id.
	 */
	public Column(final ColumnInfo info, final Counters counters) {
		if (info == null)
			throw new IllegalArgumentException("ColumnInfo can not be null.");
		_id = counters._nextColumnId.incrementAndGet();
		_info = info;
	}

	/*
	public final boolean equalityByString(String name) {
		String relname = null;
		if (name.contains(".")) {
			int dotindex = name.lastIndexOf('.');
			relname = name.substring(0, dotindex);
			name = name.substring(dotindex + 1);
		}
		if (relname == null) 
			return getInfo().equalsByString(name);
		else
			return getInfo().equalsByString(name, relname);
	}

	public final boolean equalityByString(String opname, String name) {
		if (!(getInfo() instanceof AggColInfo))
			return false;
		AggColInfo agginfo = (AggColInfo) getInfo();
		return agginfo.equalityByOperatorAndColName(opname, name);
	}
	*/

	@Override
	public final boolean equals(final Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Column))
			return false;
		return this._id == ((Column) o)._id;
	}

	public final ColumnInfo getInfo() {
		return _info;
	}

	public static Column getAliasedColumn(final OpAlias aliasRelation,
			final String aliasName, final Column oldC, final Counters counters,
			boolean isRenaming) {
		AliasColInfo info = new AliasColInfo(aliasName,
				aliasRelation, oldC, isRenaming);
		
		return new Column(info, counters);
	}

	@Override
	public final int hashCode() {
		return _id;
	}

	protected final void setID() {
		throw new UnsupportedOperationException();
	}

	protected final void setInfo() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Print out a string that can be used in a valid SQL statement for this
	 * query.
	 * 
	 * @return
	 */
	public final String toSqlString() {
		return _info.getNameAliased();
	}

	@Override
	public final String toString() {
		return Integer.toString(_id) + ":" + _info.toString();
	}

	public final boolean equalsLogically(final Column otherColumn) {
		if (otherColumn == this)
			return true;
		if (otherColumn == null)
			return false;
		return getInfo().equalsLogically(otherColumn.getInfo());
	}

}