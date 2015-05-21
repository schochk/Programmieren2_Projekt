package gui;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by schoch on 20.05.15.
 */
public class HistogramRight extends JPanel {

    java.util.List<Integer> yList = Arrays.asList(1,2,3,4000,3880,3620,3200,2620,2030,1470,1170,960,880,1010,1280,1680,2200,2730,3260,3660,3910,2980,2780,2760,3010,3050,2860,3070,2860,2120,1780,1630,1610,1710,2020);
    double maxvy = Collections.max(yList);
    double minvy = Collections.min(yList);


    public void histogramRightComponent() {

        JLabel textHR = new JLabel("Histogram Rechts");
        add(textHR);
    }

    public void paintComponent (Graphics g){

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;

        g.setColor(Color.GREEN);
        g.fillRect(0,0, this.getWidth(), this.getHeight());

        for(int i = 0; i<yList.size(); i++){

            if(yList.get(i)<=(maxvy/6)){
                a = a + 1;
            }
            else if((maxvy/6)<yList.get(i) && yList.get(i)<=(maxvy/3)){
                b = b+1;
            }
            else if((maxvy/3)<yList.get(i) && yList.get(i)<=(maxvy/2)){
                c = c+1;
            }
            else if((maxvy/2)<yList.get(i) && yList.get(i)<=(maxvy/1.5)){
                d = d+1;
            }
            else if((maxvy/1.5)<yList.get(i) && yList.get(i)<=(maxvy/1.2)){
                e = e+1;
            }
            else if((maxvy/1.2)<yList.get(i) && yList.get(i)<=(maxvy)){
                f = f+1;
            }
        }

        int h=a+b+c+d+e+f;

        int barHeight = getHeight()/h;
        int barWidth = getWidth() / 6;

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,getHeight()-(barHeight*a),barWidth, getHeight());
        g.fillRect(barWidth,getHeight()-barHeight*b,barWidth, getHeight());
        g.fillRect(barWidth*2,getHeight()-(barHeight*c),barWidth, getHeight());
        g.fillRect(barWidth*3,getHeight()-(barHeight*d),barWidth, getHeight());
        g.fillRect(barWidth*4,getHeight()-(barHeight*e),barWidth, getHeight());
        g.fillRect(barWidth*5,getHeight()-(barHeight*f),barWidth, getHeight());

        updateUI();

    }
}

