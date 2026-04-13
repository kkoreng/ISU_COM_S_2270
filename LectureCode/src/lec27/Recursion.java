package lec27;

public class Recursion {
    public static void count(int i) { // bar // bza // alice //
        count(i-1);
        System.out.println(i);
    }

    public static void main(String[] args) {
        count(10);
    }
}
