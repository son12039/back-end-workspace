package creature;

public class Food {
    private int x;
    private int y;
    private boolean eaten;

    public Food(int x, int y) {
        this.x = x;
        this.y = y;
        this.eaten = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEaten() {
        return eaten;
    }

    public void eat() {
        this.eaten = true;
    }
}


