package App.object;

public class Stat {
    private int level = 0;
    private int heart = 3;
    private int size = 2;
    private int quantity = 1;

    public void reset() {
        level = 0;
        heart = 3;
        size = 2;
        quantity = 1;
    }

    public void setHeart(int heart) {
        this.heart += heart;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void upLevel() {
        this.quantity++;
        this.level++;
        if (this.level == 6) {
            this.size++;// 3
            this.quantity = 1;// reset
        } else if (this.level == 11) {
            this.size++;// 4
            this.quantity = 1;// reset
        }
    }

    public int getHeart() {
        return heart;
    }

    public int getLevel() {
        return level;
    }

    public int getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }
}
