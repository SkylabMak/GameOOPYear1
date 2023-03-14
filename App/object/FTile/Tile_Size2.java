package App.object.FTile;

import java.awt.Dimension;
import javax.swing.JPanel;

public class Tile_Size2 extends Tile {
    public Tile_Size2(JPanel jPanel) {
        super(jPanel);
        btnTile.setPreferredSize(new Dimension(150, 150));
    }
}