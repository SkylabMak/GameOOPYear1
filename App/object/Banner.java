package App.object;

import App.object.FHart.LifeCouter;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Banner extends JPanel {
    JLabel level = new JLabel();
    LifeCouter lifeCouter;

    public Banner(JFrame frame) {
        setLayout(null);
        setBounds(0, 0, (int) frame.getSize().getWidth(), 50);
        BackBtn backButton = new BackBtn();

        level.setBounds((int) frame.getSize().getWidth() / 2 - 50, 5, 150, 40);
        level.setText("Level ");
        level.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        lifeCouter = new LifeCouter(this);

        add(backButton);
        add(level);
        frame.add(this);
    }

    public void changeLevel(int newlevel) {
        level.setText("Level " + newlevel);
    }

    public void changHeart() {
        lifeCouter.WhenPressedWrong();
    }
}
