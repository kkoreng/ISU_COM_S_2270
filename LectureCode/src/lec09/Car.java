package lec09;

public class Car {
    private String numPlate; // represent 'A' as 0, 'B' as 1, etc
    private String name; // just itself

    private int alpha;
    private int digit;

    public Car(String newName) {
        name = newName;
    }

    public String nextPlate() {
        return Character.toString((char) (65 + alpha)) + digit;
    }

    public void incPlate() {
        digit = (digit + 1) % 10;
        if (digit == 0) {
            alpha = (alpha + 1) % 26;
        }
    }

}
