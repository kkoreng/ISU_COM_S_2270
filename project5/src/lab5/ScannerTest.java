package lab5;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
//        int result = sumThree("42 237 5");
//        System.out.println(result);

        System.out.println(getInitial("asdf qwer asdf")); // aqa
        System.out.println(getInitial("heeryun")); // h

        System.out.println(getFirstVowelIndex("qraz asdwqas asd "));
        System.out.println(getFirstVowelIndex("plplppll"));
    }

    public static int sumThree(String text) {
        Scanner in = new Scanner(text);
        int total = 0;
        int num = in.nextInt();
        total = total + num;
        num = in.nextInt();
        total = total + num;
        num = in.nextInt();
        total = total + num;
        return total;
    }

    public static String getInitial(String name) {
        String initial = "";

        initial += name.charAt(0);
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i-1) == ' ') {
                initial += name.charAt(i);

            }
        }

        return initial;
    }

    public static int getFirstVowelIndex(String word) {

        // "aeiouAEIOU".indexOf(ch) >= 0 : find vowel

        for (int i=0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ("aeiouAEIOU".indexOf(ch) >= 0) {
                return i;
            }
        }
        return -1;
    }

}