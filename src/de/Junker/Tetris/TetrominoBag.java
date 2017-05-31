package de.Junker.Tetris;


public class TetrominoBag {
    private Tetromino[] bag = new Tetromino[6];
    private int current_slot;

    private void refill() {
        //TODO: Fülle den beutel mit allen Tetrominos und miche sie durch
    }

    public Tetromino getNext() {
        //TODO: Gibt den nächsten Tetromino zurück
        //TODO: ruft refill auf wenn der beutel leer ist
        return bag[current_slot];
    }

    private void shuffel() {
        //TODO: Mischt den beutel durch
    }
}
