package App;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

//object-----------
import App.object.*;
import App.object.FTable.*;
import App.object.FTile.Tile;

public class App {
    JFrame frame = new JFrame("My First GUI");
    Stat stat = new Stat(this);
    HashMap<Integer, TableMain> mapSize = new HashMap<>();

    public static void main(String args[]) {
    }

    public App() {

        // ----------------------------------------------------------------
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLocationRelativeTo(null);
        // frame.setBounds(0, 0, 1000, 1000);
        // frame.setLayout(null);
        frame.setSize(800, 800);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setResizable(false);
        JPanel mainPanel = new JPanel();
        JButton btnStart = new JButton("Start");// button start
        JButton test = new JButton("Test");// button start
        // frame.setLayout(new FlowLayout());
        mainPanel.setBackground(new Color(51, 153, 230));
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                start();

            }

        });
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                mapSize.put(2, new Table2_2(frame));
                mapSize.get(2).setVisbleTure();
                stat.addQueue(new int[] { 0, 1 });
                Tile tile = (mapSize.get(2).returnTable())[0][1];
                tile.setOrder(1);
                stat.addQueue(new int[] { 0, 0 });
                ((mapSize.get(2).returnTable())[0][0]).setOrder(2);
                setOrder(2);

                // mapSize.put(3, new Table3_3(frame));
                // Table3_3 table3 = new Table3_3(frame);
                // Table2_2 table2 = new Table2_2(frame);

            }

        });
        int margin = 200;
        mainPanel.setLayout(null);
        btnStart.setBounds((frame.getWidth()/2) - margin, (frame.getHeight()/2), 400, 100);
        test.setBounds((frame.getWidth()/2) - margin, (frame.getHeight()/2) + ((margin/2) + (margin/4)),400, 100);

        btnStart.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        test.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
       
        mainPanel.add(btnStart);
        mainPanel.add(test);
        frame.add(mainPanel);
        // frame.getContentPane().add(test);
        frame.setVisible(true);
    }

    public void start() {// satrt
        stat.reset();
        stat.setMapSize(frame);
        mapSize = stat.getMapSize(frame);
        play(2);
    }

    // public void broad() {// create borad

    // }

    public void preview(int size) {
        // int quantity = stat.getQuantity();
        // for (int iPreview = 0; iPreview < quantity; iPreview++) {
        // int[] xYPreview = stat.getQueues(iPreview);
        // Tile[][] map = mapSize.get(2).getTile();
        // map[xYPreview[0]][xYPreview[1]].ChangeColor();
        // map[xYPreview[0]][xYPreview[1]].setOrder(iPreview + 1);
        // System.out.println(xYPreview);

    }
    // int quantity = stat.getQuantity();
    // for (int iPreview = 0; iPreview < quantity; iPreview++) {
    // int[] xYPreview = stat.getQueues(iPreview);
    // Tile[][] map = mapSize.get(2).getTile();
    // map[xYPreview[0]][xYPreview[1]].ChangeColor();
    // map[xYPreview[0]][xYPreview[1]].setOrder(iPreview + 1);
    // System.out.println(xYPreview);
    // }

    public void listenerPress(int size) {

    }

    public void play(int size) {// play
        setOrder(size);
        // while (stat.getStatus()) {
        // int quantity = stat.getQuantity();
        // for (int iRandom = 0; iRandom < quantity; iRandom++) {
        // stat.addQueue(randomZY(size));
        // }
        // preview(size);
        // listenerPress(size);
        // }
    }

    public void setOrder(int size) {
        Tile[][] arrayTable = mapSize.get(size).returnTable();
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