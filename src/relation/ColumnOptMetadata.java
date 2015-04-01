package relation;

/**
 * This class stores the logical and physical properties of {@link Column}s that
 * are relevant for optimization.
 *
 * @author prasang
 *
 */
public class ColumnOptMetadata {
	public static enum Redundancy {
		False, True, Unknown;
	}

	// true indicates that the column is redundant.
	public Redundancy _redundancy = Redundancy.Unknown; // Tell if this column
														// is not needed in the
														// output to
	// compute the correct answer.
	private boolean isProvenance = false;

	public ColumnOptMetadata() {
		this._redundancy = Redundancy.Unknown;
		this.isProvenance = false;
	}

	public ColumnOptMetadata(ColumnOptMetadata optInfo) {
		if (optInfo == null)
			throw new IllegalArgumentException(
					"Input to copy constructor can not be null.");
		this._redundancy = optInfo._redundancy;
		this.isProvenance = optInfo.isProvenance;
	}

	public boolean isProvenance() {
		return isProvenance;
	}

	public void setProvenance(boolean b) {
		isProvenance = b;
	}

	@Override
	public String toString() {
		return _redundancy.toString();
	}
}
