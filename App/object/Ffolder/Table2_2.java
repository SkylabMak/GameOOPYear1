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

    JPanel panel1 = new JPanel();

    public Table2_2(JFrame f) {

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
        (tile1.returnBTn()).setBounds((int) (centerX - size.getWidth() - 10), (int) (centerY - size.getHeight() - 10),
                size.width, size.height);
        (tile2.returnBTn()).setBounds((int) (centerX + 10), (int) (centerY - size.getHeight() - 10),
                size.width, size.height);
        (tile3.returnBTn()).setBounds((int) (centerX - size.getWidth() - 10), (int) (centerY + 10),
                size.width, size.height);
        (tile4.returnBTn()).setBounds((int) (centerX + 10), (int) (centerY + 10),
                size.width, size.height);

        panel1.add(tile1.returnBTn());
        panel1.add(tile2.returnBTn());
        panel1.add(tile3.returnBTn());
        panel1.add(tile4.returnBTn());
        panel1.setVisible(false);
        f.add(panel1);

    }

    public Tile[][] getTile2_2() {
        return tile2_2;
    };

    public String toString() {
        return String.format("this is Table2_2 class");
    }

    public Tile[][] returnTable() {
        return tile;
    }

    @Override
    public void setVisbleTure() {
        panel1.setVisible(true);
    }
}