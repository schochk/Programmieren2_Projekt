package gui;

import ch.n1b.mirij2.model.Serie;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by schoch on 20.05.15.
 */
public class HistogramRight extends JPanel {

    Serie yList;


    public HistogramRight() {

        JLabel nameHR = new JLabel("Histogram Rechts");
        add(nameHR);
    }
    public void histogramR(Serie seriey) {
        this.yList = seriey;
        this.repaint();
    }

    public void paintComponent (Graphics g) {
        if (yList != null) {
            double maxvy = yList.range().getY();
            double minvy = yList.range().getX();

            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            int f = 0;

            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            for (int i = 0; i < yList.size(); i++) {

                if (yList.get(i) <= (maxvy / 6)) {
                    a = a + 1;
                } else if ((maxvy / 6) < yList.get(i) && yList.get(i) <= (maxvy / 3)) {
                    b = b + 1;
                } else if ((maxvy / 3) < yList.get(i) && yList.get(i) <= (maxvy / 2)) {
                    c = c + 1;
                } else if ((maxvy / 2) < yList.get(i) && yList.get(i) <= (maxvy / 1.5)) {
                    d = d + 1;
                } else if ((maxvy / 1.5) < yList.get(i) && yList.get(i) <= (maxvy / 1.2)) {
                    e = e + 1;
                } else if ((maxvy / 1.2) < yList.get(i) && yList.get(i) <= (maxvy)) {
                    f = f + 1;
                }
            }

            int h = a + b + c + d + e + f;

            int barHeight = getHeight() / h;
            int barWidth = getWidth() / 6;

            g.setColor(Color.GREEN);
            g.fillRect(0, getHeight() - (barHeight * a), barWidth, getHeight());
            g.fillRect(barWidth, getHeight() - barHeight * b, barWidth, getHeight());
            g.fillRect(barWidth * 2, getHeight() - (barHeight * c), barWidth, getHeight());
            g.fillRect(barWidth * 3, getHeight() - (barHeight * d), barWidth, getHeight());
            g.fillRect(barWidth * 4, getHeight() - (barHeight * e), barWidth, getHeight());
            g.fillRect(barWidth * 5, getHeight() - (barHeight * f), barWidth, getHeight());

            g.setColor(Color.BLUE);
            g.drawRect(0, getHeight() - (barHeight * a), barWidth, getHeight());
            g.drawRect(barWidth, getHeight() - barHeight * b, barWidth, getHeight());
            g.drawRect(barWidth * 2, getHeight() - (barHeight * c), barWidth, getHeight());
            g.drawRect(barWidth * 3, getHeight() - (barHeight * d), barWidth, getHeight());
            g.drawRect(barWidth * 4, getHeight() - (barHeight * e), barWidth, getHeight());
            g.drawRect(barWidth * 5, getHeight() - (barHeight * f), barWidth, getHeight());

            updateUI();

        }
    }
}

