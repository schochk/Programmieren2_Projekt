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
        add(variableXSelect);

        JLabel variableY = new JLabel("Variabel Y:");
        add(variableY);
        JComboBox variableYSelect = new JComboBox(variableXList);
        add(variableYSelect);

    }

    public void menuComponent() {
    }
}

