package App.object;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BackBtn extends JButton implements ActionListener {
    Stat stat;

    public BackBtn() {
        setText("Back");
        stat = new Stat();
        setBounds(15, 15, 90, 40);
        setFont(new Font("Comic Sans MS", Font.BOLD, 20));
    }

    // public void addActionListener(new ActionListener() {
    // @Override
    // public void actionPerformed(ActionEvent e) {
    // stat.sTartgGameOvar();
    // System.out.println("nha hee");
    // }
    // });
    @Override
    public void actionPerformed(ActionEvent e) {
        stat.sTartgGameOvar();
        System.out.println("nha hee");
    }
}