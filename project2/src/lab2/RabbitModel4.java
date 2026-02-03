package lab2;

import java.util.Random;

/**
 * A RabbitModel2 is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel4 {
  private int population;

  /**
   * Constructs a new RabbitModel2.
   */
  public RabbitModel4() {
    population = 2;
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation() {
    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear() {
      Random rand = new Random();
      int p = rand.nextInt(0, 10);
      population += p;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset() {
    population = 2;
  }
}
