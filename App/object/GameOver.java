package App.object;

import javax.swing.JPanel;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class GameOver {
    JPanel gameOverPanel = new JPanel();
    Container c;
    JLabel gameOver = new JLabel("Game Over");
    JButton restart = new JButton("restart");// button start

    GameOver(JFrame f) {
        gameOverPanel.setLayout(null);
        // c = gameOverPanel.get
        restart.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
        gameOver.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
        gameOverPanel.add(restart);
        gameOverPanel.add(gameOver);
        gameOver.setBounds((int) ((f.getWidth() / 2) - gameOver.getPreferredSize().getWidth()), 100, 400,
                500);
        restart.setBounds((int) ((f.getWidth() / 2) - restart.getPreferredSize().getWidth()), 200, 100,
                100);
        f.add(gameOverPanel);
    }
}
