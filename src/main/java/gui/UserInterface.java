package gui;

import ch.n1b.mirij2.model.SeriesFile;

import javax.swing.*;
import java.awt.*;


/**
 * Created by schoch on 07.05.15.
 */
public class UserInterface extends JPanel {

    public static void main(String[] args) {

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

}




