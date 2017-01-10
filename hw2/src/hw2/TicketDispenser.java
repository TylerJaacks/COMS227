package hw2;

public class TicketDispenser {
	private SimpleClock simpleClock;
	private Ticket ticket;
	
	/**
	 * Constructs a TicketDispenser Object.
	 * @param givenClock
	 */
	public TicketDispenser(SimpleClock givenClock) {
		simpleClock = new SimpleClock();
		simpleClock = givenClock;
	}
	
	/**
	 * Returns a ticket with information that have set earlier.
	 * @return Returns a ticket set with the current time and payment time of 0.
	 */
	public Ticket takeTicket() {
		ticket = new Ticket(simpleClock.getTime());
		ticket.setPaymentTime(0);
		
		return ticket;
	}
}