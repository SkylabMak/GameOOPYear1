package App.object.FTable;

import java.awt.*;
import javax.swing.*;

import App.object.FTile.Tile;
import App.object.FTile.Tile_Size2;

public class Table4_4 extends TableMain {
        // public Tile[][] tile = new Tile[4][4];

        Tile_Size2 tile1 = new Tile_Size2(new JPanel());
        Tile_Size2 tile2 = new Tile_Size2(new JPanel());
        Tile_Size2 tile3 = new Tile_Size2(new JPanel());
        Tile_Size2 tile4 = new Tile_Size2(new JPanel());
        Tile_Size2 tile5 = new Tile_Size2(new JPanel());
        Tile_Size2 tile6 = new Tile_Size2(new JPanel());
        Tile_Size2 tile7 = new Tile_Size2(new JPanel());
        Tile_Size2 tile8 = new Tile_Size2(new JPanel());
        Tile_Size2 tile9 = new Tile_Size2(new JPanel());
        Tile_Size2 tile10 = new Tile_Size2(new JPanel());
        Tile_Size2 tile11 = new Tile_Size2(new JPanel());
        Tile_Size2 tile12 = new Tile_Size2(new JPanel());
        Tile_Size2 tile13 = new Tile_Size2(new JPanel());
        Tile_Size2 tile14 = new Tile_Size2(new JPanel());
        Tile_Size2 tile15 = new Tile_Size2(new JPanel());
        Tile_Size2 tile16 = new Tile_Size2(new JPanel());

        int margin = 10;
        int margin1 = 5;

        private Tile[][] tile4_4 = { { tile1, tile2, tile3, tile4 }, { tile5, tile6, tile7, tile8 },
                        { tile9, tile10, tile11, tile12 },
                        { tile13, tile14, tile15, tile16 } };

        JPanel panel1 = new JPanel();

        public Table4_4(JFrame f) {
                JPanel panel1 = new JPanel();
                panel1.setLayout(null);

                // panel1.setBounds(0, 0, 400, 400);
                panel1.setSize((int) f.getSize().getWidth(), (int) f.getSize().getHeight());
                System.out.println(f.getSize().getWidth() + " " + f.getPreferredSize().getHeight());
                // panel1.setBounds(0, 0, 800, 800);
                // panel1.setPreferredSize(new Dimension(600, 600));
                panel1.setBackground(new Color(51, 153, 230));

                System.out.println(tile1);

                int centerX = (int) (panel1.getPreferredSize().getWidth()) / 2;// this is center in x axis
                int centerY = (int) (panel1.getPreferredSize().getHeight()) / 2;// this is center in y axis
                Dimension size = (tile1.returnBTn()).getPreferredSize();
                System.out.println(size.height + " " + size.width);
                (tile1.returnBTn()).setBounds((int) (centerX - (2 * size.getWidth()) - (2 * margin + margin1)),
                                (int) (centerY - (2 * size.getHeight()) - (2 * margin + margin1)),
                                size.width, size.height);
                (tile2.returnBTn()).setBounds((int) (centerX - size.getWidth() - margin),
                                (int) (centerY - (2 * size.getHeight()) - (2 * margin + margin1)),
                                size.width, size.height);
                (tile3.returnBTn()).setBounds((int) (centerX + margin1),
                                (int) (centerY - (2 * size.getHeight()) - (2 * margin + margin1)),
                                size.width, size.height);
                (tile4.returnBTn()).setBounds((int) (centerX + size.getWidth() + (2 * margin)),
                                (int) (centerY - (2 * size.getHeight()) - (2 * margin + margin1)),
                                size.width, size.height);
                (tile5.returnBTn()).setBounds((int) (centerX - (2 * size.getWidth()) - (2 * margin + margin1)),
                                (int) (centerX - size.getWidth() - margin),
                                size.width, size.height);
                (tile6.returnBTn()).setBounds((int) (centerX - size.getWidth() - margin),
                                (int) (centerX - size.getWidth() - margin),
                                size.width, size.height);
                (tile7.returnBTn()).setBounds((int) (centerX + margin1), (int) (centerX - size.getWidth() - margin),
                                size.width, size.height);
                (tile8.returnBTn()).setBounds((int) (centerX + size.getWidth() + (2 * margin)),
                                (int) (centerX - size.getWidth() - margin),
                                size.width, size.height);
                (tile9.returnBTn()).setBounds((int) (centerX - (2 * size.getWidth()) - (2 * margin + margin1)),
                                (int) (centerY + margin1),
                                size.width, size.height);
                (tile10.returnBTn()).setBounds((int) (centerX - size.getWidth() - margin), (int) (centerY + margin1),
                                size.width, size.height);
                (tile11.returnBTn()).setBounds((int) (centerX + margin1), (int) (centerY + margin1),
                                size.width, size.height);
                (tile12.returnBTn()).setBounds((int) (centerX + size.getWidth() + (2 * margin)),
                                (int) (centerY + margin1),
                                size.width, size.height);
                (tile13.returnBTn()).setBounds((int) (centerX - (2 * size.getWidth()) - (2 * margin + margin1)),
                                (int) (centerY + size.getWidth() + (2 * margin)),
                                size.width, size.height);
                (tile14.returnBTn()).setBounds((int) (centerX - size.getWidth() - margin),
                                (int) (centerY + size.getWidth() + (2 * margin)),
                                size.width, size.height);
                (tile15.returnBTn()).setBounds((int) (centerX + margin1),
                                (int) (centerY + size.getWidth() + (2 * margin)),
                                size.width, size.height);
                (tile16.returnBTn()).setBounds((int) (centerX + size.getWidth() + (2 * margin)),
                                (int) (centerY + size.getWidth() + (2 * margin)),
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
                panel1.add(tile10.returnBTn());
                panel1.add(tile11.returnBTn());
                panel1.add(tile12.returnBTn());
                panel1.add(tile13.returnBTn());
                panel1.add(tile14.returnBTn());
                panel1.add(tile15.returnBTn());
                panel1.add(tile16.returnBTn());

                panel1.setVisible(true);
                f.add(panel1);
        }

        public Tile[][] getTile4_4() {
                return tile4_4;
        };

        public String toString() {
                return String.format("this is Table4_4 class");
        }

    public Tile[][] returnTable() {
        return tile;
    }

        @Override
        public void setVisbleTure() {
                panel1.setVisible(false);
        }
}