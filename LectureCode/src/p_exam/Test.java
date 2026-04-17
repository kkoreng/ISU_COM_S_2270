package p_exam;

public class Test {

    /**
     * This method solves the following problem using recursion.
     *
     * Convert a series of all lower case letter "a"s at the start
     * of a given string to "z"s. Only convert the "a"s that start
     * the string. For example:
     * "aaaalabaster" should return "zzzzlabaster"
     * "vanilla" should return "vanilla"
     * @param str the given string
     * @return a new string with the starting "a"s converted to "z"s
     */
    public static String frontAsToZs(String str) {
        // TODO (about 4 lines)
        // the solution must use recursion
        // ZERO CREDIT for not using recursion
        if (str.isEmpty() || str.charAt(0) != 'a') {
            return str;
        }

        return 'z' + frontAsToZs(str.substring(1));
    }

    public static void main(String[] args) {
        // optional testing can go here
        System.out.println(frontAsToZs("aaaa"));
    }

}
