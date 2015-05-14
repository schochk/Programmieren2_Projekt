package gui;

import javax.swing.*;
import java.awt.*;


/**
 * Created by schoch on 07.05.15.
 */
public class UserInterface extends JPanel {

    public static void main(String[] args) {

        JFrame mainFrame = new JFrame();

        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());


        MenuPanel panelMenu = new MenuPanel();          //MenuPanel
        panelMenu.menuComponent();
        panelMain.add(panelMenu, BorderLayout.NORTH);


        JPanel panelPlot = new JPanel();
        panelPlot.setLayout(new GridLayout(2, 1));
        panelMain.add(panelPlot, BorderLayout.CENTER);

        ScatterPlot scatterPlot = new ScatterPlot();
        scatterPlot.scatterPlot();
        panelPlot.add(scatterPlot);

        /*JPanel scatterPlot = new JPanel();
        scatterPlot.setBackground(Color.BLUE);
        panelPlot.add(scatterPlot);
            */
        JPanel panelHistogram = new JPanel();
        panelHistogram.setLayout(new GridLayout(1, 2));
        panelPlot.add(panelHistogram);

        panelDrawingLeft(panelHistogram); //Histogramm Links


        JPanel panelHistogramRight = new JPanel(); //Histogramm Rechts
        panelHistogramRight.setBackground(Color.GREEN);
        panelHistogram.add(panelHistogramRight);


        mainFrame.add(panelMain);

        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 600;
        mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainFrame.setTitle("Programmieren 2 Projekt");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null); // center on screen

        mainFrame.setVisible(true);

    }

    private static void panelDrawingLeft(JPanel panelBalken) {
        JPanel panelHistogramLeft = new JPanel();
        panelHistogramLeft.setBackground(Color.CYAN);
        panelBalken.add(panelHistogramLeft);
    }



}




