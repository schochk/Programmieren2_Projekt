package ch.n1b.mirij2;

import ch.n1b.mirij2.loader.ColumnFile;
import ch.n1b.mirij2.loader.RowFile;
import ch.n1b.mirij2.loader.SeriesFileLoader;
import ch.n1b.mirij2.model.Serie;
import ch.n1b.mirij2.model.SeriesFile;
import gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends JPanel {

    public static void main(String[] args) throws FileNotFoundException {
        String nameFile = null;

        JFileChooser chooser = new JFileChooser();

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            nameFile = selectedFile.getName();

            SeriesFileLoader loader = null;

            if (nameFile.endsWith("txt")) {
                loader = new ColumnFile();
            } else if (nameFile.endsWith("lin")) {
                loader = new RowFile();
            } else {
                System.err.println("File format unknown.");
            }
            if (loader != null) {
                final SeriesFile seriesFile;
                try {
                    seriesFile = loader.load(selectedFile);
                    JFrame mainFrame = new JFrame();
                    mainFrame.setLayout(new BorderLayout());

                    JPanel panelMain = new JPanel();
                    panelMain.setLayout(new BorderLayout());

                    MenuPanel panelMenu = new MenuPanel();
                    panelMenu.menuComponent(seriesFile);
                    panelMain.add(panelMenu, BorderLayout.NORTH);

                    JPanel panelPlot = new JPanel();
                    panelPlot.setLayout(new GridLayout(2, 1));
                    panelMain.add(panelPlot, BorderLayout.CENTER);

                    JPanel panelScatterPlot = new JPanel();
                    panelScatterPlot.setLayout(new BorderLayout());
                    panelPlot.add(panelScatterPlot);

                    final ScatterPlotPanel scatterPlotPanel = new ScatterPlotPanel();
                    panelScatterPlot.add(scatterPlotPanel, BorderLayout.CENTER);

                    ScatterPlotOptionPanel scatterPlotOptionPanel = new ScatterPlotOptionPanel(scatterPlotPanel);
                    panelScatterPlot.add(scatterPlotOptionPanel, BorderLayout.NORTH);

                    JPanel panelHistogram = new JPanel();
                    panelHistogram.setLayout(new GridLayout(1, 2));
                    panelPlot.add(panelHistogram);

                    HistogramLeft histogramLeft = new HistogramLeft();
                    panelHistogram.add(histogramLeft);

                    HistogramRight histogramRight = new HistogramRight();
                    panelHistogram.add(histogramRight);

                    mainFrame.add(panelMain);

                    JPanel panel = new JPanel();
                    JButton button = new JButton("OK");
                    panel.add(button);
                    panelMenu.add(panel);

                    final int FRAME_WIDTH = 700;
                    final int FRAME_HEIGHT = 600;
                    mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                    mainFrame.setTitle(nameFile);
                    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainFrame.setLocationRelativeTo(null);

                    mainFrame.setVisible(true);

                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            String nameX = panelMenu.getNameX();
                            String nameY = panelMenu.getNameY();
                            Serie seriex = seriesFile.getSerie(nameX);
                            Serie seriey = seriesFile.getSerie(nameY);
                            scatterPlotPanel.setter(seriex, seriey, nameX, nameY);
                            histogramLeft.histogramL(seriex, nameX);
                            histogramRight.histogramR(seriey, nameY);

                        }

                    });

                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Can not load file.");

                }

            } else {
                System.err.println("Unable to read the values.");
            }

        }

    }


}




