package de.Junker.Tetris;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Spielfeld {

    private int Level;
    private int Reihen;
    private int Punktzahl;
    private Graphics graphics;
    private Block[][] spielfeld;
    private Tetromino currentTetromino;
    private Tetromino nextTetromino;
    private Tetromino heldTetromino;
    private BufferedImage[] blockimage;
    private Timer gameTimer;
    private TetrominoBag bag;

    public Spielfeld() {

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
        System.out.println("Rotating Clockwise");
    }

    public void rotateCounterclockwise() {
        System.out.println("Rotating Counterclockeise");
    }

    public void newGame() {
        Level = 1;
        Punktzahl = 0;
        Reihen = 0;

        spielfeld = new Block[10][20];

        System.out.println("Starte Spiel");
        try {
            BufferedImage image = ImageIO.read(ImageIO.class.getResource("/Tetris.png"));
            blockimage = new BufferedImage[8];
            for (int i = 0; i < 8; i++) {
                blockimage[i] = image.getSubimage((i * 25), 0, 25, 25);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading resources. Exiting now");
            System.exit(1);
        }

        bag = new TetrominoBag();
        currentTetromino = bag.getNext();

        gameTimer = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GameTick();
            }
        });

        gameTimer.start();
    }

    private void render() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (spielfeld[i][j] == null) {
                    drawBlocks(i, j, Colors.empty);
                } else {
                    drawBlocks(i, j, spielfeld[i][j].getColor());

                }
            }
        }
        drawActiveTetromino();
    }

    /*
    Prints the Block with the right color on x*25 y*25 (with 25 px buffer left and 30px buffer top/bottom)
     */
    private void drawBlocks(int posx, int posy, Colors color) {
        switch (color) {
            case Light_blue:
                graphics.drawImage(blockimage[0], posx * 25 + 25, posy * 25 + 30, null);
                break;
            case Dark_blue:
                graphics.drawImage(blockimage[1], posx * 25 + 25, posy * 25 + 30, null);
                break;
            case Orange:
                graphics.drawImage(blockimage[2], posx * 25 + 25, posy * 25 + 30, null);
                break;
            case Yellow:
                graphics.drawImage(blockimage[3], posx * 25 + 25, posy * 25 + 30, null);
                break;
            case Purple:
                graphics.drawImage(blockimage[4], posx * 25 + 25, posy * 25 + 30, null);
                break;
            case Light_green:
                graphics.drawImage(blockimage[5], posx * 25 + 25, posy * 25 + 30, null);
                break;
            case Red:
                graphics.drawImage(blockimage[6], posx * 25 + 25, posy * 25 + 30, null);
                break;
            case empty:
                graphics.drawImage(blockimage[7], posx * 25 + 25, posy * 25 + 30, null);
                break;
            default:
                //case for invalid color(should never be called)
                System.out.println("Attempted to draw invalid color");
        }
    }

    private void drawActiveTetromino() {
        for (Block b : currentTetromino.getBlocks()
                ) {
            drawBlocks(b.getX(), b.getY(), b.getColor());
        }
    }

    public void pause() {
        System.out.println("Pausing");
    }

    private void GameTick() {
        render();
        System.out.println("one tick passed");
    }
}

