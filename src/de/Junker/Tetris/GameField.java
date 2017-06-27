package de.Junker.Tetris;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class GameField {

    private boolean paused = false;
    private boolean gameRunning = false;

    private int Level;
    private int Rows;
    private int Points;
    private Graphics graphics;
    private Block[][] gameField;
    private Tetromino currentTetromino;
    private Tetromino nextTetromino;
    private BufferedImage[] blockimage;
    private Timer gameTimer;
    private TetrominoBag bag;

    public GameField() {

    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void moveLeft() {
        currentTetromino.moveLeft(gameField);
        render();
    }

    public void moveRight() {
        currentTetromino.moveRight(gameField);
        render();
    }

    public void hardDrop() {
        System.out.println("Hard drop");
    }

    public void softDrop() {
        System.out.println(currentTetromino.moveDown(gameField));
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
        currentTetromino.rotateClockwise(gameField);
        render();
    }

    public void rotateCounterclockwise() {
        currentTetromino.rotateCounterClockwise(gameField);
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
        gameField = new Block[10][22];
        Level = 1;
        Points = 0;
        Rows = 0;

        System.out.println("Starte Spiel");
        try {
            BufferedImage image = ImageIO.read(ImageIO.class.getResource("/de/Junker/Tetris/Tetris.png"));
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
            gameTimer = new Timer(1000, new ActionListener() {
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
                if (gameField[i][j] == null) {
                    drawBlocks(i, j, Colors.empty);
                } else {
                    drawBlocks(i, j, gameField[i][j].getColor());

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
        if (!currentTetromino.moveDown(gameField)) {
            addBlocks(currentTetromino.getBlocks());
            gameTimer.setDelay(1000 - ((Level - 1)) * 50);
            currentTetromino = nextTetromino;
            nextTetromino = bag.getNext();
            bag.increment();
            addPoints(clearRows());
            Level = (Rows / 10) + 1;
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
                if (gameField[row][column] != null) {
                    Blocksinrow++;
                }
            }
            if (Blocksinrow ==10) {
                for (int row = 0; row < 10; row++) {
                    gameField[row][column] = null;
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
                if (gameField[column][row] != null) {
                    Blocksinrow++;
                }
            }
            if (Blocksinrow != 0) {
                for (int column = 0; column < 10; column++) {
                    newField[column][newFieldrow] = gameField[column][row];
                }
                newFieldrow--;
            }

        }
        gameField = newField;
    }

    private void addBlocks(Block[] tetromino) {
        for (Block b : tetromino
                ) {
            gameField[b.getX()][b.getY()] = b;
        }
    }

    private void GameOver() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                if (gameField[j][i] != null) {
                    gameRunning = false;
                    gameTimer.stop();
                }
            }
        }
    }

    private void addPoints(int clearedLines) {
        switch (clearedLines) {
            case 1:
                Points = Points + ((Level + 1) * 40);
                Rows = Rows + clearedLines;
                break;
            case 2:
                Points = Points + ((Level + 1) * 100);
                Rows = Rows + clearedLines;
                break;
            case 3:
                Points = Points + ((Level + 1) * 300);
                Rows = Rows + clearedLines;
                break;
            case 4:
                Points = Points + ((Level + 1) * 1200);
                Rows = Rows + clearedLines;
                break;
            default:
        }
    }

    public int getLevel() {
        return Level;
    }

    public int getPoints() {
        return Points;
    }

    public int getRows() {
        return Rows;
    }
}

