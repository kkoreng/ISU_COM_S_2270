package lab2;

/**
 * A RabbitModel2 is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel2 {
  private int population;

  /**
   * Constructs a new RabbitModel2.
   */
  public RabbitModel2() {
    population = 0;
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation() {
    if (population >= 5) population = 0;
    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear() {
        population += 1;

  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset() {
    population = 0;
  }
}
