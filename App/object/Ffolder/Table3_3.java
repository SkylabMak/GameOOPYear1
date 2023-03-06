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
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setSize((int) f.getPreferredSize().getWidth(), (int) f.getPreferredSize().getHeight());
        panel1.setBackground(new Color(51, 153, 255));
        int centerX = (int) panel1.getPreferredSize().getWidth();
        int centerY = (int) panel1.getPreferredSize().getHeight();
        Dimension size = (tile1.returnBTn()).getPreferredSize();
        (tile1.returnBTn()).setBounds((int) (centerX - size.getWidth() - 10), (int) (centerY - size.getHeight() - 10),
                size.width, size.height);

        panel1.add(tile1.returnBTn());
        panel1.setVisible(true);
        f.add(panel1);

    }

    public Tile[][] getTile3_3() {
        return tile3_3;
    };

    public String toString() {
        return String.format("this is Table3_3 class");
    }
}