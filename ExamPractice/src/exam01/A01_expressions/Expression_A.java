package exam01.A01_expressions;

public class Expression_A {
    public static int run(int eggCount) {
        // Only replace the TODO with a SINGLE EXPRESSION.
        // Multiple lines of code will not receive full credit.

        // Given an int named eggCount, the number of full cartons of
        // 12 eggs you can make with that many eggs
        int fullCartons = eggCount/12; /* TODO: put expression here */;

        return fullCartons;
    }

    public static void main(String args[]) {
        // You are allowed to call the run method here and test your answer with
        // different values by printing them.
        System.out.println(run(12));
        System.out.println(run(24));

    }
}