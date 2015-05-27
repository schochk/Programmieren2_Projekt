package gui;

import ch.n1b.mirij2.model.SeriesFile;

import javax.swing.*;
import java.awt.*;

/**
 * Created by schoch on 13.05.15.
 */
public class MenuPanel extends JPanel {

    public void menuComponent() {

        setBackground(Color.YELLOW);

        /*JLabel test = new JLabel("Datei wählen:");    //Dateiauswahl Panel
        add(test);

        JButton data = new JButton("Datei");
        add(data);*/

        JLabel variableX = new JLabel("Variabel X:");
        add(variableX);
        String variableXList[] = {getName()};

        JComboBox variableXSelect = new JComboBox(variableXList);
        add(variableXSelect);

        JLabel variableY = new JLabel("Variabel Y:");
        add(variableY);
        String variableYList[] = {"a", "b", "c"};

        JComboBox variableYSelect = new JComboBox(variableYList);
        add(variableYSelect);

    }
}

