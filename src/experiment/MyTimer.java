package experiment;

public class MyTimer {
	private boolean hasInit = false;
	private long start = 0;
	private long end = 1;
	
	public MyTimer() { 
		reset();
	}

	/**
	 * Start the timer.
	 */
	public final void start() {
		hasInit = true;
		start = System.nanoTime();
		end = start - 1;
	}
	
	/**
	 * Stop the timer.
	 */
	public final void end() {
		if (!hasInit)
			throw new IllegalStateException(
					"The timer has to be explicitly started.");
		end = System.nanoTime();
	}
	
	/**
	 * Read how long the timer ran.
	 * @return
	 */
	public final double read() {
		if (!hasInit)
			throw new IllegalStateException(
					"The timer has to be explicitly started.");
		if (start > end)
			throw new IllegalStateException(
					"The timer has to be explicitly ended.");
		return (end - start) / 1000000.0;
	}
	
	/**
	 * Reset the timer. You still need to start it.
	 */
	public final void reset() {
		hasInit = false;
		start = 0;
		end = 1;
	}
}
