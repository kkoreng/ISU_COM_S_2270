package lec09;

public class Number {
    private static int total; // there is only one of this
    private int value; // each object thas its own copy of this

    // public Number() { }

    // static method
    public static int getTotal() {
        return total;
    }

    // instance method
    public int getValue() {
        return value;
    }

    public void increaseValue(int quantity) {
        value = value + quantity;
        total = total + quantity;
    }
}
