package App.object;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Table {
    private JFrame A;
    private JButton press;
    private JButton pressR;
    private JButton pressL;

    Table() {
        detailComponect();
    }

    private void detailComponect() {
        press = new JButton("");
        pressL = new JButton("");
        pressR = new JButton("");
        press.setPreferredSize(new Dimension(500, 500));
        pressL.setPreferredSize(new Dimension(500, 500));
        pressR.setPreferredSize(new Dimension(500, 500));
        A.setLayout(new FlowLayout());
        A.add(press);
        A.add(pressL);
        A.add(pressR);
    }
}