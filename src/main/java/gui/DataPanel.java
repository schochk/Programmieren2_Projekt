package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by schoch on 25.05.15.
 */
public class DataPanel extends JPanel {

    public void dataComponent(){

        //setBackground(Color.BLUE);

        JLabel data = new JLabel("Datei: ");
        add(data, BorderLayout.WEST);
    }
}
