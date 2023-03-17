package App.object;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Container;

public class Banner extends JPanel {
    JLabel level = new JLabel();

    public Banner(JFrame frame) {
        setBounds(0, 0, (int) frame.getSize().getWidth(), 50);
        // Container c = getContent ;
        // c = frame.getContentPane();
        BackBtn backButton = new BackBtn();
        add(backButton);
        // add(c);
        frame.add(this);
    }
}
