package App.object.Ffolder;

import java.awt.*;
import javax.swing.*;

import App.object.Tile;

public class Table3_3 extends TableMain {

    // public Tile[][] tile = new Tile[3][3];

    Tile tile1 = new Tile(new JPanel());
    Tile tile2 = new Tile(new JPanel());
    Tile tile3 = new Tile(new JPanel());
    Tile tile4 = new Tile(new JPanel());
    Tile tile5 = new Tile(new JPanel());
    Tile tile6 = new Tile(new JPanel());
    Tile tile7 = new Tile(new JPanel());
    Tile tile8 = new Tile(new JPanel());
    Tile tile9 = new Tile(new JPanel());

    private Tile[][] tile3_3 = { { tile1, tile2, tile3 }, { tile4, tile5, tile6 }, { tile7, tile8, tile9 } };

    public Table3_3(JFrame f) {
        JPanel mainPanel = new JPanel(); // main panel
        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        JPanel subPanel1 = new JPanel(); // sub-panel 1
        subPanel1.setBackground(Color.white);

        JPanel subPanel2 = new JPanel(); // sub-panel 2
        subPanel2.setBackground(Color.white);

        mainPanel.add(subPanel1);
        mainPanel.add(subPanel2);
    }

    public Tile[][] getTile3_3() {
        return tile3_3;
    };

    public String toString() {
        return String.format("this is Table3_3 class");
    }
}