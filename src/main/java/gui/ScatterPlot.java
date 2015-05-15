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

        JLabel test = new JLabel("Test");
        add(test);

    }

    public void paintComponent(Graphics g) {

        JLabel test = new JLabel("Test");


        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.BLACK);
        int mx = ((getWidth()/100)*50);
        int my = ((getHeight()/100)*25);
        int ax = (getWidth()/100)*25;
        int ay = (getHeight()/100)*75;
        int bx = ((getWidth()/100)*75);
        int by = ((getHeight()/100)*75);

        int r = 5;
        Ellipse2D.Double m = new Ellipse2D.Double(mx - r, my - r, 2 * r, 2 * r);
        Ellipse2D.Double a = new Ellipse2D.Double(ax - r, ay - r, 2 * r, 2 * r);
        Ellipse2D.Double b = new Ellipse2D.Double(bx - r, by - r, 2 * r, 2 * r);




        g2d.fill(m);
        g2d.fill(a);
        g2d.fill(b);


    }

}


