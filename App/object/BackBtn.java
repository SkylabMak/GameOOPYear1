package App.object;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class BackBtn extends JButton {
    Stat stat;

    public BackBtn() {
        setText("Back");
        stat = new Stat();
        setBounds(15, 5, 100, 40);

        setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        setBackground(new Color(50, 50, 50));
        setForeground(Color.WHITE);
        setFocusPainted(false);

        addMouseListener(new mouseEvent());

    }

    public class mouseEvent extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Btn back");
            stat.sTartGameOvar();
            stat.getApp().getBanner().setVisible(false);
        }
    }
}