package App;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

//object-----------
import App.object.*;
import App.object.FTable.*;
import App.object.FTile.Tile;

public class App {
    public static int iCountdown = 0;
    JFrame frame = new JFrame("My First GUI");
    Stat stat = new Stat(this);
    HashMap<Integer, TableMain> mapSizeApp = new HashMap<>();

    public static void main(String args[]) {
    }

    public App() {

        // ----------------------------------------------------------------
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLocationRelativeTo(null);
        // frame.setBounds(0, 0, 1000, 1000);
        // frame.setLayout(null);
        frame.setSize(800, 800);
        JPanel mainPanel = new JPanel();
        JButton btnStart = new JButton("Start");// button start
        JButton test = new JButton("Test");// button start
        // frame.setLayout(new FlowLayout());
        btnStart.setPreferredSize(new Dimension(200, 100));
        mainPanel.setBackground(new Color(255, 204, 0));
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                start();

            }

        });
        test.setPreferredSize(new Dimension(200, 100));
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                mapSizeApp.put(2, new Table2_2(frame));
                mapSizeApp.get(2).setVisbleTure();
                stat.addQueue(new int[] { 0, 1 });
                Tile tile = (mapSizeApp.get(2).returnTable())[0][1];
                tile.setOrder(1);
                stat.addQueue(new int[] { 0, 0 });
                ((mapSizeApp.get(2).returnTable())[0][0]).setOrder(2);
                setOrder(2);
                preview(2, mapSizeApp.get(2));

                // mapSize.put(3, new Table3_3(frame));
                // Table3_3 table3 = new Table3_3(frame);
                // Table2_2 table2 = new Table2_2(frame);

            }

        });
        mainPanel.add(btnStart);
        mainPanel.add(test);
        frame.add(mainPanel);
        // frame.getContentPane().add(test);
        frame.setVisible(true);
    }

    public void start() {// satrt
        stat.reset();
        mapSizeApp.put(Integer.valueOf(2), new Table2_2(frame));
        mapSizeApp.put(Integer.valueOf(3), new Table3_3(frame));
        mapSizeApp.put(Integer.valueOf(4), new Table4_4(frame));
        play(2);
    }

    public void disableOldTable(int size) {
        mapSizeApp.get(size).setVisbleFlase();
    }

    public void play(int size) {// play
        mapSizeApp.get(size).setVisbleTure();
        setOrder(size);
    }

    // public void broad() {// create borad

    // }

    public void preview(int size, TableMain table) {
        int delay = 700;
        stat.getQueues(iCountdown);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                // int i = Integer.parseInt(args[0]);
                Tile[][] tile = table.returnTable();
                int[] position = stat.getQueues(iCountdown);
                System.out.println("loop time run" + iCountdown);
                tile[position[0]][position[1]].changecolorAndBack(Color.MAGENTA);
                iCountdown++;
                if (iCountdown == Stat.queue.size())
                    timer.cancel();
                // System.out.println(iCountdown);

            }
        }, 1, delay);

    }

    public void listenerPress(int size) {

    }

    public void setOrder(int size) {
        Tile[][] arrayTable = mapSizeApp.get(size).returnTable();
        int quantity = stat.getQuantity();
        ArrayList<int[]> queue = Stat.queue;
        if (queue.size() > quantity) {
            System.out.println("if");
            for (int iQueue = 0; iQueue < queue.size(); iQueue++) {
                int[] queueItem = queue.get(iQueue);
                Tile tile = arrayTable[queueItem[0]][queueItem[1]];
                tile.colorBase();
                tile.removeOrder();
            }
            queue.removeAll(queue);
            // ----------------------------------
            stat.addQueue(randomZY(size));
            int[] queueItem = queue.get(0);
            Tile tile = arrayTable[queueItem[0]][queueItem[1]];
            tile.setOrder(queue.size());

        } else {
            System.out.println("else");
            // old-------------------------------------
            for (int iRandom = 1; iRandom < quantity; iRandom++) {
                // stat.addQueue(randomZY(size));
                int[] queueItem = queue.get(iRandom - 1);
                Tile tile = arrayTable[queueItem[0]][queueItem[1]];
                tile.setOrder(iRandom);
            }
            // old-------------------------------------
            stat.addQueue(randomZY(size));
            int[] queueItem = queue.get(queue.size() - 1);
            Tile tile = arrayTable[queueItem[0]][queueItem[1]];
            tile.setOrder(queue.size());
        }
        for (int testI = 0; testI < queue.size(); testI++) {
            int[] queueItem = queue.get(testI);
            Tile tile = arrayTable[queueItem[0]][queueItem[1]];
            System.out.println("position I = " + testI + " " + Arrays.toString(queue.get(testI)));

            System.out.println("order" + tile.getOrder());
        }
        preview(size, mapSizeApp.get(size));
        //
        // Table2_2 table2_2 = new Table2_2(frame);

    }

    public int[] randomZY(int size) {// random
        int[] xY = new int[2];
        for (int i = 0; i < size; i++) {
            xY[i] = (int) (Math.random() * (size));
        }
        return xY;
    }

    public void Showpreview() {

    }

    @Override
    public String toString() {
        return "this is app";
    }

}