package de.Junker.Tetris;

import com.sun.org.apache.regexp.internal.RE;

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
    public SpielFenster() {
        //TODO: Fenstername festlegen
        super("tetris");
        //TODO: Größe Festlegen
        this.setSize(768,512);
        //TODO: Spielfeld einfügen

        //TODO: Punktelabel
        Punktzahl = new JLabel("Punkte: 0");
        //TODO: Levellabel
        Level = new JLabel("Level: 1");
        //TODO: ReihenLabel
        Reihen = new JLabel("Reihen: 0");
        //TODO: Hold
        //TODO: Next
        //TODO: Highscore

        //TODO: Postionen festlegen
        Punktzahl.setLocation(100,100);
        Level.setLocation(100,200);
        Reihen.setLocation(100,300);

        //TODO: Komponenten hinzufügen
        this.add(Punktzahl);
        this.add(Level);
        this.add(Reihen);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }


    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            //NOOP
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch (keyEvent.getKeyCode()) {
                case 39:
                    break;
                    //TODO: get keycodes from config/link to functions
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            //NOOP
        }
    };

    //Funktion zum aufrufen des Spielfensters
    public void Start() {
        this.setVisible(true);
    }


}
