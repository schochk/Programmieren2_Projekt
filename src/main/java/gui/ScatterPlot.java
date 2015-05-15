package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by schoch on 14.05.15.
 */
public class ScatterPlot extends JPanel {

    public void scatterPlotComponent() {

        /*JPanel scatterPlot = new JPanel();
        scatterPlot.setBackground(Color.BLUE);

        JLabel test = new JLabel("Test");
        scatterPlot.add(test);
        add(scatterPlot);*/

    }

        //JPanel panel;

        /*public KreisZeichnen(){
            panel = new KreisPanel();
            add(panel);

            this.setSize(300, 300);
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }*/


    public void paintComponent(Graphics g) {

        JLabel test = new JLabel("Test");


        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.BLACK);
        int mx = (getWidth()/2);
        int my = (getHeight()/2);
        int r = 5;
        Ellipse2D.Double kreis = new Ellipse2D.Double(mx - r, my - r, 2 * r, 2 * r);

        g2d.fill(kreis);


    }



}


