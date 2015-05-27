package ch.n1b.mirij2;

import ch.n1b.mirij2.loader.ColumnFile;
import ch.n1b.mirij2.loader.RowFile;
import ch.n1b.mirij2.loader.SeriesFileLoader;
import ch.n1b.mirij2.model.DataSeries;
import ch.n1b.mirij2.model.SeriesFile;
import gui.*;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main extends JPanel {

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
                    JFrame mainFrame = new JFrame();
                    mainFrame.setLayout(new BorderLayout());

                    JPanel panelMain = new JPanel();
                    panelMain.setLayout(new BorderLayout());

                    MenuPanel panelMenu = new MenuPanel();          //MenuPanel
                    panelMenu.menuComponent();
                    panelMain.add(panelMenu, BorderLayout.NORTH);

                    JPanel panelPlot = new JPanel();
                    panelPlot.setLayout(new GridLayout(2, 1));
                    panelMain.add(panelPlot, BorderLayout.CENTER);

                    JPanel panelScatterPlot = new JPanel();
                    panelScatterPlot.setLayout(new BorderLayout());
                    panelPlot.add(panelScatterPlot);

                    ScatterPlotOption scatterPlotOption = new ScatterPlotOption();
                    scatterPlotOption.optionComponent();
                    panelScatterPlot.add(scatterPlotOption, BorderLayout.NORTH);

                    ScatterPlot scatterPlot = new ScatterPlot(); //ScatterPlot einf�gen
                    scatterPlot.scatterPlotComponent();
                    panelScatterPlot.add(scatterPlot, BorderLayout.CENTER);

                    JPanel panelHistogram = new JPanel();
                    panelHistogram.setLayout(new GridLayout(1, 2));
                    panelPlot.add(panelHistogram);

                    HistogramLeft histogramLeft = new HistogramLeft();  //Histogramm Links einf�gen
                    histogramLeft.histogramLeftComponent();
                    panelHistogram.add(histogramLeft);

                    HistogramRight histogramRight = new HistogramRight();   //Histogramm Rechts einf�gen
                    histogramRight.histogramRightComponent();
                    panelHistogram.add(histogramRight);

                    DataPanel dataPanel = new DataPanel();
                    dataPanel.dataComponent();
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

                } else {
                    System.err.println("Unable to read the values.");
                }
            }
        }
    }

