package App.object.FTile;

import java.awt.Dimension;
import javax.swing.JPanel;

public class Tile_Size1 extends Tile{
    public Tile_Size1(JPanel jPanel) {
        super(jPanel);
        btnTile.addMouseListener(new mouseEvent());
        // btnTile.addActionListener(new AllButtonListener());
        btnTile.setBackground(baseColor);
        btnTile.setModel(new FixedStateButtonModel());
        btnTile.setPreferredSize(new Dimension(200, 200));
    }
}