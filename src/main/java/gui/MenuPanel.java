package gui;


import ch.n1b.mirij2.model.SeriesFile;

import javax.swing.*;
import java.awt.*;

/**
 * Created by schoch on 13.05.15.
 */
public class MenuPanel extends JPanel {

    public void menuComponent(SeriesFile seriesFile) {

        setBackground(Color.YELLOW);


        JLabel variableX = new JLabel("Variabel X:");
        add(variableX);
        String variableXList[] = seriesFile.getNames().toArray(new String[0]);

        JComboBox variableXSelect = new JComboBox(variableXList);

        /*variableXSelect.addActionListener((ActionEvent e)->{
                    String nameX = panelMenu.getNameX();
                    String nameY = panelMenu.getNameY();
                    Serie seriex = seriesFile.getSerie(nameX);
                    Serie seriey = seriesFile.getSerie(nameY);
                    scatterPlotPanel.setter(seriex, seriey, nameX, nameY);
                    histogramLeft.histogramL(seriex, nameX);
                    histogramRight.histogramR(seriey, nameY);
                }
        );*/

        add(variableXSelect);



        JLabel variableY = new JLabel("Variabel Y:");
        add(variableY);

        JComboBox variableYSelect = new JComboBox(variableXList);
        add(variableYSelect);

        this.boxX = variableXSelect;
        this.boxY = variableYSelect;



    }

    JComboBox boxX;
    JComboBox boxY;

    public String getNameX(){
        String namex = this.boxX.getSelectedItem().toString();
        return namex;
    }
    public String getNameY(){
        String namey = this.boxY.getSelectedItem().toString();
        return namey;
    }

    public void menuComponent() {
    }
}

