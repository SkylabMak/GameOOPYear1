package App.object.FTable;

import java.awt.*;
import javax.swing.*;

public class TableTransparent {

        JPanel panel1 = new JPanel();

        public TableTransparent(JFrame f) {
                panel1.setLayout(null);
                panel1.setSize((int) f.getSize().getWidth(), (int) f.getSize().getHeight());
                System.out.println(f.getSize().getWidth() + " " + f.getPreferredSize().getHeight());
                panel1.setBackground(Color.MAGENTA);

                panel1.setVisible(false);
                f.add(panel1, 2, 0);
        }

        public void setVisbleTure() {
                panel1.setVisible(true);
        }

        public void setVisbleFlase() {
                panel1.setVisible(false);
        }

}