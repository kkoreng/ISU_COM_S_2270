package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {

    public static void countWords(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            int words = 0;
            Scanner lineSc = new Scanner(line);
            while (lineSc.hasNext()) {
                lineSc.next();
                words ++;
            }

            System.out.println(words);

        }

    }


    public static void main(String[] args) throws FileNotFoundException {
        countWords("story.txt");
    }
}
