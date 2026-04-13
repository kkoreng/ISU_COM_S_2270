package lab7;

import java.io.File;

public class Checkpoint {

    public static void main(String[] args) {
//        int[] test = {3, 4, 5, 1, 2, 3, 2, 10, 21};
//        int result = findMax(test,0, test.length - 1);
//        System.out.println(result);


//        System.out.println(getPyramidCount(7));
//
//
//        System.out.println(countFiles(new File("./src")));
//
        System.out.println(countPatterns(5));
    }


    public static int findMax(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        } else {
            int mid = (start + end) / 2;

            int leftMax = findMax(arr, start, mid);
            int rightMax = findMax(arr, mid + 1, end);

            return Math.max(leftMax, rightMax);
        }
    }

    public static int getPyramidCount(int n) {
        if (n == 1) {
            return 1;
        }

        return (n * n) + getPyramidCount(n - 1);
    }

    public static int countFiles(File f) {
        if (!f.isDirectory()) {
            return 1;
        }

        int fileCount = 0;
        File[] files = f.listFiles();
        for (int i = 0; i < files.length; ++i) {
            fileCount += countFiles(files[i]);
        }

        return fileCount;
    }

    public static int countPatterns(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        return countPatterns(n-1) + countPatterns(n-3);
    }


}
