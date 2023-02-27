package App.object.Ffolder;

import java.awt.*;
import javax.swing.*;

import App.object.Tile;

public class Table2_2 extends TableMain {// extends JFrame

    public Tile[][] tile = new Tile[2][2];
    Tile tile1 = new Tile(new JPanel());
    Tile tile2 = new Tile(new JPanel());
    Tile tile3 = new Tile(new JPanel());
    Tile tile4 = new Tile(new JPanel());

    public Table2_2(JFrame f) {
        JPanel p1 = new JPanel();
    }

    public Table2_2() {

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

        // mainPanel.add(tile1);

    }

    public String toString() {
        return String.format("this is Table2_2 class");
    }
}