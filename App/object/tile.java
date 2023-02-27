package App.object;

import javax.swing.JPanel;

public class Tile {
    private String blackcolor;
    private String whitecolor;

    public Tile(JPanel a) {

    }

    public String getWhitecolor() {
        return whitecolor;
    }

    public String getBlackcolor() {
        return blackcolor;
    }

    public void changeColorWhite() {
        blackcolor = whitecolor;
    }

    public void setBlackcolor(String blackcolor) {
        this.blackcolor = blackcolor;
    }

    public void setWhitecolor(String whitecolor) {
        this.whitecolor = whitecolor;
    }

    public void changeColorWhite(String blackColor) {
        blackcolor = whitecolor;
    }

    public void changeColorToBlue(String blackColor) {
        // nothing;
    }

    public void touchButtom() {

    }

    public String toString() {
        return String.format("this is Tile class");
    }

}
