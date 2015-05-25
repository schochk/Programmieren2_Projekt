package gui;

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

        ScatterPlot scatterPlot = new ScatterPlot(); //ScatterPlot einfügen
        scatterPlot.scatterPlotComponent();
        panelPlot.add(scatterPlot);

        JPanel panelHistogram = new JPanel();
        panelHistogram.setLayout(new GridLayout(1, 2));
        panelPlot.add(panelHistogram);

        HistogramLeft histogramLeft = new HistogramLeft();  //Histogramm Links einfügen
        histogramLeft.histogramLeftComponent();
        panelHistogram.add(histogramLeft);

        HistogramRight histogramRight = new HistogramRight();   //Histogramm Rechts einfügen
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

}




