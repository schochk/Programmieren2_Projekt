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

    List<Integer> xList = Arrays.asList(2620,3190,3640,4000,4180,4150,3860,3520,3080,2630,2050,1610,1300,1090,1130,1340,1680,2140,1980,2000,2250,2220,2960,2930,3170,3140,3500,3280,2890,2500,2180,1860);
    double maxvx = Collections.max(xList);
    double minvx = Collections.min(xList);

    public HistogramLeft(){

        JLabel nameHL = new JLabel("Histogram Links");
        add(nameHL);
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

        g.setColor(Color.YELLOW);
        g.fillRect(0,getHeight()-(barHeight*a),(int)(barWidth*1.0), getHeight());
        g.fillRect((int)(barWidth*1.0),getHeight()-barHeight*b,(int)(barWidth*1.0), getHeight());
        g.fillRect((int)(barWidth*2.0),getHeight()-(barHeight*c),(int)(barWidth*1.0), getHeight());
        g.fillRect((int)(barWidth*3.0),getHeight()-(barHeight*d),(int)(barWidth*1.0), getHeight());
        g.fillRect((int)(barWidth*4.0),getHeight()-(barHeight*e),(int)(barWidth*1.0), getHeight());
        g.fillRect((int)(barWidth*5.0),getHeight()-(barHeight*f),(int)(barWidth*1.0), getHeight());

        g.setColor(Color.ORANGE);
        g.drawRect(0, getHeight() - (barHeight * a), barWidth, getHeight());
        g.drawRect(barWidth, getHeight() - barHeight * b, barWidth, getHeight());
        g.drawRect(barWidth * 2, getHeight() - (barHeight * c), barWidth, getHeight());
        g.drawRect(barWidth * 3, getHeight() - (barHeight * d), barWidth, getHeight());
        g.drawRect(barWidth * 4, getHeight() - (barHeight * e), barWidth, getHeight());
        g.drawRect(barWidth * 5, getHeight() - (barHeight * f), barWidth, getHeight());

        updateUI();

    }
}
