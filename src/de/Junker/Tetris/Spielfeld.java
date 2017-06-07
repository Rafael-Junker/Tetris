package de.Junker.Tetris;

import java.awt.*;


public class Spielfeld {
    private int Level;
    private int Reihen;
    private int Punktzahl;
    private int Höhe;
    private int Breite;
    private Graphics graphics;

    public Spielfeld(int Breite, int Höhe) {
        this.Breite = Breite;
        this.Höhe = Höhe;
    }

    public int getLevel() {
        return Level;
    }

    public int getPunktzahl() {
        return Punktzahl;
    }

    public int getReihen() {
        return Reihen;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void moveLeft() {
        System.out.println("Left");
    }

    public void moveRight() {
        System.out.println("Right");
    }

    public void hardDrop() {
        System.out.println("Hard drop");
    }

    public void softDrop() {
        System.out.println("Soft Dropping");
    }

    public void rotateClockwise() {

    }

    public void rotateCounterclockwise() {

    }
}
