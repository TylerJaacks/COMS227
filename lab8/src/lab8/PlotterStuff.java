//package lab8;
//
//import plotter.Plotter;
//import plotter.Polyline;
//
//import java.awt.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class PlotterStuff {
//    Plotter plotter = new Plotter();
//
//    public static void main(String[] args) {
//        File file = new File("/Users/tylerjaacks/Documents/" +
//                "Projects/IntelliJ Projects/COMS227/src/lab8/tests.txt");
//        getData(file);
//
//        Plotter plotter = new Plotter();
//
//        for (Polyline p : getData(file)) {
//            plotter.plot(p);
//        }
//    }
//
//    public static ArrayList<Polyline> getData(File file) {
//        ArrayList<String> data = new ArrayList<String>();
//        ArrayList<Polyline> tests = new ArrayList<Polyline>();
//
//        int width = 0;
//
//        try (Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//
//                if (line.startsWith("#") || line.length() == 0) {
//
//                } else {
//                    data.add(line);
//                    Scanner s = new Scanner(line);
//
//                    if(s.hasNextInt()){
//                        width= s.nextInt();
//                    } else {
//                        width=1;
//                    }
//
//                    Polyline pl = new Polyline(s.next(), width);
//
//                    while(s.hasNextInt()) {
//                        pl.addPoint(new Point(s.nextInt(), s.nextInt()));
//                    }
//
//                    tests.add(pl);
//                }
//            }
//        } catch (FileNotFoundException fileNotFoundException) {
//
//        }
//
//        return tests;
//    }
//}