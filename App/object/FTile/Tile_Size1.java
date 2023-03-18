package App.object.FTile;

import java.awt.Dimension;
import javax.swing.JPanel;

public class Tile_Size1 extends Tile {
    public Tile_Size1(JPanel jPanel) {
        super(jPanel);
        btnTile.setPreferredSize(new Dimension(200, 200));
    }
}