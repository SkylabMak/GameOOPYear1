package App.object.FHart;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import App.object.Stat;

public class LifeCouter {
    Stat numberOfHearts = new Stat();
    private JButton heart1 = new JButton();
    private JButton heart2 = new JButton();
    private JButton heart3 = new JButton();
    private int decreaseHeart;
    private Icon img;
    private Image img02;
    private ImageIcon imageIcon;

    public LifeCouter(JPanel jPanel) {
        int xRight = (int) jPanel.getPreferredSize().getWidth(); // collect top rigth
        System.out.println(xRight);
        int yTop = 10;// collct top left
        // --------------------------------------------------
        defaultAllButton1();
        defaultAllButton2();
        defaultAllButton3();
        // --------------------defultButton------------------
        // --------------------------------------------------
        // heart1.setPreferredSize(new Dimension(50, 50));
        // heart2.setPreferredSize(new Dimension(50, 50));
        // heart3.setPreferredSize(new Dimension(50, 50));
        int size = 30;
        int magin = 10;
        System.out.println(size);
        // ---------------------set Dimension-------------------------
        try {
            // Path path = Paths.get("Heart.png");
            // System.out.println(path.toAbsolutePath().toString());
            img = new ImageIcon("Heart.png");
            // // img02 = ImageIO.read(new File("Heart.png"));
            // BufferedImage bufferedImage = ImageIO
            // .read(new
            // File("C:/Users/KhotrAiMek/Desktop/GameOOP/App/object/FHart/Heart.png"));
            // imageIcon = fitimage(img02, size, size);
            heart1.setIcon(img);
            heart2.setIcon(img);
            heart3.setIcon(img);
        } catch (Exception e) {
            System.out.println(e);
        }
        // -----------------------import image----------------------------------
        heart1.setBounds((int) xRight - (size * 2), yTop, size, size);
        heart2.setBounds((int) (xRight - (size * 3) - magin), yTop, size, size);
        heart3.setBounds((int) (xRight - (size * 4) - (magin * 2)), yTop, size, size);
        jPanel.add(heart1);
        jPanel.add(heart2);
        jPanel.add(heart3);

    }

    private Image fitimage(BufferedImage img, int w, int h) {
        // BufferedImage resizedimage = new BufferedImage(w, h,
        // BufferedImage.TYPE_INT_RGB);
        BufferedImage bufferedImageResult = new BufferedImage(
                w,
                h,
                img.getType());

        Graphics2D g2 = bufferedImageResult.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, w, h, null);
        g2.dispose();
        return bufferedImageResult;
    }

    public void WhenPressedWrong() {
        decreaseHeart = numberOfHearts.getHeart();
        if (decreaseHeart == 3) {
            numberOfHearts.decreaseHeart();
            heart1.setVisible(false);
        }
        if (decreaseHeart == 2) {
            numberOfHearts.decreaseHeart();
            heart2.setVisible(false);
        }
        if (decreaseHeart == 1) {
            numberOfHearts.decreaseHeart();
            heart3.setVisible(false);
        }
    }

    public void defaultAllButton1() {
        heart1.setContentAreaFilled(false);
        heart1.setModel(new Reset());
        heart1.setBorder(BorderFactory.createEmptyBorder());
    }

    public void defaultAllButton2() {
        heart2.setContentAreaFilled(false);
        heart2.setModel(new Reset());
        heart2.setBorder(BorderFactory.createEmptyBorder());
    }

    public void defaultAllButton3() {
        heart3.setContentAreaFilled(false);
        heart3.setModel(new Reset());
        heart3.setBorder(BorderFactory.createEmptyBorder());
    }

    // Not Use----------------------
    public class Reset extends DefaultButtonModel {
        @Override
        public boolean isPressed() {
            return false;
        }

        @Override
        public boolean isRollover() {
            return false;
        }
    }
}
