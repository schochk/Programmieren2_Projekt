package gui;

import ch.n1b.mirij2.model.Serie;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by schoch on 02.06.15.
 */
public class HistogramModel extends JPanel {

    Serie serieTest;
    List<Double> valuesOfList;
    double minValue;
    double binSize;
    double numOfBars;

    HistogramModel(Serie serie) {
        this.serieTest = serie;
    }

    public void setVariableNumber(int number) {
        valuesOfList = serieTest.get(number);           //habe ich die richtige funktion?
        double maxValue = serieTest.max(number);        //min und max aus Serie implementieren?
        minValue = serieTest.min(number);
        double deltaValue = maxValue - minValue;
        binSize = deltaValue / numOfBars;
    }

    public double getNumberOfBars() {
        numOfBars = Math.sqrt(valuesOfList.size());
        return numOfBars;
    }

    public List<Integer> getBars() {
        int listLength = valuesOfList.size();
        List<Integer> bars = new ArrayList<>();
        for (int i = 0; i < numOfBars; i++) {
            bars.add(0);
        }
        for (int j = 0; j < numOfBars; j++)
            for (int i = 0; i < listLength; i++) {
                if (minValue + (binSize * j) <= valuesOfList.get(i) && valuesOfList.get(i) < minValue + (binSize * (j + 1))) {
                    bars.set(j, (bars.get(j) + 1));
                }
            }
    return bars;
}
}





