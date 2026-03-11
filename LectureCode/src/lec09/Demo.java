package lec09;

public class Demo {
    public static void main(String[] args) {
        // call a static method before creating any objects
        System.out.println("The total is: " + Number.getTotal());

        // create an object now
        Number n1 = new Number();
        n1.increaseValue(5);
        System.out.println("The value of n1 is: " + n1.getValue());
        n1.increaseValue(6);
        System.out.println("The value of n1 is: " + n1.getValue());

        Number n2 = new Number();
        n2.increaseValue(100);
        System.out.println("The value of n1 is: " + n2.getValue());

        System.out.println("The total is: " + Number.getTotal());
    }
}