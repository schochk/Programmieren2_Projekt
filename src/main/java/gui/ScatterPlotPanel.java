package gui;

import ch.n1b.mirij2.model.Serie;

import javax.swing.*;
import java.awt.*;

/**
 * Created by schoch on 14.05.15.
 */
public class ScatterPlotPanel extends JPanel {
    Serie xList;
    Serie yList;
    String xName;
    String yName;

    boolean drawLines = false;

    int radius = 5;

    public void setter(Serie serieX, Serie serieY, String nameX, String nameY) {
        this.xList = serieX;
        this.yList = serieY;
        this.xName = nameX;
        this.yName = nameY;
        this.repaint();
    }


    public void drawLine(boolean q) {
        this.drawLines = q;
        repaint();
    }

    public void adjustRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    public void paintComponent(Graphics g) {
        if (xList != null && yList != null) {
            double maxVariableX = xList.range().getY();
            double maxVariableY = yList.range().getY();
            double minVariableX = xList.range().getX();
            double minVariableY = yList.range().getX();


            double deltaX = (getWidth() - 2 * radius) / (maxVariableX - minVariableX);
            double deltaY = (getHeight() - 2 * radius) / (maxVariableY - minVariableY);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.BLACK);

            for (int i = 0; i < xList.size(); i++) {

                g.fillOval((int) ((2 * radius) + (deltaX * (xList.get(i) - minVariableX) - 2 * radius)), (int) (getHeight() - (deltaY * (yList.get(i) - minVariableY)) - 2 * radius), 2 * radius, 2 * radius);
            }
            g.setColor(Color.BLACK);
            g.drawString(yName, 10, 20);
            g.drawString(xName, getWidth()-120, getHeight()-10);


            if (drawLines) {
                for (int i = 0; i < xList.size() - 1; i++) {
                    int j = i + 1;
                    int ax = (int) ((2 * radius) + (deltaX * (xList.get(i) - minVariableX) - 2 * radius) + radius);
                    int ay = (int) (getHeight() - (deltaY * (yList.get(i) - minVariableY)) - 2 * radius + radius);

                    int bx = (int) ((2 * radius) + (deltaX * (xList.get(j) - minVariableX) - 2 * radius) + radius);
                    int by = (int) (getHeight() - (deltaY * (yList.get(j) - minVariableY)) - 2 * radius + radius);

                    g.drawLine(ax, ay, bx, by);
                }

            }

            updateUI();
        }

    }
}


