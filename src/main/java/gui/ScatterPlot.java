package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

/**
 * Created by schoch on 14.05.15.
 */
public class ScatterPlot extends JPanel {

    double vxListe[] = {262, 319, 364, 400, 418};
    double vyListe[] = {400, 388, 363, 320, 262};

    int q=0;

    public void scatterPlotComponent() {

        JLabel textSP = new JLabel("ScatterPlot");
        add(textSP);

        final JCheckBox lineButton = new JCheckBox("DrawLines");
        add(lineButton);

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lineButton.isSelected()){q=1;}
                else{q=0;}
            }
        });

    }

    public void paintComponent(Graphics g) {

        int dx = 418-262;
        int xi = (getWidth()-1) / dx;

        int dy = 400-262;
        int yi = (getHeight() - 1) / dy;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.BLACK);
        int mx = ((getWidth()/100)*50);
        int my = ((getHeight()/100)*50);
        int ax = xi * (364 - 262); //(getW-1)/delta * (xn-xmin)
        int ay = getHeight()-(yi * (262 - 262)); //getH-((getH-1)/delta * (yn-ymin))

        int r = 5;
        Ellipse2D.Double m = new Ellipse2D.Double(mx - r, my - r, 2 * r, 2 * r);
        Ellipse2D.Double a = new Ellipse2D.Double(ax - r, ay - r, 2 * r, 2 * r);
        //Ellipse2D.Double b = new Ellipse2D.Double(bx - r, by - r, 2 * r, 2 * r);

        g2d.fill(m);
        g2d.fill(a);


        /*if(q==1) {
            g.drawLine(mx, my, ax, ay);
          //  g.drawLine(ax, ay, bx, by);
            //g.drawLine(bx, by, mx, my);
        }*/

        updateUI();

    }

}


