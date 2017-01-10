package lab2;
/** Model of an atom */
public class Atom {
	/** Protons, Neutrons, and Electrons */
	private int protons, neutrons, electrons;
	
	/** Constructs an Atom with Protons, Neutrons, and Electrons
	 * @param givenProtons
	 * @param givenNeutrons
	 * @param givenElectrons
	 */
	public Atom(int givenProtons, int givenNeutrons, int givenElectrons) {
		protons = givenProtons;
		neutrons = givenNeutrons;
		electrons = givenElectrons;
	}
	
	/**
	 * Returns total number of protons plus neutrons.
	 * @return Atomic Mass
	 */
	public int getAtomicMass() {
		return neutrons + protons;
	}
	
	/**
	 * Returns the difference between the number of protons and electrons.
	 * @return Atomic Charge
	 */
	public int getAtomicCharge() {
		return protons - electrons;
	}
	
	/**
	 * Decreases the number of protons by 2 and the number of neutrons by 2
	 */
	public void decay() {
		protons = protons - 2;
		neutrons = neutrons - 2;
	}
}