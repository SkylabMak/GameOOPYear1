import java.util.HashMap;

import javax.swing.JFrame;

import App.object.Stat;
import App.object.Tile;
import App.object.Ffolder.TableMain;

public class TestMethod {
    static Stat stat = new Stat();

    public static void main(String[] args) {
        // Tile tile = (stat.mapSize.get(2)).tile[1][0];
        HashMap<Integer, TableMain> mapSize = stat.getMapSize(new JFrame("My First GUI"));
        Tile[][] weGet = mapSize.get(3).getTile();
        System.out.println(weGet[0][0]);
        // System.out.println(tile);
    }
}
