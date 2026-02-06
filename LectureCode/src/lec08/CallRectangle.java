package lec08;

public class CallRectangle {

    public static void testIfEqual(int actualValue, int expectedValue, String errorMsg) {
        if (actualValue != expectedValue) {
            System.out.println("I was expecting " + expectedValue);
            System.out.println("But I got a value of " + actualValue);
            System.out.println("And the error message is: " + errorMsg);
        }
    }

    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle();

        myRectangle.setSize(1, 1);
        testIfEqual(myRectangle.getArea(), 1, "FAILED getArea() for 1, 1");
        testIfEqual(myRectangle.getPerimeter(), 1, "FAILED getPerimeter() for 1, 1");

        myRectangle.setSize(2, 3);
        if (myRectangle.getArea() != 6) {
            System.out.println("FAILED getArea() for 2, 3");
        }
        testIfEqual(myRectangle.getPerimeter(), 10, "FAILED getPerimeter() for 2, 3");
    }
}