package App;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Font;
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
    JLayeredPane layeredPane;
    public static int iCountdown = 0;
    JFrame frame = new JFrame("Windows");// title
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private int size = 800;
    int x = (int) ((dimension.getWidth() - size) / 2);
    int y = (int) ((dimension.getHeight() - size) / 2);
    private int[] position = { x, y };

    // Windows Logo---------------------
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();

    Container c = frame.getContentPane();
    Stat stat = new Stat(this);
    HashMap<Integer, TableMain> mapSizeApp = new HashMap<>();
    public JLabel windows = new JLabel("Windows");// name
    Banner banner;

    public App() {
        mainPage();
    }

    public void mainPage() {// set graphics
        windows.setText("Windows");
        // ----------------------------------------------------------------
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size, size);
        frame.setBackground(Color.WHITE);

        int margin1 = 10;

        frame.setLocation(position[0], position[1]);
        frame.setResizable(false);// disable full windows

        JPanel mainPanel = new JPanel();

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
            }

        });

        int margin = 200;
        mainPanel.setLayout(null);
        Container c = frame.getContentPane();

        btnStart.setBounds((frame.getWidth() / 2) - margin - 4, (frame.getHeight() / 2) + (margin / 4), 400, 100);

        btnStart.setBackground(new Color(22, 250, 134));
        btnStart.setForeground(new Color(50, 50, 50));
        btnStart.setFocusPainted(false);
        btnStart.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        // btn test------------------------------------------------------------------
        test.setVisible(false);
        test.setEnabled(false);
        test.setBackground(new Color(250, 197, 22));
        test.setForeground(Color.WHITE);
        test.setFocusPainted(false);

        test.setBounds((frame.getWidth() / 2) - margin - 4,
                (frame.getHeight() / 2) + ((margin / 2) + ((margin / 5) * 2)), 400,
                100);
        test.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        // Window_Logo-------------------------------------------------------------------
        windows.setBounds((frame.getWidth() / 2) - 179, 110, 400, 500);
        windows.setFont(new Font("Comic Sans MS", Font.BOLD, 84));
        windows.setForeground(new Color(40, 40, 40));

        p1.setBounds((frame.getWidth() / 2) - 4, 46, frame.getWidth() / 7, frame.getWidth() / 7);
        p2.setBounds((frame.getWidth() / 2) - p1.getWidth() - margin1 - 4, 46, frame.getWidth() / 7,
                frame.getWidth() / 7);
        p3.setBounds((frame.getWidth() / 2) - 4, 46 + p2.getHeight() + margin1, frame.getWidth() / 7,
                frame.getWidth() / 7);
        p4.setBounds((frame.getWidth() / 2) - p1.getWidth() - margin1 - 4, 46 + p2.getHeight() + margin1,
                frame.getWidth() / 7, frame.getWidth() / 7);

        p1.setBackground(Color.WHITE);
        p2.setBackground(Color.WHITE);
        p3.setBackground(Color.WHITE);
        p4.setBackground(Color.WHITE);

        // add--------------------------------------
        mainPanel.add(p1);
        mainPanel.add(p2);
        mainPanel.add(p3);
        mainPanel.add(p4);

        mainPanel.add(btnStart);
        mainPanel.add(test);
        c.add(windows);
        frame.add(mainPanel);

        frame.setVisible(true);
    }

    public void start(JLabel windows) { // prepare game
        banner = new Banner(frame);
        banner.setVisible(true);
        // banner.setVisible(true);
        removeName(windows);
        mapSizeApp.clear();
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
        // banner.setVisible(true);
        banner.changeLevel(stat.getLevel());
        mapSizeApp.get(size).setVisbleTure();
        setOrder(size);
    }

    public void setAbleBtn(TableMain table, boolean tf) {
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
        // stat.getQueues(iCountdown);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (iCountdown == Stat.queue.size()) {
                    iCountdown = 0;
                    setAbleBtn(table, true);
                    timer.cancel();
                    return;
                }
                Tile[][] tile = table.returnTable();
                int[] position = stat.getQueues(iCountdown);
                tile[position[0]][position[1]].changecolorAndBack(Color.MAGENTA, new Color(152, 182, 205));
                iCountdown++;
            }
        }, 1000, delay);

    }

    public void setOrder(int size) {
        // System.out.println("array.size = " + Stat.queue.size() + " quantity = " +
        // stat.getQuantity());
        Tile[][] arrayTable = mapSizeApp.get(size)
                .returnTable();
        int quantity = stat.getQuantity();
        ArrayList<int[]> queue = Stat.queue;
        // new table--------------------------------
        if (queue.size() > quantity) {
            // System.out.println("new table");
            for (int iQueue = 0; iQueue < queue.size(); iQueue++) {
                int[] queueItem = queue.get(iQueue);
                Tile tile = arrayTable[queueItem[0]][queueItem[1]];
                // tile.colorBase();
                tile.removeOrder();
            }
            queue.removeAll(queue);
            // new order ----------------------------------
            stat.addQueue(randomZY(size));
            int[] queueItem = queue.get(0);
            Tile tile = arrayTable[queueItem[0]][queueItem[1]];
            tile.setOrder(queue.size());

        } else {// curren table--------------------------------
            // System.out.println("curren table");
            // old queue--------
            for (int iRandom = 1; iRandom < quantity; iRandom++) {
                // stat.addQueue(randomZY(size));
                int[] queueItem = queue.get(iRandom - 1);
                Tile tile = arrayTable[queueItem[0]][queueItem[1]];
                tile.setOrder(iRandom);
            }
            // new queue--------
            stat.addQueue(randomZY(size));
            int[] queueItem = queue.get(queue.size() - 1);
            Tile tile = arrayTable[queueItem[0]][queueItem[1]];
            tile.setOrder(queue.size());
        }
        for (int i = 0; i < quantity; i++) {
            System.out.println(Arrays.toString(new Stat().getQueues(i)));
        }

        preview(size, mapSizeApp.get(size));

    }

    public int[] randomZY(int size) {// random
        int[] xY = new int[2];
        for (int i = 0; i < 2; i++) {
            xY[i] = (int) (Math.random() * (size));
        }
        return xY;
    }

    public JLabel removeName(JLabel windows) {
        windows.setText("");
        return windows;
    }

    public JFrame getFrame() {
        return frame;
    }

    public Banner getBanner() {
        return banner;
    }

    @Override
    public String toString() {
        return "this is app";
    }

    public void setPosition(int x, int y) {
        position[0] = x;
        position[1] = y;
    }

}