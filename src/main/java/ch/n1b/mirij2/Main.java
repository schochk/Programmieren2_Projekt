package ch.n1b.mirij2;

import ch.n1b.mirij2.loader.ColumnFile;
import ch.n1b.mirij2.loader.RowFile;
import ch.n1b.mirij2.loader.SeriesFileLoader;
import ch.n1b.mirij2.model.SeriesFile;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        while (true) {
            // Read the file name
            System.out.print("File name: ");
            String inputLine = inputScanner.nextLine();

            SeriesFileLoader loader = null;

            // Decide which concrete loader to use.
            if (inputLine.endsWith("txt")) {
                loader = new ColumnFile(); //tab-delimited
            } else if (inputLine.endsWith("lin")) {
                loader = new RowFile();
            } else {
                System.err.println("File format unknown.");
            }
            if (loader != null) {
                SeriesFile seriesFile = null;
                try {
                    seriesFile = loader.load(inputLine);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Can not load file.");
                }

                if (seriesFile != null) {
                    System.out.println(seriesFile.getNames());
                } else {
                    System.err.println("Unable to read the values.");
                }


            }
        }

    }


}
