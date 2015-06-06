package gui;

import ch.n1b.mirij2.model.Serie;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by schoch on 20.05.15.
 */
public class HistogramRight extends JPanel {

    Serie yList;
    String yName;
    double numberOfBars, binSize;
    List<Integer> bars = new ArrayList<>();

    public HistogramRight() {
        JLabel nameHistogramRight = new JLabel(yName);
        add(nameHistogramRight);
    }

    public void histogramR(Serie serieY, String nameY) {
        this.yList = serieY;
        this.yName = nameY;
        this.repaint();
    }

    public void paintComponent (Graphics g) {

        if (yList != null) {
            double maxVariableY = yList.range().getY();
            double minVariableY = yList.range().getX();

            numberOfBars = Math.sqrt(yList.size());
            binSize = (maxVariableY - minVariableY) / numberOfBars;

            int listLength = yList.size();

            for (int i = 0; i < numberOfBars; i++) {
                bars.add(0);
            }

            for (int j = 0; j < numberOfBars; j++) {
                for (int i = 0; i < listLength; i++) {
                    if (minVariableY + (binSize * j) <= yList.get(i) && yList.get(i) < minVariableY + (binSize * (j + 1))) {
                        bars.set(j, (bars.get(j) + 1));
                    }
                }
            }

        double maxBin = Collections.max(bars);
        int barWidth = (int) (getWidth() / numberOfBars);
        double height = getHeight();

            g.setColor(Color.GRAY);
            g.fillRect(0,0, this.getWidth(), this.getHeight());

        g.setColor(Color.GREEN);
        for (int i = 0; i < bars.size(); i++) {
            g.fillRect((barWidth * i), (int) (height - (height / maxBin * bars.get(i))), barWidth, (int) height);
        }

        g.setColor(Color.BLUE);
        for (int i = 0; i < bars.size(); i++) {
            g.drawRect((barWidth * i), (int) (height - (height / maxBin * bars.get(i))), barWidth, (int) height);
        }

        g.setColor(Color.BLACK);
        g.drawString(yName, 10, 20);

        updateUI();
        }
    }
}





