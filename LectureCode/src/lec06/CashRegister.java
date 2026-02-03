/**
 * @author: Heeryun Cho
 * @version: 0.1
 */
package lec06;

/**
 * This class models a cash register as one might find in a grocery store.
 */
public class CashRegister {
    // instance variables -- what the object knows/remembers or its stored attribs
    private double subTotal;
    private double taxRate;
    private double taxTotal;

    // constructors
    /**
     * Constructs a new CashRegister()
     *
     * @param newTaxRate is the tax rate that this CR should use
     */
    public CashRegister(double newTaxRate) {
        subTotal = 0.0;
        taxRate = newTaxRate;
    }

    public void setTaxRate(double newTaxRate) {
        taxRate = newTaxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    // instance methods
    /**
     * Scans the item the customer wants to buy and adds the price
     * scanned to the internal running total
     *
     * @param price is what the item costs to buy
     */
    public void addNontaxableItem(double price) {
        subTotal += price;
    }

    public void addTaxableItem(double price) {
        subTotal += price + price * taxRate;
    }

    /**
     * Returns the running total of the items scanned so far
     *
     * @return the running total
     */
    public double getTotal() {
        return subTotal;
    }

    public double getTaxTotal() {
        return taxTotal;
    }

    public double getSubTotal() {
        return subTotal;
    }
}