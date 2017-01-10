package hw2;

public class ExitMachine {
	private SimpleClock simpleClock;
	private Ticket ticket;
	private int exitCount;
	
	/**
	 * Creates an object of ExitMachine.
	 * @param givenClock Takes a SimpleClock.
	 */
	public ExitMachine(SimpleClock givenClock) {
		simpleClock = new SimpleClock();
		simpleClock = givenClock;
		exitCount = 0;
	}
	
	/**
	 * Inserts a ticket into the ExitMachine.
	 * @param t Takes a ticket
	 * @return Returns a information regarding exiting the machine.
	 */

	public boolean insertTicket(Ticket t){
		if  (t.getPaymentTime() == 0)
			return false;
		else if(Math.max(simpleClock.getTime() - t.getPaymentTime(),0)<= ParkingRateUtil.EXIT_TIME_LIMIT)
		{   
			exitCount++;
			return true;
		}
		else 
			return false;
		}
	
	
	/**
	 * Get the exit count.
	 * @return Returns the exit count.
	 */
	public int getExitCount() {
		return exitCount;
	}
}