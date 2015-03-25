package relation;

import java.util.concurrent.atomic.AtomicInteger;

public class Counters {
	
	private static Counters uniqueCounter = null;
	
	/**
	 * This generates unique column ids that are used to refer to columns. So,
	 * each operator refers to each unique column through the same id. It is
	 * necessary to start this at 1. We use a value of 0 to indicate the absence
	 * of a matching column.
	 * */
	public final AtomicInteger _nextColumnId;

	/**
	 * This generates unique relation ids that are used to refer to base
	 * relations, aliases, and dummy relations for derived columns, constants
	 * and aggregated columns. It is necessary to start this at 1. We use a
	 * value of 0 to indicate the absence of a matching column.
	 * */
	public final AtomicInteger _nextRelationId;
	
	public final long timestamp;
	
	private Counters() {
		_nextColumnId = new AtomicInteger(0);
		_nextRelationId = new AtomicInteger(0);
		timestamp = System.currentTimeMillis();
	}
	
	@Override
	public final boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Counters))
			return false;
		return this.timestamp == ((Counters) o).timestamp;
	}
	
	@Override
	public final int hashCode() {
		return (int) timestamp;
	}
	
	public static Counters getCounters() {
		if (uniqueCounter == null)
			uniqueCounter = new Counters();
		return uniqueCounter;
	}

}

