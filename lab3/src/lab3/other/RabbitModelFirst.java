package lab3.other;

/**
 * A RabbitModelFirst is used to simulate the growth of a population of rabbits.
 */
public class RabbitModelFirst {
	private int population;
	private int year;
	
	/**
	 * Constructs a new RabbitModelFirst.
	 */
	public RabbitModelFirst() {
		population = 0;
	}

	/**
	 * Returns the current number of rabbits.
	 * 
	 * @return current rabbit population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * Updates the population to simulate the passing of one year.
	 */
	public void simulateYear() {
		year++;
		
		if ((year % 5) == 0) {
			population = 0;
		} else {
			population++;
		}
	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		population = 0;
		year = 0;
	}
}
