package App.object.Ffolder;

import java.awt.*;
import javax.swing.*;

import App.object.Tile;

public class Table2_2 extends TableMain {// extends JFrame

    // public Tile[][] tile = new Tile[2][2];

    Tile tile1 = new Tile(new JPanel());
    Tile tile2 = new Tile(new JPanel());
    Tile tile3 = new Tile(new JPanel());
    Tile tile4 = new Tile(new JPanel());

    private Tile[][] tile2_2 = { { tile1, tile2 }, { tile3, tile4 } };

    public Table2_2(JFrame f) {
        JPanel panel1 = new JPanel();
        // panel1.setBounds(0, 0, 400, 400);
        // panel1.setSize(400, 400);
        panel1.setPreferredSize(new Dimension(600, 600));
        panel1.setBackground(new Color(145, 255, 153));
        panel1.add(tile1.returnBTn());
        panel1.setVisible(true);
        // f.add(new JButton("Test"));

        // JPanel mainPanel = new JPanel(); // main panel
        // mainPanel.setLayout(new GridLayout(3, 1));
        // mainPanel.setBackground(Color.white);
        // mainPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        // JPanel subPanel1 = new JPanel(); // sub-panel 1
        // subPanel1.setBackground(Color.CYAN);

        // mainPanel.add(subPanel1);
        f.add(panel1);
        // // f.getContentPane().add(mainPanel);

        // // mainPanel.add(tile1);
    }

    public Tile[][] getTile2_2() {
        return tile2_2;
    };

    public String toString() {
        return String.format("this is Table2_2 class");
    }
}