package lab6.polyline;

import plotter.Plotter;
import plotter.Polyline;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
       /* Plotter plotter = new Plotter();
        Polyline p = parseOneLine("red 100 100 200 100 200 200 100 200 100 100");
        plotter.plot(p);

        p = parseOneLine("2 blue 250 100 400 350 100 350 250 100");
        plotter.plot(p);*/

        ArrayList<Polyline> list = readFile("hello.txt");
        Plotter plotter = new Plotter();

        for (Polyline p : list) {
            plotter.plot(p);
        }


    }

    private static ArrayList<Polyline> readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        ArrayList<Polyline> polylines = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            };
            polylines.add(parseOneLine(line));
        }
        sc.close();

        return polylines;
    }

    private static Polyline parseOneLine(String line) {
        Scanner sc = new Scanner(line);
        int width = 1;

        if (sc.hasNextInt()) {
            width = sc.nextInt();
        }

        String color = sc.next();
        Polyline pl = new Polyline(color, width);
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pl.addPoint(new Point(x, y));
        }
        sc.close();
        return pl;
    }


}
