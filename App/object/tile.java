package App.object;

import javax.swing.JPanel;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tile {
    private JButton btnTile = new JButton();
    private int OwnOrder = -1;
    Timer timer;
    Color baseColor = Color.white;

    public void setOrder(int newOrder) {
        this.OwnOrder = newOrder;
    }

    public Tile() {
    }

    public Tile(JPanel jPanel) {
        btnTile.addMouseListener(new mouseEvent());
        // btnTile.addActionListener(new AllButtonListener());
        btnTile.setPreferredSize(new Dimension(200, 200));
        btnTile.setBackground(baseColor);
        btnTile.setModel(new FixedStateButtonModel());
    }

    public JButton returnBTn() {
        return btnTile;
    }

    public void ChangeColor() {// wait Local variables
        btnTile.setBackground(Color.white);
    }

    public void settimeout() {
        int secord = 1;
        ActionListener taskperformer = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        };
        timer = new Timer(0, taskperformer);
        timer.setInitialDelay(secord);
        timer.start();

    }

    private class AllButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // ChangecolorAfterClick(btnTile);
        }

        public void ChangecolorAfterClick(JButton btn) {
            // Tile a = new Tile(btn_tileWhite, btn_tileBlack);
            btn.setBackground(Color.CYAN);
            int delay = 100;
            Timer timer = new Timer(delay, e -> {
                btn.setBackground(Color.WHITE);
                btn.setEnabled(true);
            });
            timer.setRepeats(false);// make sure the timer only runs onc
            timer.start();
        }

        public void check() {
            Stat stat = new Stat();
            if (OwnOrder == stat.getQuantity()) {
                stat.upLevel();
            } else if (OwnOrder != stat.getCurrentOrder()) {
                stat.decreaseHeart();
            } else {
                stat.UpOrder();
            }
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }

    }

    public class mouseEvent extends MouseAdapter {

        public void mouseEntered(MouseEvent me) {
            btnTile.setBackground(Color.ORANGE);
        }

        public void mouseExited(MouseEvent me) {
            btnTile.setBackground(baseColor);
        }

        public void mousePressed(MouseEvent me) {
            presesdAndHold();
        }

        public void presesdAndHold() {
            btnTile.setBackground(Color.MAGENTA);
            System.out.println("this is Tile mouse Pressed");
        }

        public void mouseReleased(MouseEvent me) {
            btnTile.setBackground(baseColor);
        }
    }

    public class FixedStateButtonModel extends DefaultButtonModel {

        @Override
        public boolean isPressed() {
            return false;
        }

        @Override
        public boolean isRollover() {
            return false;
        }

        @Override
        public void setRollover(boolean b) {
            // NOOP
        }

    }

    public String toString() {
        return String.format("this is Tile");
    }

}
