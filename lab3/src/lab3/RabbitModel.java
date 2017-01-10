package lab3;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel {
	private int population;
	private int currentYear;
	private int lastYear;
	private int yearBefore;

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel() {
		lastYear = 1;
		yearBefore = 0;
		population = lastYear + yearBefore;
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
		yearBefore = lastYear;
		lastYear = lastYear + population;
		currentYear++;
		population = yearBefore + lastYear;
	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		lastYear = 1;
		yearBefore = 0;
		population = lastYear + yearBefore;
	}
}
