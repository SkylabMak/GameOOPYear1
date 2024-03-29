package App.object;

import java.util.ArrayList;

import App.App;

public class Stat {
    private static int level = 1;
    private static int heart = 3;
    private static int size = 2;
    private static int quantity = 1;
    public static boolean status = true;
    private static int currentOrder = 1;
    public static ArrayList<int[]> queue = new ArrayList<>();
    private static App app;

    public Stat() {

    }

    public Stat(App getApp) {
        app = getApp;
        System.out.println(app);
    }

    public App getApp() {
        return app;
    }

    public void UpOrder() {
        currentOrder++;
    }

    public void restartGame() {
        app.setPosition(app.getFrame().getX(), app.getFrame().getY());
        app.disableOldTable(size);
        app.mainPage();
    }

    public void sTartGameOvar() {
        new GameOver(app.getFrame());
        app.disableOldTable(size);
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
        app.getBanner().changHeart();
        if (heart == 0) {
            sTartGameOvar();
            app.getBanner().setVisible(false);
        }
        System.out.println("heart = " + heart);
    }

    public void addQueue(int[] pointQueue) {
        queue.add(pointQueue);
    }

    public void upLevel() {
        currentOrder = 1;
        quantity++;
        level++;
        System.out.println("--------------------level = " + level + "--------------------------\n");
        if (level < 3) {
            app.play(size);
            return;
        } else if (level == 5) {
            System.out.println("next table to 3");
            app.disableOldTable(size);
            size++;// 3
            quantity = 1;
            app.play(size);
            return;
        } else if (level == 10) {
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
