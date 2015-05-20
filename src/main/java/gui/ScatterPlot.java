package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by schoch on 14.05.15.
 */
public class ScatterPlot extends JPanel {


    List<Integer> xList = Arrays.asList(2620,3190,3640,4000,4180,4150,3860,3520,3080,2630,2050,1610,1300,1090,1130,1340,1680,2140,1980,2000,2250,2220,2960,2930,3170,3140,3500,3280,2890,2500,2180,1860);
    double maxvx = Collections.max(xList);
    double minvx = Collections.min(xList);

    List<Integer> yList = Arrays.asList(4000,3880,3620,3200,2620,2030,1470,1170,960,880,1010,1280,1680,2200,2730,3260,3660,3910,2980,2780,2760,3010,3050,2860,3070,2860,2120,1780,1630,1610,1710,2020);
    double maxvy = Collections.max(yList);
    double minvy = Collections.min(yList);

    int q=0;

    public void scatterPlotComponent() {

        System.out.println(maxvx);
        System.out.println(minvx);

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

        double xd = (getWidth() - 1) / (maxvx-minvx);
        double yd = (getHeight() - 1) / (maxvy-minvy);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2d.setColor(Color.BLACK);
        int mx = (int)((getWidth()/100.0)*50.0);
        int my = (int) ((getHeight()/100.0)*50.0);
        //int ax = (int) (xd * (364.0 - minvx)); //(getW-1)/delta * (xn-xmin)
        //int ay = (int) (getHeight()-(yd * (400.0 - minvy))); //getH-((getH-1)/delta * (yn-ymin))

        int r = 5;

        g.fillOval(mx-r, my-r, 2*r, 2*r);


        for(int i = 0; i < xList.size(); i++){

            g.fillOval((int)(xd * (xList.get(i)-minvx)-r), (int)(getHeight()-(yd*(yList.get(i)-minvy))-r),2*r,2*r);

        }

        /*if(q==1) {
            g.drawLine(mx, my, ax, ay);
          //  g.drawLine(ax, ay, bx, by);
            //g.drawLine(bx, by, mx, my);
        }*/

        updateUI();

    }

}


