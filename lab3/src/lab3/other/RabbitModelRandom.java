package lab3.other;

import java.util.Random;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModelRandom {
	private Random random;
	private int population;
	private int year;

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModelRandom() {
		random = new Random();
	}

	/**
	 * Returns the current number of rabbits.
	 * 
	 * @return current rabbit population
	 */
	public int getPopulation() {
		// TODO - returns a dummy value so code will compile
		return population;
	}

	/**
	 * Updates the population to simulate the passing of one year.
	 */
	public void simulateYear() {
		year++;
		population = population + random.nextInt(11);
	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		population = 0;
		year = 0;
	}
}
