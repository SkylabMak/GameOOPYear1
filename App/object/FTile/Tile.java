package App.object.FTile;

import App.object.Stat;

import javax.swing.JPanel;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.Timer;

public class Tile {
    protected JButton btnTile = new JButton();
    private ArrayList<Integer> ownOrder = new ArrayList<>();
    Stat stat = new Stat();
    Timer timer;
    Color baseColor = Color.white;
    boolean disableEvent = true;

    public void setOrder(int newOrder) {
        this.ownOrder.add(newOrder);
    }

    public void removeOrder() {
        ownOrder.removeAll(ownOrder);
    }

    public ArrayList<Integer> getOrder() {
        return this.ownOrder;
    }

    public Tile() {
    }

    public Tile(JPanel jPanel) {
        btnTile.addMouseListener(new mouseEvent());
        btnTile.setBackground(baseColor);
        btnTile.setModel(new FixedStateButtonModel());
    }

    public JButton returnBTn() {
        return btnTile;
    }

    public void incorrect() {
        // System.out.println("incorrect");
        changecolorAndBack(Color.RED, baseColor);
        stat.decreaseHeart();
    }

    public void changecolorAndBack(Color color, Color colorBack) {
        // Tile a = new Tile(btn_tileWhite, btn_tileBlack);
        btnTile.setBackground(color);
        int delay = 600;
        Timer timer = new Timer(delay, e -> {
            btnTile.setBackground(colorBack);
            // btnTile.setEnabled(true);
        });
        timer.setRepeats(false);// make sure the timer only runs onc
        timer.start();
    }

    public void colorBase() {
        btnTile.setBackground(baseColor);
    }

    public void check() {
        System.out.println("currenOrder" + stat.getCurrentOrder());
        if (ownOrder.size() == 0) {// incorect
            incorrect();
        } else if (ownOrder.get(0) == stat.getQuantity()) {// corect and last
            Timer timer = new Timer(250, e -> {
                stat.upLevel();
            });
            timer.setRepeats(false);
            timer.start();
            ownOrder.removeAll(ownOrder);
            // System.out.println("depleted");
            changecolorAndBack(Color.green, baseColor);

        } else if (ownOrder.get(0) == stat.getCurrentOrder()) {// corrct
            stat.UpOrder();
            // System.out.println("correct");
            ownOrder.remove(0);
            // disableEvent = true;
            btnTile.setBackground(Color.green);
        } else {// incorrect
            // System.out.println("else");
            incorrect();
        }

    }

    public void setAbleBtn(boolean tf) {
        disableEvent = tf;
        if (tf)
            btnTile.setBackground(baseColor);
        else
            btnTile.setBackground(new Color(152, 182, 205));
    }

    public class mouseEvent extends MouseAdapter {

        // @Override
        // public void mouseClicked(MouseEvent e) {
        // if (!disableEvent)
        // return;
        // super.mouseClicked(e);
        // }

        @Override
        public void mouseEntered(MouseEvent me) {
            if (!disableEvent)
                return;
            btnTile.setBackground(new Color(255, 204, 0));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            if (!disableEvent)
                return;
            btnTile.setBackground(baseColor);
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (!disableEvent)
                return;
            btnTile.setBackground(new Color(0, 107, 179));
            check();

        }

        @Override
        public void mouseReleased(MouseEvent me) {
            if (!disableEvent)
                return;
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

        // @Override
        // public void setRollover(boolean b) {
        // // NOOP
        // }

    }

    @Override
    public String toString() {
        return String.format("this is Tile");
    }

}
