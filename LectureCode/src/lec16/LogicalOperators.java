package lec16;

public class LogicalOperators {

        public static void main() {
            int x = 5;
            int y = 10;
            boolean a = true;
            boolean b = false;

            // Logical AND
            System.out.println("Logical AND:");
            System.out.println(a && b); // false
            System.out.println(a && a); // true
            System.out.println(b && b); // false

            // Logical OR
            System.out.println("Logical OR:");
            System.out.println(a || b); // true
            System.out.println(a || a); // true
            System.out.println(b || b); // false

            // Logical NOT
            System.out.println("Logical NOT:");
            System.out.println(!a); // false
            System.out.println(!b); // true

            // Short-circuit evaluation
            System.out.println("Short-circuit evaluation:");
            System.out.println((x > y) && (y / 0 == 0)); // false, does not throw exception due to short-circuiting
        }


}
