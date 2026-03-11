package lec19;

import java.util.Scanner;

public class TestInput {
    public static void main(String[] args) {
        String values = "11 22 33 44.0\n55.123 66.235 seventy eighty-eight";
        System.out.println(values);

        Scanner si = new Scanner(values);
        int count = 0;
        while(si.hasNextInt()) {
            int i = si.nextInt();
            count++;
            System.out.println("Int " + count + ": <" + i + ">");
        }
        si.close();
    }
}
