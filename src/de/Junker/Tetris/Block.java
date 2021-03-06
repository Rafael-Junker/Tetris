package de.Junker.Tetris;


public class Block {
    private Colors color;
    private int x;
    private int y;

    public Block(Colors color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Colors getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
