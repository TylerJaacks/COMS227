package lab2;

public class AtomTest {
	public static void main(String[] args) {
		Atom atom = new Atom(5, 5, 5);
		
		System.out.println("Atomic Mass: " + atom.getAtomicMass());
		System.out.println("Atomic Charge: " + atom.getAtomicCharge());
		
		atom.decay();
		
		System.out.println("Atomic Mass: " + atom.getAtomicMass());
		System.out.println("Atomic Charge: " + atom.getAtomicCharge());
	}
}