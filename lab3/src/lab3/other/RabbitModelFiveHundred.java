package lab3.other;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModelFiveHundred {
	private int population;
	private int year;

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModelFiveHundred() {
		// TODO
		population = 500;
		year = 0;
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
		if (population != 0) {
			population = population / 2;
		}
	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		population = 500;
		year = 0;
	}
}
