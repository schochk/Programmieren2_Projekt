package gui;

import javax.swing.*;
import java.awt.*;


/**
 * Created by schoch on 07.05.15.
 */
public class UserInterface extends JPanel {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JPanel panel0 = new JPanel();
        panel0.setLayout(new BorderLayout());


        MenuPanel menuPanel = new MenuPanel();
        panel0.add(panelMenu, BorderLayout.NORTH);


        //panelMenu(panel0);

        JPanel panelPlot = new JPanel();
        panelPlot.setLayout(new GridLayout(2, 1));
        panel0.add(panelPlot, BorderLayout.CENTER);

        JPanel scatterPlot = new JPanel();
        scatterPlot.setBackground(Color.BLUE);
        panelPlot.add(scatterPlot);

        JPanel panelBalken = new JPanel();
        panelBalken.setLayout(new GridLayout(1, 2));
        panelPlot.add(panelBalken);

        panelDrawingLeft(panelBalken);


        JPanel panelDR = new JPanel();
        panelDR.setBackground(Color.GREEN);
        panelBalken.add(panelDR);


        frame.add(panel0);

        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 600;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Programmieren 2 Projekt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center on screen

        frame.setVisible(true);

    }

    private static void panelDrawingLeft(JPanel panelBalken) {
        JPanel panelDL = new JPanel();
        panelDL.setBackground(Color.CYAN);
        panelBalken.add(panelDL);
    }





    /*private static void panelMenu(JPanel panel0) {
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(Color.WHITE);
        panel0.add(panelMenu, BorderLayout.NORTH);

        JButton data = new JButton("Datei");
        panelMenu.add(data);

        JLabel variable01 = new JLabel("Variabel X:");
        panelMenu.add(variable01);
        String variabel01Liste [] = {"a", "b", "c"};

        JComboBox variable01Auswahl = new JComboBox(variabel01Liste);
        panelMenu.add(variable01Auswahl);

        JLabel variable02 = new JLabel("Variabel Y:");
        panelMenu.add(variable02);
        String variabel02Liste [] = {"a", "b", "c"};

        JComboBox variable02Auswahl = new JComboBox(variabel02Liste);
        panelMenu.add(variable02Auswahl);

        JLabel variablePunktgrösse = new JLabel("Variabel Punktgrösse:");
        panelMenu.add(variablePunktgrösse);
        String variabelpunktListe [] = {"a", "b", "c"};

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

    }*/


}




