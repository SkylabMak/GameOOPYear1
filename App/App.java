package App;

import java.awt.Dimension;
import javax.swing.*;
import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JPanel {
    JFrame frame = new JFrame("My First GUI");

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

    }

    // public void broad() {// create borad

    // }

    public void play(int size) {// play

    }

    public int[] randomZY(int size) {// random
        int[] xY = new int[2];
        for (int i = 0; i < size; i++) {
            xY[i] = (int) (Math.random() * (size));
        }
        return xY;
    }

}