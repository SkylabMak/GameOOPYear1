package App.object;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import App.App;

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
    JButton restart = new JButton("restart");// button start
    JFrame f;

    GameOver(JFrame f) {
        this.f = f;
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
        restart.addActionListener(new BtnRestart());
        f.add(gameOverPanel);
    }

    public void restartInGO() {
        System.out.println("reset game");
        new Stat().restartGame();
    }

    private class BtnRestart implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gameOverPanel.setVisible(false);
            restartInGO();
            // SwingUtilities.updateComponentTreeUI(f);

        }

    }
}
