package App;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

//object-----------
import App.object.*;
import App.object.Ffolder.*;

public class App {
    JFrame frame = new JFrame("My First GUI");
    Stat stat = new Stat();
    HashMap<Integer, TableMain> mapSize = new HashMap<>();

    public static void main(String args[]) {

    }

    public App() {
        // ----------------------------------------------------------------
        stat.addQueue(new int[] { 0, 1 });
        stat.addQueue(new int[] { 0, 0 });
        stat.addQueue(new int[] { 0, 1 });
        stat.addQueue(new int[] { 1, 1 });
        
        // ------------------------------------------------------------
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
        mainPanel.setBackground(Color.ORANGE);
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
                // Table3_3 table3 = new Table3_3(frame);
                Table2_2 table2 = new Table2_2(frame);
                mainPanel.setVisible(false);
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
        stat.setMapSize(frame);
        // mapSize = stat.getMapSize(frame);
        play(2);
    }

    // public void broad() {// create borad

    // }

    public void previewAndSetOrder(int size) {
        // int quantity = stat.getQuantity();
        // for (int iPreview = 0; iPreview < quantity; iPreview++) {
        // int[] xYPreview = stat.getQueues(iPreview);
        // Tile[][] map = mapSize.get(2).getTile();
        // map[xYPreview[0]][xYPreview[1]].ChangeColor();
        // map[xYPreview[0]][xYPreview[1]].setOrder(iPreview + 1);
        // System.out.println(xYPreview);

        // }
    }

    public void listenerPress(int size) {

    }

    public void play(int size) {// play
        while (stat.getStatus()) {
            int quantity = stat.getQuantity();
            for (int iRandom = 0; iRandom < quantity; iRandom++) {
                stat.addQueue(randomZY(size));
            }
            previewAndSetOrder(size);
            listenerPress(size);

        }
    }

    public int[] randomZY(int size) {// random
        int[] xY = new int[2];
        for (int i = 0; i < size; i++) {
            xY[i] = (int) (Math.random() * (size));
        }
        return xY;
    }

}