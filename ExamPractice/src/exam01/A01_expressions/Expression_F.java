package exam01.A01_expressions;

import java.util.Random;

public class Expression_F {
    public static int run() {
        // Only replace the TODO with a SINGLE EXPRESSION.
        // Multiple lines of code will not receive full credit.

        // Generate an odd random integer between 1 and 5 inclusive, with equal probabilities,
        // given a random number generator of type Random called rand.
        Random rand = new Random();
        int oddNum = rand.nextInt(1, 5) /* TODO: put expression here */;

        return oddNum;
    }

    public static void main(String args[]) {
        System.out.println(run());
    }
}