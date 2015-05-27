package gui;

import ch.n1b.mirij2.model.SeriesFile;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

/**
 * Created by schoch on 13.05.15.
 */
public class MenuPanel extends JPanel {

    public void menuComponent(SeriesFile seriesFile) {

        setBackground(Color.YELLOW);

        /*JLabel test = new JLabel("Datei wählen:");    //Dateiauswahl Panel
        add(test);

        JButton data = new JButton("Datei");
        add(data);*/

        JLabel variableX = new JLabel("Variabel X:");
        add(variableX);
        String variableList[] = seriesFile.getNames().toArray(new String[0]);

        JComboBox variableXSelect = new JComboBox(variableList);
        add(variableXSelect);

        JLabel variableY = new JLabel("Variabel Y:");
        add(variableY);

        JComboBox variableYSelect = new JComboBox(variableList);
        add(variableYSelect);

    }

    public void menuComponent() {
    }
}

