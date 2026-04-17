package p_exam;

public class RecursionPractice {


    /**
     * This method solves the following problem using recursion.
     *
     * Compute the sum of all digits in a number.
     *
     * For example:
     * sumDigits(1234) should return 10
     * sumDigits(7) should return 7
     *
     * @param n the given number
     * @return the sum of its digits
     */
    public static int sumDigits(int n) {
        // TODO
        if (n < 10) {
            return n;
        }

        return (n % 10) + sumDigits(n / 10);
    }

    /**
     * This method solves the following problem using recursion.
     *
     * Count how many even numbers are in the array starting
     * from the given index.
     *
     * For example:
     * [1,2,3,4,5,6], index 0 -> 3
     * [1,3,5], index 0 -> 0
     *
     * @param nums the array of numbers
     * @param index the starting index
     * @return number of even numbers
     */
    public static int countEvens(int[] nums, int index) {
        // TODO
        if (index == nums.length) {
            return 0;
        }

        int count = 0;
        if (nums[index] % 2 == 0) {
            count++;
        }

        return count + countEvens(nums, index + 1);
    }


    /**
     * This method solves the following problem using recursion.
     *
     * Remove all occurrences of the letter 'x' from a string.
     *
     * For example:
     * "xaxb" -> "ab"
     * "hello" -> "hello"
     *
     * @param str the given string
     * @return string without 'x'
     */
    public static String removeX(String str) { // applex pplex ... x
        // TODO
        if (str.isEmpty()) {
            return str;
        }

        char ch = str.charAt(0); // a
        if (ch == 'x') { // a != x
            return removeX(str.substring(1));
        }

        return ch + removeX(str.substring(1)); // a +
    }



    /**
     * This method solves the following problem using recursion.
     *
     * Determine if a string is a palindrome.
     *
     * For example:
     * "racecar" -> true
     * "hello" -> false
     *
     * @param str the given string
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        // TODO
        if (str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        return isPalindrome(str.substring(1, str.length() - 1));
    }



    /**
     * This method solves the following problem using recursion.
     *
     * Compute base^exp (power function).
     *
     * For example:
     * power(2, 3) -> 8
     * power(5, 0) -> 1
     *
     * @param base the base number
     * @param exp the exponent
     * @return base raised to exp
     */
    public static int power(int base, int exp) {
        // TODO
        if (exp == 0) {
            return 1;
        }

        return base * power(base, exp - 1);
    }



    /**
     * This method solves the following problem using recursion.
     *
     * Find the maximum value in the array starting from index.
     *
     * For example:
     * [3, 7, 2, 9, 5], index 0 -> 9
     * [1], index 0 -> 1
     *
     * @param nums the array
     * @param index starting index
     * @return the maximum value
     */
    public static int findMax(int[] nums, int index) {
        // TODO
        if ()
        return 0;
    }

    public static String reverse1(String str) {
        if (str.isEmpty()) {
            return str;
        }

        return reverse1(str.substring(1)) + str.charAt(0);
    }

    public static String reverse(String str) {
        if (str.length() <= 1) {
            return str;
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }

    static void main(String[] args) {
        System.out.println(reverse1("a"));
    }



}