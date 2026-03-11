package exam01.A01_expressions;

public class Expression_D {
    public static double run(int d, int c) {
        // Only replace the TODO with a SINGLE EXPRESSION.
        // Multiple lines of code will not receive full credit.

        // Given an integer number d of dollars and c of cents, a double
        // that is the dollar value of d dollars and c cents
        double totalValue = d + (c/100.0); /* TODO: put expression here */

        return totalValue;
    }

    public static void main(String args[]) {
        System.out.println(run(2, 25));
    }
}