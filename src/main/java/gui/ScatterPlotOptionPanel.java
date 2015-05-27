package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by schoch on 25.05.15.
 */
public class ScatterPlotOptionPanel extends JPanel{

    public ScatterPlotOptionPanel(ScatterPlotPanel scatterPlotPanel){

        setBackground(Color.PINK);

        final JCheckBox lineButton = new JCheckBox("DrawLines");
        add(lineButton, BorderLayout.CENTER);
        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lineButton.isSelected()){scatterPlotPanel.drawLine(true);}
                else{scatterPlotPanel.drawLine(false);}
            }
        });

        JSlider pointSize = new JSlider (1, 31, 5);
        pointSize.setMajorTickSpacing(10);
        pointSize.setMinorTickSpacing(1);
        pointSize.setPaintTicks(true);
        pointSize.setPaintLabels(true);

        add(pointSize);

        pointSize.addChangeListener(e -> {
            if (!pointSize.getValueIsAdjusting()) {
                scatterPlotPanel.adjustRadius(pointSize.getValue());
            }
        });

    }

}
