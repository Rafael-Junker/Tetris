package de.Junker.Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpielFenster extends Frame {

    private final int hardDrop = KeyEvent.VK_UP;
    private final int softDrop = KeyEvent.VK_DOWN;
    private final int moveLeft = KeyEvent.VK_LEFT;
    private final int moveRight = KeyEvent.VK_RIGHT;
    private final int rotateClockwise = KeyEvent.VK_D;
    private final int rotateCounterClockwise = KeyEvent.VK_A;
    private final int startGame = KeyEvent.VK_ENTER;
    private final int pauseGame = KeyEvent.VK_SPACE;
    private JLabel Punktzahl;
    private JLabel Level;
    private JLabel Reihen;
    private Spielfeld spielfeld;
    KeyListener keyListener = new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch (keyEvent.getKeyCode()) {
                case moveLeft:
                    spielfeld.moveLeft();
                    break;
                case moveRight:
                    spielfeld.moveRight();
                    break;
                case hardDrop:
                    spielfeld.hardDrop();
                    break;
                case softDrop:
                    spielfeld.softDrop();
                    break;
                case startGame:
                    spielfeld.newGame();
                    break;
                case pauseGame:
                    spielfeld.pause();
                    break;
                case rotateClockwise:
                    spielfeld.rotateClockwise();
                    break;
                case rotateCounterClockwise:
                    spielfeld.rotateCounterclockwise();
                    break;
            }

        }
    };
    private int höhe = 560;
    private int breite = 450;
    private Color background_color = Color.black;
    private Color font_color = Color.white;


    public SpielFenster() {
        //Call to super to set Window Name
        super("Tetris");
        //Adding of Text Labels
        Punktzahl = new JLabel("Punkte:");
        Level = new JLabel("Level:");
        Reihen = new JLabel("Reihen:");
        //Setting the font color
        Punktzahl.setForeground(font_color);
        Level.setForeground(font_color);
        Reihen.setForeground(font_color);
        //Disable resizing
        this.setResizable(false);
        //Setiing the possition of the Labels
        Punktzahl.setBounds(300, 250, 100, 10);
        Level.setBounds(300, 275, 100, 10);
        Reihen.setBounds(300, 300, 100, 10);
        //Adding the labels to the frame
        this.add(Punktzahl);
        this.add(Level);
        this.add(Reihen);
        //empty label because the last label doesn't take any position
        this.add(new JLabel(""));
        //Add the key Listener to the frame
        this.addKeyListener(keyListener);
        //initialize the playing field
        spielfeld = new Spielfeld();
        //set the background color color to
        this.setBackground(background_color);
        //set the size of the window
        this.setSize(breite, höhe);
        //center the window
        this.setLocationRelativeTo(null);
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
        spielfeld.setGraphics(this.getGraphics());
    }
}
