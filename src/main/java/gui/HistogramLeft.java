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
public class HistogramLeft extends JPanel {

    Serie xList;
    String xName;
    double numberOfBars, binSize;
    List<Integer> bars = new ArrayList<>();

    public void histogramL(Serie serieX, String nameX) {
        this.xList = serieX;
        this.xName = nameX;
        this.repaint();
    }

    public void paintComponent (Graphics g) {

       if (xList != null) {

            double maxVariableX = xList.range().getY();
            double minVariableX = xList.range().getX();

            numberOfBars = Math.sqrt(xList.size());
            binSize = (maxVariableX - minVariableX) / numberOfBars;

            int listLength = xList.size();

            for (int i = 0; i < numberOfBars; i++) {
                bars.add(0);
            }


            for (int j = 0; j < numberOfBars; j++) {
                for (int i = 0; i < listLength; i++) {
                    if (minVariableX + (binSize * j) <= xList.get(i) && xList.get(i) < minVariableX + (binSize * (j + 1))) {
                        bars.set(j, (bars.get(j) + 1));
                    }
                }
            }

                double maxBin = Collections.max(bars);
                int barWidth = (int) (getWidth() / numberOfBars);
                double height = getHeight();

                g.setColor(Color.BLUE);
                for (int i = 0; i < bars.size(); i++) {
                    g.fillRect((barWidth * i), (int) (height - (height / maxBin * bars.get(i))), barWidth, (int) height);
                }

                g.setColor(Color.ORANGE);
                for (int i = 0; i < bars.size(); i++) {
                    g.drawRect((barWidth * i), (int) (height - (height / maxBin * bars.get(i))), barWidth, (int) height);
                }

                g.setColor(Color.BLACK);
                g.drawString(xName, 10, 20);

                updateUI();
            }

    }
}


