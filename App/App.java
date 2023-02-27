package App;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//object-----------
import App.object.*;
import App.object.Ffolder.Table2_2;

public class App {
    JFrame frame = new JFrame("My First GUI");
    Stat stat = new Stat();

    public static void main(String args[]) {

    }

    public App() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        JButton btnStart = new JButton("Start");// button start
        frame.setLayout(new FlowLayout());
        btnStart.setPreferredSize(new Dimension(200, 100));
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStart.setVisible(false);
                start();

            }

        });
        frame.getContentPane().add(btnStart);
        frame.setVisible(true);
    }

    public void start() {// satrt
        stat.reset();
        stat.setMapSize(frame);
        Table2_2 table2_2 = new Table2_2(frame);
        play(2);
    }

    // public void broad() {// create borad

    // }

    public void play(int size) {// play
        while (stat.status) {
            int quantity = stat.getQuantity();
            for (int iRandom = 0; iRandom < quantity; iRandom++) {
                stat.queue.add(randomZY(size));
            }
            for (int iPreview = 0; iPreview < quantity; iPreview++) {
                int[] xYPreview = stat.queue.get(iPreview);
                Tile tile = (stat.mapSize.get(size)).tile[xYPreview[0]][xYPreview[1]];// .tile[xYPreview[0]][xYPreview[1]]
            }
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