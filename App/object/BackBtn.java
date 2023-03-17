package App.object;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import App.App;

// public class BackBtn {
//     public BackBtn(JPanel panel1) {
//         Stat stat = new Stat();
//         JButton backButton = new JButton("Back");// go back
//         backButton.setBounds(15, 15, 90, 40);
//         backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//         panel1.add(backButton);

//         backButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 System.out.println("nha hee");
//             }
//         });

public class BackBtn extends JButton {
    Stat stat;

    public BackBtn() {
        setText("Back");
        stat = new Stat();
        setBounds(15, 5, 100, 40);
        setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        addMouseListener(new mouseEvent());

    }

    public class mouseEvent extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("nha hee");
            stat.sTartgGameOvar();
            stat.getApp().disableBanner();
        }

    }

}