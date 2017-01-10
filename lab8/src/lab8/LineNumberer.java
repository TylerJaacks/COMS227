package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.System.in;

public class LineNumberer {
    public static void main(String[] args) {
        try {
            File inFile = new File("/Users/tylerjaacks/Documents/Projects/" +
                    "IntelliJ Projects/COMS227/src/lab7/Deck.java");
            File outFile = new File("/Users/tylerjaacks/Documents/" +
                    "Projects/IntelliJ Projects/COMS227/src/lab8/mydocument.txt");
            Scanner in = new Scanner(System.in);
            Scanner fileScanner = new Scanner(inFile);
            PrintWriter out = new PrintWriter(outFile);

            int lineCount = 1;

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.print(lineCount + " ");
                out.print(lineCount + " ");
                System.out.println(line);
                out.println(line);
                lineCount += 1;
            }

            System.out.println("Done");
            out.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File Not Found");
        }
    }
}