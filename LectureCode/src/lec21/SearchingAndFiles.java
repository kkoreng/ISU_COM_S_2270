package lec21;

public class SearchingAndFiles {

    public static int indexOf(String text, String sub) {
        int index = -1;
        for (int i = 0; i < text.length(); ++i) {
            String extract = text.substring(1, i + sub.length());
            if (extract.equals((sub))) {
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        System.out.println(indexOf("independent", "pen"));
        System.out.println(indexOf("independent", "tin"));
    }
}
