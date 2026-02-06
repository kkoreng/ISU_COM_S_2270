package lec05;

import java.awt.Rectangle;

public class A {
    public static void main(String[] args) {
        Rectangle r1;   // declare an object variable

        // initialize the variable by creating a new obhect
        r1 = new Rectangle();

        Rectangle r2 = new Rectangle(60, 80);

        System.out.println("R1 width is " + r1.getWidth() + " and height is " + r1.getHeight());
        //dot notation is important. Without it, it couldn't call the object


        r1 = r2;
        r1.setSize(5,10);

        System.out.println("R1 width is " + r1.getWidth() + "and height is " + r1.getHeight());
        System.out.println("R2 width is " + r2.getWidth() + "and height is " + r2.getHeight());

        B r3 = new B(100, 100);
        r3.growBy(2);
        System.out.println("Width is " + r3.getWidth() + " and area is " + r3.getArea());

    }
}
