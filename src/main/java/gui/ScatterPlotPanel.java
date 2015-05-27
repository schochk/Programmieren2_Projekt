package gui;

import ch.n1b.mirij2.model.DataSeries;
import ch.n1b.mirij2.model.SeriesFile;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by schoch on 14.05.15.
 */
public class ScatterPlotPanel extends JPanel {

    List<Integer> xList =Arrays.asList(2620,3190,3640,4000,4180,4150,3860,3520,3080,2630,2050,1610,1300,1090,1130,1340,1680,2140,1980,2000,2250,2220,2960,2930,3170,3140,3500,3280,2890,2500,2180,1860);
    double maxvx = Collections.max(xList);
    double minvx = Collections.min(xList);

    List<Integer> yList = Arrays.asList(4000,3880,3620,3200,2620,2030,1470,1170,960,880,1010,1280,1680,2200,2730,3260,3660,3910,2980,2780,2760,3010,3050,2860,3070,2860,2120,1780,1630,1610,1710,2020);
    double maxvy = Collections.max(yList);
    double minvy = Collections.min(yList);

    boolean drawLines =false;

    int radius = 5;



    public void drawLine (boolean q){
        this.drawLines = q;
        repaint();
    }

    public void adjustRadius (int radius){
        this.radius = radius;
        repaint();
    }

    public void paintComponent(Graphics g) {


        double xd = (getWidth() - 2* radius) / (maxvx-minvx);
        double yd = (getHeight() - 2* radius) / (maxvy-minvy);

        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);

        for(int i = 0; i < xList.size(); i++){

            g.fillOval((int)((2 * radius) + (xd * (xList.get(i)-minvx)-2* radius)), (int)(getHeight()-(yd*(yList.get(i)-minvy))-2* radius),2* radius,2* radius);
        }

        if(drawLines) {
        for(int i = 0; i < xList.size()-1; i++){
            int j = i+1;
            int ax = (int)((2 * radius) + (xd * (xList.get(i)-minvx)-2* radius)+ radius);
            int ay = (int)(getHeight()-(yd*(yList.get(i)-minvy))-2* radius + radius);

            int bx = (int)((2 * radius) + (xd * (xList.get(j)-minvx)-2* radius)+ radius);
            int by = (int)(getHeight()-(yd*(yList.get(j)-minvy))-2* radius + radius);

            g.drawLine(ax, ay, bx, by);
            }
        }
        updateUI();
    }
}


