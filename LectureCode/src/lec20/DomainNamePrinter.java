package lec20;

public class DomainNamePrinter {

    public static boolean hasDuplicate(String text) {
        boolean hasDup = false;

        for (int i = 0; i < text.length(); ++i) {
            for (int j = 0; j < text.length(); ++j) {
                if (i != j && text.charAt(i) == text.charAt(j)) {
                    hasDup = true;
                }
            }
        }
        return hasDup;
    }
    public static void main(String[] args) {
        System.out.println(hasDuplicate("pulp"));
        System.out.println(hasDuplicate("earth"));

    }
}
