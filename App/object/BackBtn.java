package App.object;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BackBtn {
    public BackBtn(JPanel panel1) {
        Stat stat = new Stat();
        JButton backButton = new JButton("Back");// go back
        backButton.setBounds(15, 15, 90, 40);
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        panel1.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stat.reset();
            }
        });
    }
}