package App.object;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Container;

public class Banner extends JPanel {
    JLabel level = new JLabel();

    public Banner(JFrame frame) {
        // setBackground(Color.MAGENTA);
        setLayout(null);
        // setBorderPainted(false);
        setBounds(0, 0, (int) frame.getSize().getWidth(), 50);
        BackBtn backButton = new BackBtn();

        level.setBounds((int) frame.getSize().getWidth() / 2 - 50, 5, 150, 40);
        level.setText("Level Isus");
        level.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        add(backButton);
        add(level);
        // add(c);
        frame.add(this);
    }
}
