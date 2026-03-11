package exam01.A03_staticMethod;

/**
 * Writing a Static Method
 * Write a static method to guess Steve's birthday using an instance of java.util.Random!
 * All we know for sure is that it is in September (which has 30 days)
 * and that he was born sometime between 1900 and 1999.
 * Your method should return a String of the form "September X, Y" where X is your randomly generated day from 1 through 30,
 * and Y is your randomly generated year from 1900 through 1999. The method has no input.
 */

import java.util.Random;

public class Main {

    public static String guessBirthday() {
        // TODO: your code here
        Random rand = new Random();
        int x = rand.nextInt(1, 30);
        int y = rand.nextInt(1900, 1999);

        String output = "September " + x + ", " + y;
        return output;
    }

    public static void main(String[] args) {
        System.out.println(guessBirthday());
    }
}