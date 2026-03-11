package exam01.A05_class;

/**
 * Consider a class ParkingMeter that models a coin-operated parking meter. We will assume it only takes quarters (25 cent coins). Its public interface includes:
 *
 * • A constructor ParkingMeter(int minutesPerQuarter, int maximumTime),
 *      where minutesPerQuarter is the number of minutes you get for a quarter,
 *      and maximumTime is the maximum number of minutes.
 *      A newly created ParkingMeter has no time on it.
 * • A method insertCoin(int howMany) that simulates adding the given number of quarters.
 *      Inserting coins increases the time remaining on the meter,
 *      but not more than the maximum time.
 * • A method getTimeRemaining() that returns the time remaining
 *      on the meter in minutes as an int value.
 * • A method passTime(int minutes) that simulates the passage of time,
 *      that is, reduces the time remaining (but not below zero)
 * • A method getTotal() that returns the total amount of money,
 *      in dollars, collected by this meter.
 */
public class ParkingMeter {
    // TODO: any instance variables, they are up to you to decide if needed
    private int minutesPerQuarter;
    private int maximumTime;

    // TODO: the constructor ParkingMeter(int minutesPerQuarter, int maximumTime)
    public ParkingMeter(int minutesPerQuarter, int maximumTime) {
        minutesPerQuarter = minutesPerQuarter;
        maximumTime = maximumTime;
    }

    // TODO: the instance method insertCoin(int howMany)
    public boolean insertCoin(int howMany) {

    }

    // TODO: the instance method getTimeRemaining()
    public int getTimeRemaining() {
    }

    // TODO: the instance method passTime(int minutes)
    public void passTime(int minutes) {

    }

    // TODO: the instance method getTotal()
    public double getTotal() {
        return
    }


    public static void main(String[] args) {

    }
}
