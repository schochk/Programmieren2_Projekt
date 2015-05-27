package gui;

import ch.n1b.mirij2.loader.ColumnFile;
import ch.n1b.mirij2.loader.RowFile;
import ch.n1b.mirij2.loader.SeriesFileLoader;
import ch.n1b.mirij2.model.SeriesFile;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

/**
 * Created by schoch on 13.05.15.
 */
public class MenuPanel extends JPanel {

    private JComboBox variableXSelect;
    private JComboBox variableYSelect;

    public void menuComponent() {
        // Open File dialog
        JButton btnSelect = new JButton("Oeffnen");
        btnSelect.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Series Files", "lin", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(MenuPanel.this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                SeriesFileLoader loader;
                if(file.getName().endsWith(".lin")){
                    loader = new RowFile();
                }else{
                    loader = new ColumnFile();
                }
                SeriesFile seriesFile = null;
                try {
                    // Load file and add variable choosers
                    seriesFile = loader.load(file);
                    JLabel variableX = new JLabel("Variabel X:");
                    add(variableX);
                    String variableList[] = seriesFile.getNames().toArray(new String[0]);
                    variableXSelect = new JComboBox(variableList);
                    add(variableXSelect);

                    JLabel variableY = new JLabel("Variabel Y:");
                    add(variableY);
                    variableYSelect = new JComboBox(variableList);
                    add(variableYSelect);
                } catch (IOException e1) {
                    // Cannot load file! Panic!
                    e1.printStackTrace();
                }
            }
        });
        add(btnSelect);
    }

    public String getSelectedVariableX() {
        return variableXSelect==null ? null : (String) variableXSelect.getSelectedItem();
    }

    public String getSelectedVariableY() {
        return variableYSelect==null ? null : (String) variableYSelect.getSelectedItem();
    }
}

