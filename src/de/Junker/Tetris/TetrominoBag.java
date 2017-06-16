package de.Junker.Tetris;

import de.Junker.Tetris.Tetrominos.*;

import java.util.ArrayList;

public class TetrominoBag {
    private ArrayList<Tetromino> bag = new ArrayList<Tetromino>();
    private int current_slot = 0;

    public TetrominoBag() {

    }

    public Tetromino getNext() {
        Tetromino returnValue = null;
        try {
            bag.get(current_slot);
        } catch (IndexOutOfBoundsException e) {
            bag.clear();
            current_slot = 0;
            refill();
            //Collections.shuffle(bag);
            getNext();
        }
        returnValue = bag.get(current_slot);
        current_slot++;
        return returnValue;
    }

    public void refill() {
        bag.add(new Tetromino_L());
        bag.add(new Tetromino_J());
        bag.add(new Tetromino_I());
        bag.add(new Tetromino_O());
        bag.add(new Tetromino_S());
        bag.add(new Tetromino_Z());
        bag.add(new Tetromino_T());
    }
}
