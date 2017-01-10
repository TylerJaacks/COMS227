package hw2;

public class Test {
	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
	}

	public static void Test1() {
		SimpleClock c = new SimpleClock();
		System.out.println(c.getTime()); // Expected 0
		c.timePasses(10);
		System.out.println(c.getTime()); // Expected 10
		Ticket t = new Ticket(42);
		System.out.println(t.getStartTime()); // Expected 42
		System.out.println(t.getPaymentTime()); // Expected 0
	}

	public static void Test2() {
		SimpleClock c = new SimpleClock();
		ExitMachine em = new ExitMachine(c);
		Ticket t = new Ticket(c.getTime());
		t.setPaymentTime(10);
		c.timePasses(20);
		boolean canExit = em.insertTicket(t);
		System.out.println(canExit); // Expected true
		Ticket t2 = new Ticket(0);
		t2.setPaymentTime(30);
		c.timePasses(60);
		canExit = em.insertTicket(t2);
		System.out.println(canExit); // Expected false
		System.out.println(em.getExitCount()); // expected 1
	}

	public static void Test3() {
		SimpleClock c = new SimpleClock();
		TicketDispenser td = new TicketDispenser(c);
		c.timePasses(10);
		Ticket t = td.takeTicket();
		System.out.println(t.getStartTime()); // Expected 10
		System.out.println(t.getPaymentTime()); // Expected 0
	}

	public static void Test4() {
		SimpleClock c = new SimpleClock();
		PaymentMachine pm = new PaymentMachine(c);
		Ticket t = new Ticket(0);
		pm.insertTicket(t);
		System.out.println(pm.inProgress()); // Expected true
		Ticket current = pm.getCurrentTicket();
		System.out.println(current == t); // Expected true
		pm.ejectTicket();
		System.out.println(pm.inProgress()); // Expected false
		current = pm.getCurrentTicket();
		System.out.println(current == null); // Expected true
	}
	
	public static void Test5() {
		SimpleClock c = new SimpleClock(); 
		c.timePasses(10);
		PaymentMachine pm = new PaymentMachine(c); 
		Ticket t = new Ticket(c.getTime()); 
		c.timePasses(60);
		pm.insertTicket(t); 
		System.out.println(pm.getPaymentDue()); // expected 2.00 pm.ejectTicket(); // eject without paying c.timePasses(75);
		pm.insertTicket(t); 
		System.out.println(pm.getPaymentDue()); // expected 4.50
	}
}