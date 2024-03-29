package App.object.FTable;

import java.awt.*;
import javax.swing.*;

import App.object.FTile.Tile;
import App.object.FTile.Tile_Size1;

public class Table3_3 extends TableMain {

        Tile_Size1 tile1 = new Tile_Size1(new JPanel());
        Tile_Size1 tile2 = new Tile_Size1(new JPanel());
        Tile_Size1 tile3 = new Tile_Size1(new JPanel());
        Tile_Size1 tile4 = new Tile_Size1(new JPanel());
        Tile_Size1 tile5 = new Tile_Size1(new JPanel());
        Tile_Size1 tile6 = new Tile_Size1(new JPanel());
        Tile_Size1 tile7 = new Tile_Size1(new JPanel());
        Tile_Size1 tile8 = new Tile_Size1(new JPanel());
        Tile_Size1 tile9 = new Tile_Size1(new JPanel());

        int margin1 = 110;
        int margin2 = 100;
        int putDown = 50;

        private Tile[][] tile3_3 = { { tile1, tile2, tile3 }, { tile4, tile5, tile6 }, { tile7, tile8, tile9 } };

        JPanel panel1 = new JPanel();

        public Table3_3(JFrame f) {
                panel1.setLayout(null);

                panel1.setBounds(0, 50, (int) f.getSize().getWidth(), (int) f.getSize().getHeight());
                panel1.setBackground(new Color(51, 153, 230));

                int centerX = (int) (panel1.getPreferredSize().getWidth()) / 2;// this is center in x axis
                int centerY = (int) (panel1.getPreferredSize().getHeight()) / 2;// this is center in y axis
                Dimension size = (tile1.returnBTn()).getPreferredSize();

                // location--------------------------
                (tile1.returnBTn()).setBounds((int) (centerX - size.getWidth() - margin1),
                                (int) (centerY - size.getHeight() - margin1 - putDown),
                                size.width, size.height);
                (tile2.returnBTn()).setBounds((int) (centerX - margin2),
                                (int) (centerY - size.getHeight() - margin1 - putDown),
                                size.width, size.height);
                (tile3.returnBTn()).setBounds((int) (centerX + margin1),
                                (int) (centerY - size.getHeight() - margin1 - putDown),
                                size.width, size.height);
                (tile4.returnBTn()).setBounds((int) (centerX - size.getWidth() - margin1),
                                (int) (centerY - margin2 - putDown),
                                size.width, size.height);
                (tile5.returnBTn()).setBounds((int) (centerX - margin2), (int) (centerY - margin2 - putDown),
                                size.width, size.height);
                (tile6.returnBTn()).setBounds((int) (centerX + margin1), (int) (centerY - margin2 - putDown),
                                size.width, size.height);
                (tile7.returnBTn()).setBounds((int) (centerX - size.getWidth() - margin1),
                                (int) (centerY + margin1 - putDown),
                                size.width, size.height);
                (tile8.returnBTn()).setBounds((int) (centerX - margin2), (int) (centerY + margin1 - putDown),
                                size.width, size.height);
                (tile9.returnBTn()).setBounds((int) (centerX + margin1), (int) (centerY + margin1 - putDown),
                                size.width, size.height);

                panel1.add(tile1.returnBTn());
                panel1.add(tile2.returnBTn());
                panel1.add(tile3.returnBTn());
                panel1.add(tile4.returnBTn());
                panel1.add(tile5.returnBTn());
                panel1.add(tile6.returnBTn());
                panel1.add(tile7.returnBTn());
                panel1.add(tile8.returnBTn());
                panel1.add(tile9.returnBTn());

                panel1.setVisible(false);
                f.add(panel1);
        }

        public String toString() {
                return String.format("this is Table3_3 class");
        }

        public Tile[][] returnTable() {
                return tile3_3;
        }

        @Override
        public void setVisbleTure() {
                panel1.setVisible(true);
        }

        public void setVisbleFlase() {
                panel1.setVisible(false);
        }

}