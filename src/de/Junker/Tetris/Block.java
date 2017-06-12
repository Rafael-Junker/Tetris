package de.Junker.Tetris;


public class Block {
    private Colors color;
    private int x;
    private int y;

    public Block(Colors color) {
        this.color = color;
    }

    public Colors getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
