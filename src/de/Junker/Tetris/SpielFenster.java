package de.Junker.Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


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
                case 37:
                    spielfeld.moveLeft();
                    break;
                case 39:
                    spielfeld.moveRight();
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            //NOOP
        }
    };


    public SpielFenster() {
        super("Testris");
        this.setSize(768, 512);
        spielfeld = new Spielfeld(10, 40);
        Punktzahl = new JLabel("Punkte:");
        Level = new JLabel("Level:");
        Reihen = new JLabel("Reihen:");
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

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    //Funktion zum aufrufen des Spielfensters
    public void Start() {
        this.setVisible(true);
    }


}
