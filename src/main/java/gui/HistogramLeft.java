package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by schoch on 20.05.15.
 */
public class HistogramLeft extends JPanel {

    public void histogramLeftComponent(){

        JLabel textHL = new JLabel("Histogram");
        add(textHL);
    }

    public void paintComponent (Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.MAGENTA);

    }



}
