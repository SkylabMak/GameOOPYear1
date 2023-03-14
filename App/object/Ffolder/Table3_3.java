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

        // panel1.setBounds(0, 0, 400, 400);
        panel1.setSize((int) f.getSize().getWidth(), (int) f.getSize().getHeight());
        System.out.println(f.getSize().getWidth() + " " + f.getPreferredSize().getHeight());
        // panel1.setBounds(0, 0, 800, 800);
        // panel1.setPreferredSize(new Dimension(600, 600));
        panel1.setBackground(new Color(51, 153, 255));

        System.out.println(tile1);

        int centerX = (int) (panel1.getPreferredSize().getWidth()) / 2;// this is center in x axis
        int centerY = (int) (panel1.getPreferredSize().getHeight()) / 2;// this is center in y axis
        Dimension size = (tile1.returnBTn()).getPreferredSize();
        System.out.println(size.height + " " + size.width);
        (tile1.returnBTn()).setBounds((int) (centerX - size.getWidth() - 15), (int) (centerY - size.getHeight() - 15),
                size.width, size.height);
        (tile2.returnBTn()).setBounds((int) (centerX - 5), (int) (centerY - size.getHeight() - 15),
                size.width, size.height);
        (tile3.returnBTn()).setBounds((int) (centerX + size.getWidth() + 5), (int) (centerY - size.getHeight() - 15),
                size.width, size.height);
        (tile4.returnBTn()).setBounds((int) (centerX - size.getWidth() - 15), (int) (centerY - 5),
                size.width, size.height);

        panel1.add(tile1.returnBTn());
        panel1.add(tile2.returnBTn());
        panel1.add(tile3.returnBTn());
        panel1.add(tile4.returnBTn());
        
        panel1.setVisible(true);
        f.add(panel1);
    }

    public Tile[][] getTile3_3() {
        return tile3_3;
    };

    public String toString() {
        return String.format("this is Table3_3 class");
    }

    public Tile[][] returnTable() {
        return tile;
    }
}