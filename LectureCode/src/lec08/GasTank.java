package lec08;

/**
 * Models the gas tank contents and capacity
 */
public class GasTank {

    private double capacity;
    private double level;

    /**
     * Initializes a gas tank of specified capacity
     *
     * @param cap is the intended capacity of the new gas tank
     */
    public GasTank(double cap) {
        capacity = cap;
        level = 0.0;
    }

    /**
     Reads the capacity of the gas tan

     @return the capacity that was configured for this object
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     Adds some gas to a gas tank, up to the limit of the capacity.
     If more gas is added than the tank can contain, the excess is
     discarded.

     @param numGals is the amount to attempt to add
     */
    public void fill(double numGals) {
        level = Math.min(capacity, level + numGals);
    }

    /**
     Reads how much gas is in the tank at the moment
     */
    public double getLevel() {
        return level;
    }
}
