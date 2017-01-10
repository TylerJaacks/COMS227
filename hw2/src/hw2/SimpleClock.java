package hw2;

/**
 * A Clock serves as a simple counter to simulate the passage of time. There is
 * no actual connection to any real-world timer or clock. The passage of time is
 * simulated by the method timePasses(). Time is assumed to be in minutes,
 * represented as a single integer.
 * 
 * @author smkautz
 */
public class SimpleClock {
	/**
	 * Abstract representation of time in minutes from initialization.
	 */
	private int time;

	/**
	 * Constructs a new clock with a current time of zero.
	 */
	public SimpleClock() {
		time = 0;
	}

	/**
	 * Returns this clock's current time.
	 * 
	 * @return the current time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Simulates the passage of time for the given number of minutes.
	 * 
	 * @param minutes
	 *            number of minutes to be added to this clock's time
	 */
	public void timePasses(int minutes) {
		time += minutes;
	}

	/**
	 * Simulates the passage of time for the given hours and minutes.
	 * 
	 * @param hours
	 *            number of hours to be added
	 * @param minutes
	 *            number of minutes to be added
	 */
	public void timePasses(int hours, int minutes) {
		time += hours * 60 + minutes;
	}

}