package relation;

/**
 * We want to treat columns as sort of static and easy to access. This is
 * helpful for sanity checks. We do not want a tree traversal to figure out
 * violations like duplicate columns (without aliasing) or for optimizations
 * like pushing selections down.
 * 
 * @author prasang
 * 
 */
/*
public class Metadata {

	protected final HashMap<Relation, OpAlias> _aliases = new HashMap<Relation, OpAlias>();

	/**
	 * Super important function. Be super careful about what you want to copy
	 * over and what you don't
	 * 
	 * @param metadata
	 * @throws DUMException
	 */
/*
	public void copyMetadata(Metadata metadata) {
		// TODO: Check this!
		for (Relation r : metadata._aliases.keySet())
			_aliases.put(r, metadata._aliases.get(r));
	}

	public void addAlias(Relation original, OpAlias alias) {
		_aliases.put(original, alias);
	}

	public final boolean matchRelations(Relation original, String relname) {
		if (relname == null)
			throw new NullPointerException();
		if (original == null)
			return false;
		relname = relname.toLowerCase();
		while (original != null)
			if (relname.equalsIgnoreCase(original.getName()))
				return true;
			else
				original = _aliases.get(original);
		return false;
	}
	
}
*/