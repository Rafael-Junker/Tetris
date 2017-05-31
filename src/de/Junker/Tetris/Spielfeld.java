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
}
