package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by schoch on 20.05.15.
 */
public class HistogramLeft extends JPanel {

    List<Integer> xList = Arrays.asList(2,3,4,2620,3190,3640,4000,4180,4150,3860,3520,3080,2630,2050,1610,1300,1090,1130,1340,1680,2140,1980,2000,2250,2220,2960,2930,3170,3140,3500,3280,2890,2500,2180,1860);
    double maxvx = Collections.max(xList);
    double minvx = Collections.min(xList);

    public void histogramLeftComponent(){

        JLabel textHL = new JLabel("Histogram Links");
        add(textHL);
    }

    public void paintComponent (Graphics g){

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;

        //g.setColor(Color.LIGHT_GRAY);
        //g.fillRect(0,0, this.getWidth(), this.getHeight());

        for(int i = 0; i<xList.size(); i++){

            if(xList.get(i)<=(maxvx/6)){
                a = a + 1;
            }
            else if((maxvx/6)<xList.get(i) && xList.get(i)<=(maxvx/3)){
                b = b+1;
            }
            else if((maxvx/3)<xList.get(i) && xList.get(i)<=(maxvx/2)){
                c = c+1;
            }
            else if((maxvx/2)<xList.get(i) && xList.get(i)<=(maxvx/1.5)){
                d = d+1;
            }
            else if((maxvx/1.5)<xList.get(i) && xList.get(i)<=(maxvx/1.2)){
                e = e+1;
            }
            else if((maxvx/1.2)<xList.get(i) && xList.get(i)<=(maxvx)){
                f = f+1;
            }
        }

        double h=a+b+c+d+e+f;

        int barHeight = (int)(getHeight()/h);
        int barWidth = (int)(getWidth() / 6.0);

        g.setColor(Color.ORANGE);
        g.fillRect(0,getHeight()-(barHeight*a),barWidth, getHeight());
        g.fillRect(barWidth,getHeight()-barHeight*b,barWidth, getHeight());
        g.fillRect(barWidth*2,getHeight()-(barHeight*c),barWidth, getHeight());
        g.fillRect(barWidth*3,getHeight()-(barHeight*d),barWidth, getHeight());
        g.fillRect(barWidth*4,getHeight()-(barHeight*e),barWidth, getHeight());
        g.fillRect(barWidth*5,getHeight()-(barHeight*f),barWidth, getHeight());

        updateUI();

    }
}
