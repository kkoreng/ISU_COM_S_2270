/*
package lec08;

import static org.junit.Assert.assertEquals;

import org.junit.p_exam.Test;
import org.junit.Before; // not really needed yet but useful later

public class GasTankTest {

    public static final double ERROR = 0.0001;

    @p_exam.Test
    public void testCreateGasTank() {
        // GasTank tank = new GasTank();
        GasTank tank = new GasTank(10.0); // capacity of the gas tank
        // could make it a setter method, but likely it is not going to change
        // ie setter called only once.  Esp when setter is not called more than
        // once
        double capacity = tank.getCapacity();
        // What should the answer be?
        assertEquals("New constructed tank should have correct capacity",
                10.0, capacity, ERROR);
    }

    @p_exam.Test
    public void testFillGasTank() {
        GasTank tank = new GasTank(10.0);
        tank.fill(5.0);
        assertEquals("After filling with 5 gals there should be 5 gals in the tank",
                5.0, tank.getLevel(), ERROR);
    }

    @p_exam.Test
    public void testOverfill() {
        GasTank tank = new GasTank(10.0);
        tank.fill(15.0);
        assertEquals("After filling with 15 gals there should be 10 gals in the tank",
                10.0, tank.getLevel(), ERROR);
    }

    // Two approaches, either refuse to fill or else
    // fill as much as possible
}*/
