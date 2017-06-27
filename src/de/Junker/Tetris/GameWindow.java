package de.Junker.Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends Frame {

    private final int hardDrop = KeyEvent.VK_UP;
    private final int softDrop = KeyEvent.VK_DOWN;
    private final int moveLeft = KeyEvent.VK_LEFT;
    private final int moveRight = KeyEvent.VK_RIGHT;
    private final int rotateClockwise = KeyEvent.VK_D;
    private final int rotateCounterClockwise = KeyEvent.VK_A;
    private final int startGame = KeyEvent.VK_ENTER;
    private JLabel Points;
    private JLabel Level;
    private JLabel Rows;
    private GameField gamefield;
    KeyListener keyListener = new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch (keyEvent.getKeyCode()) {
                case moveLeft:
                    gamefield.moveLeft();
                    break;
                case moveRight:
                    gamefield.moveRight();
                    break;
                case hardDrop:
                    gamefield.hardDrop();
                    break;
                case softDrop:
                    gamefield.softDrop();
                    break;
                case startGame:
                    gamefield.Enter();
                    break;
                case rotateClockwise:
                    gamefield.rotateClockwise();
                    break;
                case rotateCounterClockwise:
                    gamefield.rotateCounterclockwise();
                    break;
            }

        }
    };
    private int Height = 560;
    private int Width = 450;
    private Color background_color = Color.black;
    private Color font_color = Color.white;


    public GameWindow() {
        //Call to super to set Window Name
        super("Tetris");
        //Adding of Text Labels
        Points = new JLabel("Punkte:");
        Level = new JLabel("Level:");
        Rows = new JLabel("Reihen:");
        //Setting the font color
        Points.setForeground(font_color);
        Level.setForeground(font_color);
        Rows.setForeground(font_color);
        //Disable resizing
        this.setResizable(false);
        //Setiing the possition of the Labels
        Points.setBounds(300, 250, 100, 10);
        Level.setBounds(300, 275, 100, 10);
        Rows.setBounds(300, 300, 100, 10);
        //Adding the labels to the frame
        this.add(Points);
        this.add(Level);
        this.add(Rows);
        //empty label because the last label doesn't take any position
        this.add(new JLabel(""));
        //Add the key Listener to the frame
        this.addKeyListener(keyListener);
        //initialize the playing field
        gamefield = new GameField();
        //set the background color color to
        this.setBackground(background_color);
        //set the size of the window
        this.setSize(Width, Height);
        //center the window
        this.setLocationRelativeTo(null);
        //Update Labels on the screen
        Timer updateTimer = new Timer(100, e -> {
            Points.setText("Punkte: " + gamefield.getPoints());
            Level.setText("Level: " + gamefield.getLevel());
            Rows.setText("Reihen: " + gamefield.getRows());
        });
        updateTimer.start();
        //close function if close symbol i clicked
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void Start() {
        //draw the frame
        this.setVisible(true);
        //pass the graphics of the frame to the playfield for modification
        gamefield.setGraphics(this.getGraphics());

    }
}
