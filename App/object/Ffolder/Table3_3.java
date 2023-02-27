package App.object.Ffolder;

import java.awt.*;
import javax.swing.*;

import App.object.Tile;

public class Table3_3 extends TableMain {

    public Tile[][] tile = new Tile[3][3];

    public Table3_3(JFrame f) {
        JPanel p1 = new JPanel();
        tile[0][0] = new Tile(new JPanel());
    }

    public JPanel Table2x2() {

        JPanel mainPanel = new JPanel(); // main panel
        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        JPanel subPanel1 = new JPanel(); // sub-panel 1
        subPanel1.setBackground(Color.red);

        JPanel subPanel2 = new JPanel(); // sub-panel 2
        subPanel2.setBackground(Color.blue);

        mainPanel.add(subPanel1);
        mainPanel.add(subPanel2);

        return mainPanel;

    }

    public Tile[][] getTile() {
        return tile;
    };

    public String toString() {
        return String.format("this is Table3_3 class");
    }
}