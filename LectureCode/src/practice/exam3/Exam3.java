package practice.exam3;

public class Exam3 {


    public static String replaceVowels(String s) {
        String result = "";
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                result += '_';
            } else {
                result += c;
            }
        }
        return result;
    }


}
