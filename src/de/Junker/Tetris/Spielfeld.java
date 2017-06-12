package de.Junker.Tetris;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Spielfeld {
    private int Level;
    private int Reihen;
    private int Punktzahl;
    private int Höhe;
    private int Breite;
    private Graphics graphics;
    private Block[][] spielfeld;
    private Tetromino tetromino;
    private BufferedImage[] blockimage;

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

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
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

    public void start() {
        Level = 1;
        Punktzahl = 0;
        Reihen = 0;
        spielfeld = new Block[10][20];
        System.out.println("Starte Spiel");
        Timer();
    }

    private void render() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (spielfeld[i][j] == null) {
                    System.out.println("Leer");
                } else {
                    drawBlocks(i, j, spielfeld[i][j].getColor());
                    drawActiveTetromino();
                }
            }
        }
    }

    private void Timer() {
        //every time timer goes through one cycle
        render();
    }

    /*
    Prints the Block with the right color on x*25 y*25
     */
    private void drawBlocks(int posx, int posy, Colors color) {
        switch (color) {
            case Light_blue:
                graphics.drawImage(blockimage[0], posx * 25, posy * 25, null);
                break;
            case Dark_blue:
                graphics.drawImage(blockimage[1], posx * 25, posy * 25, null);
                break;
            case Orange:
                graphics.drawImage(blockimage[2], posx * 25, posy * 25, null);
                break;
            case Yellow:
                graphics.drawImage(blockimage[3], posx * 25, posy * 25, null);
                break;
            case Purple:
                graphics.drawImage(blockimage[4], posx * 25, posy * 25, null);
                break;
            case Light_green:
                graphics.drawImage(blockimage[5], posx * 25, posy * 25, null);
                break;
            case Red:
                graphics.drawImage(blockimage[6], posx * 25, posy * 25, null);
                break;
            default:
                System.out.println("Attemted to print invalid color");
        }
    }

    private void drawActiveTetromino() {
        for (Block b : tetromino.getBlocks()
                ) {
            drawBlocks(b.getX(), b.getY(), b.getColor());
        }
    }
}

