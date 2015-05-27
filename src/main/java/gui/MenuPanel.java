package gui;

import javax.swing.*;
import java.awt.*;
import ch.n1b.mirij2.*;
import ch.n1b.mirij2.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by schoch on 13.05.15.
 */
public class MenuPanel extends JPanel {


    public void menuComponent() {

        setBackground(Color.YELLOW);

        /*JLabel test = new JLabel("Datei wählen:");
        add(test);

        JButton data = new JButton("Datei");
        add(data);*/

        JLabel variable01 = new JLabel("Variabel X:");
        add(variable01);
        String variabel01Liste[] = {"a,b, c"};

        JComboBox variable01Auswahl = new JComboBox(variabel01Liste);
        add(variable01Auswahl);

        JLabel variable02 = new JLabel("Variabel Y:");
        add(variable02);
        String variabel02Liste[] = {"a", "b", "c"};

        JComboBox variable02Auswahl = new JComboBox(variabel02Liste);
        add(variable02Auswahl);
    }
}

