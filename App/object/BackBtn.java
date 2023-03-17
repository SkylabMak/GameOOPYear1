package App.object;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import App.App;

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
<<<<<<< HEAD
                System.out.println("hee hee pussy");
                App app = new App();
                app.mainPage();
=======
                stat.sTartgGameOvar();
                System.out.println("nha hee");
>>>>>>> 57ac481ece4d17cc27ab6916f9c9e53744b1a800
            }
        });
    }
}