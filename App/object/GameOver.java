package App.object;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver {
    JPanel gameOverPanel = new JPanel();
    Container c;
    JLabel gameOver = new JLabel("Game Over");
    JButton restart = new JButton("Restart");// button start
    JLabel yourLavel = new JLabel("YourLevel");

    GameOver(JFrame f) {
        gameOverPanel.setLayout(null);
        gameOverPanel.setBackground(new Color(51, 153, 230));
        restart.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        gameOver.setFont(new Font("Comic Sans MS", Font.BOLD, 84));
        yourLavel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        gameOver.setForeground(new Color(40, 40, 40));

        yourLavel.setText("You Level = " + new Stat().getLevel());

        gameOverPanel.add(restart);
        gameOverPanel.add(gameOver);
        gameOverPanel.add(yourLavel);
        gameOver.setBounds((int) ((f.getWidth() / 2) - (gameOver.getPreferredSize().getWidth() / 2)), 5, 600,
                500);
        restart.setBounds((int) ((f.getWidth() / 2) - restart.getPreferredSize().getWidth()), 400, 300,
                100);
        yourLavel.setBounds((int) ((f.getWidth() / 2) - (yourLavel.getPreferredSize().getWidth() / 2)), 90, 600,
                500);
        restart.setBackground(new Color(50, 50, 50));
        restart.setForeground(Color.WHITE);
        restart.setFocusPainted(false);

        restart.addActionListener(new BtnRestart());
        gameOver.setFocusable(false);

        f.add(gameOverPanel);
    }

    public void restartInGO() {
        gameOverPanel.setVisible(false);
        System.out.println("reset game");
        new Stat().restartGame();
    }

    private class BtnRestart implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            restartInGO();
        }
    }
}