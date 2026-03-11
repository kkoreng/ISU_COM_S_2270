package exam01.A04_interactiveMainMethod;

/**
 * Write an interactive main method that takes a measurement in meters and converts it to centimeters (1/100 meters). The method starts by prompting the user to enter the number of meters. Then the method outputs the converted measurement. The output must match the examples exactly, except for the formatting of numbers (e.g., significant digits) which can be ignored. A sample interaction is shown below, with user's responses in bold.
 *
 * How many meters? 150.25
 * The measurement is: 15025 cm
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(meterToCentimeter(150.25));
    }

    public static int meterToCentimeter(double meters) {
        double x = meters * 100.0;
        return (int) x;
    }
}