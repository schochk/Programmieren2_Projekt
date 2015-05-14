package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by schoch on 14.05.15.
 */
public class ScatterPlot extends JPanel {

    public void scatterPlotComponent() {

        JPanel scatterPlot = new JPanel();
        scatterPlot.setBackground(Color.BLUE);

        JLabel test = new JLabel("Test");
        scatterPlot.add(test);

        add(scatterPlot);

    }

}
