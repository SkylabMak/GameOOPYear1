package App.object;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tile {
    private JButton blackcolor = new JButton();
    private int OwnOrder = -1;
    Timer timer;

    public void setOrder(int newOrder) {
        this.OwnOrder = newOrder;
    }

    public Tile(JPanel a) {
        blackcolor.setPreferredSize(new Dimension(100, 100));
        blackcolor.setBackground(Color.CYAN);
    }

    public JButton returnBTn() {
        return blackcolor;
    }

    public void ChangeColor() {// wait Local variables
        blackcolor.setBackground(Color.white);
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
            // TODO Auto-generated method stub
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

}
