package App.object;

import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class

import javax.swing.JFrame;
import javax.swing.JPanel;

import App.App;
import App.object.FTable.Table2_2;
import App.object.FTable.Table3_3;
import App.object.FTable.TableMain;

public class Stat {
    private static int level = 1;
    private static int heart = 3;
    private static int size = 2;
    private static int quantity = 1;
    public static boolean status = true;
    private static int currentOrder = 1;
    public static ArrayList<int[]> queue = new ArrayList<>();
    public static HashMap<Integer, TableMain> mapSize = new HashMap<>();
    private static App app;

    public Stat() {

    }

    public Stat(App getApp) {
        app = getApp;
        System.out.println(app);
    }

    public void setMapSize(JFrame frame) {
        mapSize.put(Integer.valueOf(2), new Table2_2(frame));
        mapSize.put(Integer.valueOf(3), new Table3_3(frame));
        // mapSize.put(Integer.valueOf(4), new Table2_2(frame));
    }

    public HashMap<Integer, TableMain> getMapSize(JFrame frame) {
        setMapSize(frame);
        // new Table3_3(frame).tile[0][0] = new Tile(new JPanel());
        return mapSize;
    }

    public void UpOrder() {
        currentOrder++;
        System.out.println("upOrder");
    }

    public void reset() {
        level = 0;
        heart = 3;
        size = 2;
        quantity = 1;
        currentOrder = 1;
    }

    public void decreaseHeart() {
        heart--;
    }

    public void addQueue(int[] pointQueue) {
        queue.add(pointQueue);
    }

    public void setSize(int newSize) {
        size = newSize;
    }

    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    public void upLevel() {
        currentOrder = 1;
        System.out.println("uplevel");
        quantity++;
        level++;
        if (level < 6) {
            app.play(size);
        } else if (level == 6) {
            size++;// 3
            quantity = 1;// reset
            app.play(size);
        } else if (level == 11) {
            size++;// 4
            quantity = 1;// reset
            app.play(size);
        }
    }

    public int getCurrentOrder() {
        return currentOrder;
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

    public boolean getStatus() {
        return status;
    }

    public int[] getQueues(int i) {
        return queue.get(i);
    }
}
