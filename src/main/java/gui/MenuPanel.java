package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by schoch on 13.05.15.
 */
public class MenuPanel extends JPanel {


    public void menuComponent() {

        System.out.println("Hello");

        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.YELLOW);


        JButton data = new JButton("Datei");
        panelMenu.add(data);

        JLabel variable01 = new JLabel("Variabel X:");
        panelMenu.add(variable01);
        String variabel01Liste[] = {"a", "b", "c"};

        JComboBox variable01Auswahl = new JComboBox(variabel01Liste);
        panelMenu.add(variable01Auswahl);

        JLabel variable02 = new JLabel("Variabel Y:");
        panelMenu.add(variable02);
        String variabel02Liste[] = {"a", "b", "c"};

        JComboBox variable02Auswahl = new JComboBox(variabel02Liste);
        panelMenu.add(variable02Auswahl);

        JLabel variablePunktgrösse = new JLabel("Variabel Punktgrösse:");
        panelMenu.add(variablePunktgrösse);
        String variabelpunktListe[] = {"a", "b", "c"};

        JComboBox variablePGAuswahl = new JComboBox(variabelpunktListe);
        panelMenu.add(variablePGAuswahl);

        data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
            }
        });

        JCheckBox drawingLineCheckBox = new JCheckBox("DrawLines");
        panelMenu.add(drawingLineCheckBox);
    }


}

