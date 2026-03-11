package lec18;

public class ForLoops {
    public static void main(String[] args) {
//        int i = 3;
//        int j = 3;
//
//        int ii = i++; // postinc
//        int jj = ++j; // preinc
//
//        System.out.println(ii);
//        System.out.println(jj);
//
//        ++i;
//        i++;
//
//        i = ++i; // i becomes 4
//        i = 3;
//        i = i++; // does nothing

//        int z = 0;
//        while (z < 10) {
//            // ++z;
//            System.out.println(z);
//            ++z;
//        }

//        int z = 10;
//        while (z >= 0) {
//            System.out.println(z);
//            --z;
//        }
//
//        System.out.println("for loop next");
//        for (z = 9; z >= 0; z -= 2) {
//            System.out.println(z);
//        }

        System.out.println(countPs("pineapple"));
        System.out.println(hasDoubleLetter("pineapple"));
    }

    public static int countPs(String str) {
        int ans = 0;
        int i;
        for (i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c == 'p' || c == 'P') {
                ans++;
            };
        }
        return ans;
    }

    public static boolean hasDoubleLetter(String str) {
        boolean ans = false;

        for (int i = 0; i < str.length()-1; ++i) {
            char blue = str.charAt(i);
            char red = str.charAt(i + 1);
            if (blue == red) {
                ans = true;
                System.out.println("Found " + blue + " at " + i);
            }
        }
        return ans;
    }
}
