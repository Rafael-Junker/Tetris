package de.Junker.Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.awt.Color.black;
import static java.awt.Color.white;


public class SpielFenster extends Frame {
    private JLabel Punktzahl;
    private JLabel Level;
    private JLabel Reihen;
    private Spielfeld spielfeld;
    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            //NOOP
        }


        @Override
        public void keyPressed(KeyEvent keyEvent) {
            System.out.println(keyEvent.getKeyCode());
            switch (keyEvent.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    spielfeld.moveLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    spielfeld.moveRight();
                    break;
                case KeyEvent.VK_UP:
                    spielfeld.hardDrop();
                    break;
                case KeyEvent.VK_DOWN:
                    spielfeld.softDrop();
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            //NOOP
        }
    };


    public SpielFenster() {
        super("Tetris");
        spielfeld = new Spielfeld(10, 40);
        Punktzahl = new JLabel("Punkte:");
        Level = new JLabel("Level:");
        Reihen = new JLabel("Reihen:");
        Punktzahl.setForeground(white);
        Level.setForeground(white);
        Reihen.setForeground(white);
        this.setResizable(false);
        Punktzahl.setBounds(50, 55, 100, 10);
        Level.setBounds(50, 75, 100, 10);
        Reihen.setBounds(50, 95, 100, 10);
        this.add(Punktzahl);
        this.add(Level);
        this.add(Reihen);
        //Leeres Label weil das letzte aus irgendeinem grund nicht die gewünschte position annimmt
        this.add(new JLabel(""));
        this.addKeyListener(keyListener);
        spielfeld = new Spielfeld(10, 20);
        this.setBackground(black);
        spielfeld.setGraphics(this.getGraphics());
        this.setSize(450, 560);
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void Start() {
        this.setVisible(true);
    }


}
