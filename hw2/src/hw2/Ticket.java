package hw2;

/**
 * This class models a ticket for a parking garage that has a magnetic stripe
 * that can encode the time of entry and the time of payment. Time is assumed to
 * be represented in minutes as a single integer.
 * 
 * @author smkautz
 */
public class Ticket {
	/**
	 * The time of entry into the parking lot.
	 */
	private final int startTime;

	/**
	 * The time at which payment was last made for parking.
	 */
	private int paymentTime;

	/**
	 * Constructs a ticket with the given start time and a payment time of zero.
	 * 
	 * @param givenStartTime
	 */
	public Ticket(int givenStartTime) {
		startTime = givenStartTime;
	}

	/**
	 * Returns the start time for this ticket.
	 * 
	 * @return the start time of this ticket
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Returns the payment time for this ticket.
	 * 
	 * @return payment time for the ticket
	 */
	public int getPaymentTime() {
		return paymentTime;
	}

	/**
	 * Sets the payment time for this ticket.
	 * 
	 * @param givenPaymentTime
	 *            time to be set
	 */
	public void setPaymentTime(int givenPaymentTime) {
		this.paymentTime = givenPaymentTime;
	}

}