package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by schoch on 13.05.15.
 */
public class MenuPanel extends JPanel {


    public void menuComponent() {

        /*Graphics2D m = (Graphics2D) k;
        m.setColor(Color.YELLOW);
        m.fillRect(0,0, this.getWidth(), this.getHeight());
        */


        JButton data = new JButton("Datei");
        add(data);

        JLabel variable01 = new JLabel("Variabel X:");
        add(variable01);
        String variabel01Liste[] = {"a", "b", "c"};

        JComboBox variable01Auswahl = new JComboBox(variabel01Liste);
        add(variable01Auswahl);

        JLabel variable02 = new JLabel("Variabel Y:");
        add(variable02);
        String variabel02Liste[] = {"a", "b", "c"};

        JComboBox variable02Auswahl = new JComboBox(variabel02Liste);
        add(variable02Auswahl);

        JLabel variablePunktgrösse = new JLabel("Variabel Punktgrösse:");
        add(variablePunktgrösse);
        String variabelpunktListe[] = {"a", "b", "c"};

        JComboBox variablePGAuswahl = new JComboBox(variabelpunktListe);
        add(variablePGAuswahl);

        data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
            }
        });

        JCheckBox drawingLineCheckBox = new JCheckBox("DrawLines");
        add(drawingLineCheckBox);


    }

}

