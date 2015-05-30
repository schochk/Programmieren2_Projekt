package ch.n1b.mirij2;

import ch.n1b.mirij2.loader.ColumnFile;
import ch.n1b.mirij2.loader.RowFile;
import ch.n1b.mirij2.loader.SeriesFileLoader;
import ch.n1b.mirij2.model.DataSeries;
import ch.n1b.mirij2.model.Serie;
import ch.n1b.mirij2.model.SeriesFile;
import gui.*;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main extends JPanel {

    public static void main(String[] args) throws FileNotFoundException {
        String nameFile = null;

        JFileChooser chooser = new JFileChooser();
        Scanner inputScanner = null;
        if (chooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = chooser.getSelectedFile();
            inputScanner = new Scanner(selectedFile);
            nameFile = selectedFile.getName();


            SeriesFileLoader loader = null;

            // Decide which concrete loader to use.
            if (nameFile.endsWith("txt")) {
                loader = new ColumnFile(); //tab-delimited
            } else if (nameFile.endsWith("lin")) {
                loader = new RowFile();
            } else {
                System.err.println("File format unknown.");
            }
            if (loader != null) {
                SeriesFile seriesFile = null;
                try {
                    seriesFile = loader.load(selectedFile); /*inputLine*/
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Can not load file.");

                }

                if (seriesFile != null) {
                    System.out.println(seriesFile.getNames());

                    JFrame mainFrame = new JFrame();
                    mainFrame.setLayout(new BorderLayout());

                    JPanel panelMain = new JPanel();
                    panelMain.setLayout(new BorderLayout());

                    MenuPanel panelMenu = new MenuPanel();          //MenuPanel
                    panelMenu.menuComponent(seriesFile);
                    panelMain.add(panelMenu, BorderLayout.NORTH);

                    JPanel panelPlot = new JPanel();
                    panelPlot.setLayout(new GridLayout(2, 1));
                    panelMain.add(panelPlot, BorderLayout.CENTER);

                    JPanel panelScatterPlot = new JPanel();
                    panelScatterPlot.setLayout(new BorderLayout());
                    panelPlot.add(panelScatterPlot);

                    ScatterPlotPanel scatterPlotPanel = new ScatterPlotPanel(); //ScatterPlot einfügen
                    panelScatterPlot.add(scatterPlotPanel, BorderLayout.CENTER);

                    ScatterPlotOptionPanel scatterPlotOptionPanel = new ScatterPlotOptionPanel(scatterPlotPanel);      //Optionen
                    panelScatterPlot.add(scatterPlotOptionPanel, BorderLayout.NORTH);

                    JPanel panelHistogram = new JPanel();
                    panelHistogram.setLayout(new GridLayout(1, 2));
                    panelPlot.add(panelHistogram);

                    HistogramLeft histogramLeft = new HistogramLeft();  //Histogramm Links einfügen
                    panelHistogram.add(histogramLeft);

                    HistogramRight histogramRight = new HistogramRight();   //Histogramm Rechts einfügen
                    panelHistogram.add(histogramRight);

                    DataPanel dataPanel = new DataPanel();
                    panelMain.add(dataPanel, BorderLayout.SOUTH);

                    mainFrame.add(panelMain);

                    final int FRAME_WIDTH = 700;
                    final int FRAME_HEIGHT = 600;
                    mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                    mainFrame.setTitle("Programmieren 2 Projekt");
                    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainFrame.setLocationRelativeTo(null); // center on screen

                    mainFrame.setVisible(true);

                }
                new DataSeries(seriesFile.getSerie("Variabel 1"), seriesFile.getSerie("Variabel 2"));


            } else {
                System.err.println("Unable to read the values.");
            }
        }
    }
}



