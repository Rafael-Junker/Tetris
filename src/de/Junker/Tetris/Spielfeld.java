package de.Junker.Tetris;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class Spielfeld {

    private boolean paused = false;
    private boolean gameRunning = false;

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
        currentTetromino.moveLeft(spielfeld);
        render();
    }

    public void moveRight() {
        currentTetromino.moveRight(spielfeld);
        render();
    }

    public void hardDrop() {
        System.out.println("Hard drop");
    }

    public void softDrop() {
        System.out.println(currentTetromino.moveDown(spielfeld));
        render();
    }

    public void Enter() {
        if (!gameRunning) {
            newGame();
        } else {
            pause();
        }
    }

    public void rotateClockwise() {
        currentTetromino.rotateClockwise(spielfeld);
        render();
    }

    public void rotateCounterclockwise() {
        currentTetromino.rotateCounterClockwise(spielfeld);
        render();
    }

    public void pause() {
        if (!paused) {
            gameTimer.stop();
            paused = !paused;
        } else {
            gameTimer.start();
            paused = !paused;
        }
    }

    public void newGame() {
        gameRunning = true;
        spielfeld = new Block[10][22];
        Level = 1;
        Punktzahl = 0;
        Reihen = 0;

        System.out.println("Starte Spiel");
        try {
            BufferedImage image = ImageIO.read(ImageIO.class.getResource("/Tetris.png"));
            blockimage = new BufferedImage[8];
            for (int i = 0; i < 8; i++) {
                blockimage[i] = image.getSubimage((i * 25), 0, 25, 25);
            }

        } catch (Exception e) {
            System.out.println("Error reading resources. Exiting now");
            System.exit(1);
        }

        bag = new TetrominoBag();
        currentTetromino = bag.getNext();
        nextTetromino = bag.getNext();
        bag.increment();

        if (gameTimer == null) {
            gameTimer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GameTick();
                }
            });
        }
        if (!gameTimer.isRunning()) {
            gameTimer.start();
        }
    }

    private void render() {
        /*
           Draws all blocks on the gamefiled
         */
        for (int i = 0; i < 10; i++) {
            for (int j = 2; j < 22; j++) {
                if (spielfeld[i][j] == null) {
                    drawBlocks(i, j, Colors.empty);
                } else {
                    drawBlocks(i, j, spielfeld[i][j].getColor());

                }
            }
        }
        /*
            Draw active Tetromino
         */
        drawActiveTetromino();
    }

    /*
    Prints the Block with the right color on x*25 y*25 (with 25 px buffer left and 30px buffer top/bottom)
     */
    private void drawBlocks(int posx, int posy, Colors color) {
        switch (color) {
            case Light_blue:
                graphics.drawImage(blockimage[0], posx * 25 + 25, (posy - 2) * 25 + 45, null);
                break;
            case Dark_blue:
                graphics.drawImage(blockimage[1], posx * 25 + 25, (posy - 2) * 25 + 45, null);
                break;
            case Orange:
                graphics.drawImage(blockimage[2], posx * 25 + 25, (posy - 2) * 25 + 45, null);
                break;
            case Yellow:
                graphics.drawImage(blockimage[3], posx * 25 + 25, (posy - 2) * 25 + 45, null);
                break;
            case Purple:
                graphics.drawImage(blockimage[4], posx * 25 + 25, (posy - 2) * 25 + 45, null);
                break;
            case Light_green:
                graphics.drawImage(blockimage[5], posx * 25 + 25, (posy - 2) * 25 + 45, null);
                break;
            case Red:
                graphics.drawImage(blockimage[6], posx * 25 + 25, (posy - 2) * 25 + 45, null);
                break;
            case empty:
                graphics.drawImage(blockimage[7], posx * 25 + 25, (posy - 2) * 25 + 45, null);
                break;
            default:
                //case for invalid color(should never be called)
                System.out.println("Attempted to draw invalid color");
        }
    }

    private void drawActiveTetromino() {
        for (Block b : currentTetromino.getBlocks()
                ) {
            if (b.getY() > 1) {
                drawBlocks(b.getX(), b.getY(), b.getColor());
            }
        }
    }

    private void GameTick() {
        if (currentTetromino.moveDown(spielfeld)) {
        } else {
            addBlocks(currentTetromino.getBlocks());
            currentTetromino = nextTetromino;
            nextTetromino = bag.getNext();
            bag.increment();
            addPoints(clearRows());
            GameOver();
        }
        render();
        System.out.println("one tick passed");
    }

    private int clearRows() {
        int linescleared =0;
        for (int column = 0; column < 22; column++) {

            int Blocksinrow = 0;

            for (int row = 0; row < 10; row++) {
                if (spielfeld[row][column] != null) {
                    Blocksinrow++;
                }
            }
            if (Blocksinrow ==10) {
                for (int row = 0; row < 10; row++) {
                    spielfeld[row][column] = null;
                }
                linescleared++;
            }
        }
        compactRows();
        return linescleared;
    }

    private void compactRows(){
        Block[][] newField = new Block[10][22];
        int newFieldrow = 21;

        for (int row = 21; row > 0; row--) {
            int Blocksinrow = 0;
            for (int column = 0; column < 10; column++) {
                if (spielfeld[column][row] != null) {
                    Blocksinrow++;
                }
            }
            if (Blocksinrow != 0) {
                for (int column = 0; column < 10; column++) {
                    newField[column][newFieldrow] = spielfeld[column][row];
                }
                newFieldrow--;
            }

        }
        spielfeld = newField;
    }

    private void addBlocks(Block[] tetromino) {
        for (Block b : tetromino
                ) {
            spielfeld[b.getX()][b.getY()] = b;
        }
    }

    private void GameOver() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                if (spielfeld[j][i] != null) {
                    gameRunning = false;
                    gameTimer.stop();
                    Scores.addScore(Punktzahl);
                }
            }
        }
    }

    private void addPoints(int clearedLines) {
        switch (clearedLines) {
            case 1:
                Punktzahl = Punktzahl + ((Level + 1) * 40);
                Reihen = Reihen + clearedLines;
                break;
            case 2:
                Punktzahl = Punktzahl + ((Level + 1) * 100);
                Reihen = Reihen + clearedLines;
                break;
            case 3:
                Punktzahl = Punktzahl + ((Level + 1) * 300);
                Reihen = Reihen + clearedLines;
                break;
            case 4:
                Punktzahl = Punktzahl + ((Level + 1) * 1200);
                Reihen = Reihen + clearedLines;
                break;
            default:
                return;
        }
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

