package lec17;

import java.util.Scanner;

public class WhileLoops {

/*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Continue? (y/n): ");
        String input = sc.next();
        while (input.equals("y")) {
            System.out.println("hello");
        }
        System.out.println("bye");

    }
*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input;
        do {
            System.out.print("Continue? (y/n): ");
            input = sc.next();
            if (input.equals("y")) {
                System.out.println("hello");
            } else {
                break;
            }
        } while (true);

        System.out.println("bye");

    }
}
