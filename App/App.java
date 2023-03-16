package App;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.security.PublicKey;
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
    // https://www.roseindia.net/java/example/java/swing/jlayered-overlap-panel.shtml
    JLayeredPane layeredPane;
    public static int iCountdown = 0;
    JFrame frame = new JFrame("My First GUI");
    Stat stat = new Stat(this);
    HashMap<Integer, TableMain> mapSizeApp = new HashMap<>();
    JPanel mainPanel = new JPanel();
    JLabel windows = new JLabel("WINDOWS");// name

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
        frame.setResizable(false);// disable full windows
        JButton btnStart = new JButton("Start");// button start
        JButton test = new JButton("Test");// button start
        mainPanel.setBackground(new Color(51, 153, 230));
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                start(windows);

            }

        });
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeName(windows);

                // JButton backButton = new JButton("Back");
                // backButton.setBounds((frame.getWidth()/2) - 100, (frame.getHeight()/2), 400,
                // 100);
                // backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
                // mainPanel.add(backButton);
                // frame.add(mainPanel);
                // backButton.addActionListener(new ActionListener() {
                // public void actionPerformed(ActionEvent e) {
                // returnMainPanel();
                // }
                // private void returnMainPanel() {
                // mainPanel.setVisible(true);
                // }
                // } );

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
            }

        });
        test.setEnabled(false);
        int margin = 200;
        mainPanel.setLayout(null);
        Container c = frame.getContentPane();

        btnStart.setBounds((frame.getWidth() / 2) - margin, (frame.getHeight() / 2), 400, 100);
        test.setBounds((frame.getWidth() / 2) - margin, (frame.getHeight() / 2) + ((margin / 2) + (margin / 5)), 400,
                100);
        windows.setBounds((frame.getWidth() / 2) - (185), 100, 400, 500);

        btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        test.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        windows.setFont(new Font("Comic Sans MS", Font.BOLD, 64));
        windows.setForeground(Color.WHITE);

        mainPanel.add(btnStart);
        mainPanel.add(test);
        c.add(windows);
        frame.add(mainPanel);

        // frame.getContentPane().add(test);
        frame.setVisible(true);
    }

    public JLabel removeName(JLabel windows) {
        windows.setText("");
        return windows;
    }

    public void start(JLabel windows) {// start
        removeName(windows);

        mapSizeApp.put(Integer.valueOf(2), new Table2_2(frame));
        mapSizeApp.put(Integer.valueOf(3), new Table3_3(frame));
        mapSizeApp.put(Integer.valueOf(4), new Table4_4(frame));
        play(2);
    }
    public void restart () {
        mainPanel.setVisible(true);
        start(windows);
    }

    public void disableOldTable(int size) {
        mapSizeApp.get(size).setVisbleFlase();
    }

    public void play(int size) {// play
        mapSizeApp.get(size).setVisbleTure();
        setOrder(size);
    }

    public void setAbleBtn(TableMain table, boolean tf) {
        // System.out.println("setAble run");
        Tile[][] tile = table.returnTable();
        for (var row : tile) {
            for (var col : row) {
                col.setAbleBtn(tf);
            }
        }
    }

    public void preview(int size, TableMain table) {
        setAbleBtn(table, false);
        int delay = 700;
        stat.getQueues(iCountdown);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                // int i = Integer.parseInt(args[0]);
                Tile[][] tile = table.returnTable();
                int[] position = stat.getQueues(iCountdown);
                // System.out.println("loop time run" + iCountdown);
                tile[position[0]][position[1]].changecolorAndBack(Color.MAGENTA);
                iCountdown++;
                if (iCountdown == Stat.queue.size()) {
                    iCountdown = 0;
                    setAbleBtn(table, true);
                    timer.cancel();
                }
                // System.out.println(iCountdown);

            }
        }, 1000, delay);

    }

    public void listenerPress(int size) {

    }

    public void setOrder(int size) {
        System.out.println("array.size = " + Stat.queue.size() + " quantity = " + stat.getQuantity());
        Tile[][] arrayTable = mapSizeApp.get(size).returnTable();
        int quantity = stat.getQuantity();
        ArrayList<int[]> queue = Stat.queue;
        // new table--------------------------------
        if (queue.size() > quantity) {
            System.out.println("new table");
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

        } else {// curren table--------------------------------
            System.out.println("curren table");
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
        System.out.println("After array.size = " + Stat.queue.size() + " quantity = " + stat.getQuantity());
        for (int testI = 0; testI < queue.size(); testI++) {
            int[] queueItem = queue.get(testI);
            Tile tile = arrayTable[queueItem[0]][queueItem[1]];
            System.out.println("position I = " + testI + " " + Arrays.toString(queue.get(testI)));

            System.out.println("order" + tile.getOrder());
        }
        // setAbleBtn(mapSizeApp.get(size), false);
        preview(size, mapSizeApp.get(size));
        //
        // Table2_2 table2_2 = new Table2_2(frame);

    }

    public int[] randomZY(int size) {// random
        int[] xY = new int[2];
        for (int i = 0; i < 2; i++) {
            xY[i] = (int) (Math.random() * (size));
        }
        return xY;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void Showpreview() {

    }

    @Override
    public String toString() {
        return "this is app";
    }

}