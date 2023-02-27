package App.object;

import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class

import javax.swing.JFrame;
import javax.swing.JPanel;

import App.object.Ffolder.Table2_2;
import App.object.Ffolder.Table3_3;
import App.object.Ffolder.TableMain;

public class Stat {
    private int level = 0;
    private int heart = 3;
    private int size = 2;
    private int quantity = 1;
    public boolean status = true;
    public ArrayList<int[]> queue = new ArrayList<>();
    public HashMap<Integer, TableMain> mapSize = new HashMap<>();

    public void setMapSize(JFrame frame) {
        mapSize.put(Integer.valueOf(2), new Table2_2(frame));
        mapSize.put(Integer.valueOf(3), new Table3_3(frame));
        mapSize.put(Integer.valueOf(4), new Table2_2(frame));
    }

    public HashMap<Integer, TableMain> getMapSize(JFrame frame) {
        setMapSize(frame);
        new Table3_3(frame).tile[0][0] = new Tile(new JPanel());
        return mapSize;
    }

    public void reset() {
        level = 0;
        heart = 3;
        size = 2;
        quantity = 1;
    }

    public void setHeart(int heart) {
        this.heart += heart;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void upLevel() {
        this.quantity++;
        this.level++;
        if (this.level == 6) {
            this.size++;// 3
            this.quantity = 1;// reset
        } else if (this.level == 11) {
            this.size++;// 4
            this.quantity = 1;// reset
        }
    }

    public int getHeart() {
        return heart;
    }

    public int getLevel() {
        return level;
    }

    public int getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }
}
