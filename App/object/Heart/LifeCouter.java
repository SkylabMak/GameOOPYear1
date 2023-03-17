package App.object.Heart;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import App.object.Stat;

public class LifeCouter  {
    Stat numberOfHearts = new Stat();
    private JButton heart1 = new JButton();
    private JButton heart2 = new JButton();
    private JButton heart3 = new JButton();
    private int decreaseHeart;
    private Icon img;
    
    LifeCouter(JPanel jPanel){
    int xRight = (int) jPanel.getPreferredSize().getWidth(); //collect top rigth 
    int yTop = 0;//collct top left
    //--------------------------------------------------
        defaultAllButton1();
        defaultAllButton2();
        defaultAllButton3();
    //--------------------defultButton------------------
    //--------------------------------------------------
    heart1.setPreferredSize(new Dimension(200, 200));
    heart2.setPreferredSize(new Dimension(200, 200));
    heart3.setPreferredSize(new Dimension(200, 200));
    //---------------------set Dimension-------------------------
    try {
        img = new ImageIcon("App/object/Heart/Heart.png");
        heart1.setIcon(img);
        heart2.setIcon(img);
        heart3.setIcon(img);
    } catch (Exception e) {
        System.out.println(e);
    }
    //-----------------------import image----------------------------------
    Dimension sizeInHeart1 = heart1.getPreferredSize();
    //heart1.setBounds(xRight, yTop, yTop, xRight);
    heart2.setBounds(xRight, yTop, yTop, xRight);
    heart3.setBounds(xRight, yTop, yTop, xRight);
    jPanel.add(heart1); 
    jPanel.add(heart2);
    jPanel.add(heart3);
    


        


        /*         //heart ---------------------------------------------------- */
/*     int xRight = (int) panel1.getPreferredSize().getWidth(); //collect top rigth */
/*     int yTop = 0;//collct top left */
/*     Dimension sizeInHeart1 = (heart.getHeart1()).getPreferredSize(); */
/*     heart.defaultAllButton1(); */
/*     heart2.defaultAllButton2(); */
/*     heart3.defaultAllButton3(); */
/*     (heart.getHeart1()).setBounds((int)(xRight - sizeInHeart1.getWidth() -margin),(int)(yTop - sizeInHeart1.getHeight() - margin),    */
/*             size.width, size.height); */
/*     Dimension sizeInHeart2 = (heart.getHeart1()).getPreferredSize(); */
/*     (heart.getHeart1()).setBounds((int)(xRight - sizeInHeart2.getWidth() -margin),(int)(yTop - sizeInHeart2.getHeight() - margin),    */
/*                     size.width, size.height); */
/*     Dimension sizeInHeart3 = (heart.getHeart1()).getPreferredSize(); */
/*     (heart.getHeart1()).setBounds((int)(xRight - sizeInHeart3.getWidth() -margin),(int)(yTop - sizeInHeart3.getHeight() - margin),    */
/*             size.width, size.height); */
/*     //(heart2.getHeart2()).setBounds(); */
/*     //(heart3.getHeart3()).setBounds(); */
/*      */
/*     heart.testsetboundH1();// set location */
/*     heart.setImgHeart(); // set image */
/*      */
/*     //heart.WhenPressedWrong(); */
/*     //heart.WhenPressedWrong(); */
/*     panel1.add(heart.getHeart1()); */
/*     panel1.add(heart2.getHeart2()); */
/*     panel1.add(heart3.getHeart3()); */
/* // ------------------------------------ */
    }

    public LifeCouter(JLabel windows) {
    }

    public JButton getHeart1() {
        heart1.setPreferredSize(new Dimension(200, 200));
        return heart1;
    }
    public JButton getHeart2() {
        heart2.setPreferredSize(new Dimension(200, 200));
        return heart2;
    }
    public JButton getHeart3() {
        heart3.setPreferredSize(new Dimension(200, 200));
        return heart3;
    }
    
    //---------------------hard code---------------------------
    public void testsetboundH1(){
        heart1.setBounds(0, 0,100, 100);
    }
    //---------------------------------------------------------

    public void setImgHeart(){
        try {
            img = new ImageIcon("App/object/Heart/Heart.png");
            heart1.setIcon(img);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public void setImgHeart1(){
        try {
            img = new ImageIcon("App/object/Heart/Heart.png");
            heart1.setIcon(img);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    public void setImgHeart2(){
        try {
            img = new ImageIcon("App/object/TileHeart/Heart.png");
            heart1.setIcon(img);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    

    public void WhenPressedWrong(){
        decreaseHeart = numberOfHearts.getHeart();
        if(decreaseHeart == 3){
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


    public JButton defaultAllButton111(){
        heart1.setContentAreaFilled(false);
        heart1.setModel(new Reset());
        heart1.setBorder(BorderFactory.createEmptyBorder());
        return heart1;
    }
    public JButton defaultAllButton222(){
        heart2.setContentAreaFilled(false);
        heart2.setModel(new Reset());
        heart2.setBorder(BorderFactory.createEmptyBorder());
        return heart2;
    }
    public JButton defaultAllButton333(){
        heart3.setContentAreaFilled(false);
        heart3.setModel(new Reset());
        heart3.setBorder(BorderFactory.createEmptyBorder());
        return heart3;
    }
    public void defaultAllButton1(){
        heart1.setContentAreaFilled(false);
        heart1.setModel(new Reset());
        heart1.setBorder(BorderFactory.createEmptyBorder());
    }
    public void defaultAllButton2(){
        heart2.setContentAreaFilled(false);
        heart2.setModel(new Reset());
        heart2.setBorder(BorderFactory.createEmptyBorder());
    }
    public void defaultAllButton3(){
        heart3.setContentAreaFilled(false);
        heart3.setModel(new Reset());
        heart3.setBorder(BorderFactory.createEmptyBorder());
    }
    
    //Not Use----------------------
    public int getNumberOfHearts() {
        return numberOfHearts.getHeart();
    }
    //Not Use----------------------
    public class Reset extends DefaultButtonModel    {
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
