package exam01.A01_expressions;

public class Expression_C {
    public static char run(String str) {
        // Only replace the TODO with a SINGLE EXPRESSION.
        // Multiple lines of code will not receive full credit.

        // Given a String str, the last character of the string
        char lastChar = str.charAt(str.length()-1); /* TODO: put expression here */;

        return lastChar;
    }

    public static void main(String args[]) {
        // You are allowed to call the run method here and test your answer with
        // different values by printing them.
        System.out.println(run("monkey"));
    }
}