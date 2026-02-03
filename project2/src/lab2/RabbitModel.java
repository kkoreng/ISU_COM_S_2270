package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits using the Fibonacci sequence.
 */
public class RabbitModel {

    private int population;
    private int lastYear;
    private int yearBefore;

    /**
     * Constructs a new RabbitModel.
     * Initial state corresponds to the Fibonacci base case.
     */
    public RabbitModel() {
        population = 1;
        lastYear = 1;
        yearBefore = 0;
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
     * Updates the population to simulate the
     * passing of one year using Fibonacci logic.
     */
    public void simulateYear() {
        int next = lastYear + yearBefore; // Fibonacci step

        yearBefore = lastYear;
        lastYear = next;
        population = next;
    }

    /**
     * Resets the model to the initial state.
     */
    public void reset() {
        population = 1;
        lastYear = 1;
        yearBefore = 0;
    }
}
