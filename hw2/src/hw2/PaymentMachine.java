package hw2;

public class PaymentMachine {
	private SimpleClock simpleClock;
	private Ticket ticket;
	private boolean isInProgress;
	private double totalPayment;
	
	public PaymentMachine(SimpleClock givenClock) {
		simpleClock = new SimpleClock();
		simpleClock = givenClock;
		isInProgress = false;
		totalPayment = 0;
	}
	
	public void insertTicket(Ticket t) {
		ticket = new Ticket(0);
		ticket = t;
		
		if (!isInProgress) {
			isInProgress = true;
		}
	}
	
	public Ticket getCurrentTicket() {
		if (isInProgress) {
			return ticket;
		}
		
		return null;
	}
	
	public boolean inProgress() {
		return isInProgress;
	}
	
	public double getPaymentDue() {
		if(inProgress() == true && ticket.getPaymentTime() == 0)	
			return ParkingRateUtil.calculateCost(simpleClock.getTime() - ticket.getStartTime());
		else if(inProgress() == true && ticket.getPaymentTime() != 0 )
			return ParkingRateUtil.calculateCost(simpleClock.getTime() - ticket.getStartTime())-ParkingRateUtil.calculateCost(ticket.getPaymentTime()-ticket.getStartTime());
		else 
			return 0.0;
}
	
	
	public void makePayment() {
		
			totalPayment = totalPayment + getPaymentDue();
					ticket.setPaymentTime(simpleClock.getTime());

	}
	
	public void ejectTicket() {
		if (isInProgress) {
			isInProgress = false;
		}
	}
	
	public double getTotalPayments() {
		return totalPayment;
	}
}