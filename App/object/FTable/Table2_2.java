package App.object.FTable;

import java.awt.*;

import javax.swing.*;

import App.object.FTile.Tile;
import App.object.FTile.Tile_Size1;

public class Table2_2 extends TableMain {// extends JFrame

    Tile_Size1 tile1 = new Tile_Size1(new JPanel());
    Tile_Size1 tile2 = new Tile_Size1(new JPanel());
    Tile_Size1 tile3 = new Tile_Size1(new JPanel());
    Tile_Size1 tile4 = new Tile_Size1(new JPanel());

    int margin = 10;
    int putDown = 50;

    private Tile[][] tile2_2 = { { tile1, tile2 }, { tile3, tile4 } };

    JPanel panel1 = new JPanel();

    public Table2_2(JFrame f) {
        panel1.setLayout(null);

        // System.out.println("fram Size : " + f.getSize().getWidth() + " " +
        // f.getPreferredSize().getHeight());
        panel1.setBounds(0, 50, (int) f.getSize().getWidth(), (int) f.getSize().getHeight());
        panel1.setBackground(new Color(51, 153, 230));

        int centerX = (int) (panel1.getPreferredSize().getWidth()) / 2;// this is center in x axis
        int centerY = (int) (panel1.getPreferredSize().getHeight()) / 2;// this is center in y axis
        Dimension size = (tile1.returnBTn()).getPreferredSize();
        // System.out.println(size.height + " " + size.width);

        // location--------------------------
        (tile1.returnBTn()).setBounds((int) (centerX - size.getWidth() - margin),
                (int) (centerY - size.getHeight() - margin - putDown),
                size.width, size.height);
        (tile2.returnBTn()).setBounds((int) (centerX + margin), (int) (centerY - size.getHeight() - margin - putDown),
                size.width, size.height);
        (tile3.returnBTn()).setBounds((int) (centerX - size.getWidth() - margin), (int) (centerY + margin - putDown),
                size.width, size.height);
        (tile4.returnBTn()).setBounds((int) (centerX + margin), (int) (centerY + margin - putDown),
                size.width, size.height);

        panel1.add(tile1.returnBTn());
        panel1.add(tile2.returnBTn());
        panel1.add(tile3.returnBTn());
        panel1.add(tile4.returnBTn());
        panel1.setVisible(false);
        f.add(panel1);

    }

    public String toString() {
        return String.format("this is Table2_2 class");
    }

    public Tile[][] returnTable() {
        return tile2_2;
    }

    @Override
    public void setVisbleTure() {
        panel1.setVisible(true);
    }

    @Override
    public void setVisbleFlase() {
        panel1.setVisible(false);
    }

}