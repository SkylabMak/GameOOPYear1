package App.object.FTile;

import javax.swing.JPanel;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Timer;

import App.object.Stat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tile {
    protected JButton btnTile = new JButton();
    private ArrayList<Integer> ownOrder = new ArrayList<>();
    Stat stat = new Stat();
    Timer timer;
    Color baseColor = Color.white;
    boolean changeColorAferTure = false;

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
        // btnTile.addActionListener(new AllButtonListener());
        btnTile.setBackground(baseColor);
        btnTile.setModel(new FixedStateButtonModel());
        // btnTile.setPreferredSize(new Dimension(200, 200));
    }

    public JButton returnBTn() {
        return btnTile;
    }

    public void ChangeColor() {// wait Local variables
        btnTile.setBackground(Color.white);
    }

    public void ChangeColor2() {// wait Local variables
        btnTile.setBackground(Color.black);
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

    public void incorrect() {
        System.out.println("incorrect");
        btnTile.setBackground(Color.RED);
        changecolorAndBack(Color.RED);
        stat.decreaseHeart();
    }

    public void changecolorAndBack(Color color) {
        // Tile a = new Tile(btn_tileWhite, btn_tileBlack);
        btnTile.setBackground(color);
        int delay = 100;
        Timer timer = new Timer(delay, e -> {
            btnTile.setBackground(baseColor);
            // btnTile.setEnabled(true);
        });
        timer.setRepeats(false);// make sure the timer only runs onc
        timer.start();
    }

    public void changecolorCorrect(Color color) {
        // Tile a = new Tile(btn_tileWhite, btn_tileBlack);
        btnTile.setBackground(color);
        int delay = 1000;
        Timer timer = new Timer(delay, e -> {
            btnTile.setBackground(color);
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
        if (ownOrder.size() == 0) {
            incorrect();
        } else if (ownOrder.get(0) == stat.getQuantity()) {
            ownOrder.removeAll(ownOrder);
            System.out.println("depleted");
            changecolorAndBack(Color.green);
            stat.upLevel();
        } else if (ownOrder.get(0) == stat.getCurrentOrder()) {
            stat.UpOrder();
            System.out.println("correct");
            ownOrder.remove(0);
            changeColorAferTure = true;
            if (ownOrder.size() == 0) {
                System.out.println("if order.size =0");
                // changecolorCorrect(Color.green);
                btnTile.setBackground(Color.green);
            } else {
                System.out.println("else order.size != 0");
                // changecolorCorrect(Color.GRAY);
                btnTile.setBackground(Color.green);
            }
        } else {
            System.out.println("else");
            incorrect();
        }
        // if (OwnOrder == stat.getQuantity()) {
        // stat.upLevel();
        // } else if (OwnOrder != stat.getCurrentOrder()) {
        // stat.decreaseHeart();
        // } else {
        // stat.UpOrder();
        // }
        // throw new UnsupportedOperationException("Unimplemented method
        // 'actionPerformed'");
    }

    private class AllButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // ChangecolorAfterClick(btnTile);
        }

    }

    public class mouseEvent extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            super.mouseClicked(e);

            // check();
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            // if (changeColorAferTure)
            //     return;
            btnTile.setBackground(new Color(255, 204, 0));
            // System.out.println("this is Tile mouse over");
        }

        @Override
        public void mouseExited(MouseEvent me) {
            // if (changeColorAferTure)
            //     return;
            btnTile.setBackground(baseColor);
        }

        @Override
        public void mousePressed(MouseEvent me) {
            btnTile.setBackground(new Color(0, 107, 179));
            // System.out.println("this is Tile mouse Pressed");
            check();

        }

        @Override
        public void mouseReleased(MouseEvent me) {
            // if (changeColorAferTure)
            //     return;
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
