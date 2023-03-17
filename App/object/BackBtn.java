package App.object;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class BackBtn extends JButton {
    Stat stat;

    public BackBtn() {
        setText("Back02");
        stat = new Stat();
        setBounds(15, 15, 150, 40);
        setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        addMouseListener(new mouseEvent());
        setFocusPainted(false);
    }

    public class mouseEvent extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("nha hee");
            stat.sTartgGameOvar();
        }

    }

}