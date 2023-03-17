package App.object;

import java.util.ArrayList;
import java.util.HashMap; // import the HashMap class

import javax.swing.JFrame;
import javax.swing.JPanel;

import App.App;

public class Stat {
    private static int level = 1;
    private static int heart = 3;
    private static int size = 2;
    private static int quantity = 1;
    public static boolean status = true;
    private static int currentOrder = 1;
    public static ArrayList<int[]> queue = new ArrayList<>();
    // public static HashMap<Integer, TableMain> mapSize = new HashMap<>();
    private static App app;

    public Stat() {

    }

    public Stat(App getApp) {
        app = getApp;
        System.out.println(app);
    }

    // public void setMapSize(JFrame frame) {
    // mapSize.put(Integer.valueOf(2), new Table2_2(frame));
    // mapSize.put(Integer.valueOf(3), new Table3_3(frame));
    // mapSize.put(Integer.valueOf(4), new Table4_4(frame));
    // System.out.println("setmapsize");
    // // mapSize.put(Integer.valueOf(4), new Table2_2(frame));
    // }

    // public HashMap<Integer, TableMain> getMapSize(JFrame frame) {
    // setMapSize(frame);
    // // new Table3_3(frame).tile[0][0] = new Tile(new JPanel());
    // return mapSize;
    // }

    public void UpOrder() {
        currentOrder++;
        // System.out.println("upOrder");
    }

    public void restartGame() {
        app.mainPage();
    }

    public void reset() {
        level = 1;
        heart = 3;
        size = 2;
        quantity = 1;
        currentOrder = 1;
        queue.removeAll(queue);
    }

    public void decreaseHeart() {
        heart--;
        if (heart == 0) {
            app.disableOldTable(size);
            new GameOver(app.getFrame());
        }
        System.out.println("heart = " + heart);
    }

    public void addQueue(int[] pointQueue) {
        queue.add(pointQueue);
    }

    public void setSize(int newSize) {
        size = newSize;
    }

    public void upLevel() {
        currentOrder = 1;
        quantity++;
        level++;
        System.out.println("--------------------level = " + level + "--------------------------\n");
        if (level < 3) {
            app.play(size);
            return;
        } else if (level == 3) {
            System.out.println("next table to 3");
            app.disableOldTable(size);
            size++;// 3
            quantity = 1;
            app.play(size);
            return;
        } else if (level == 5) {
            System.out.println("next table to 4");
            app.disableOldTable(size);
            size++;// 4
            quantity = 1;
            app.play(size);
            return;
        }
        app.play(size);
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
