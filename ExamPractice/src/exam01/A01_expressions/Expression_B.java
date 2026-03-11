package exam01.A01_expressions;

public class Expression_B {
    public static int run(int eggCount) {
        // Only replace the TODO with a SINGLE EXPRESSION.
        // Multiple lines of code will not receive full credit.

        // Given an int named eggCount, the number of eggs left over after
        // putting them into full cartons of 12 eggs
        int leftOver = eggCount % 12 /* TODO: put expression here */;

        return leftOver;
    }

    public static void main(String args[]) {
        // You are allowed to call the run method here and test your answer with
        // different values by printing them.
        System.out.println(run(13));
        System.out.println(run(15));
    }
}