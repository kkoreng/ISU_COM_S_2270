package lec15;

public class StringComparisons {
    public static void main() {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");

        System.out.println(str1 == str2); // true, because of string literal pool
        System.out.println(str1 == str3); // false, because str3 is a new object

        System.out.println(str1.equals(str3)); // true, because equals compares content
        System.out.println(str1.equals(str2)); // true, because equals compares content

    }
}
