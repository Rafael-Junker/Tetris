package de.Junker.Tetris;

import de.Junker.Tetris.Tetrominos.*;

import java.util.ArrayList;
import java.util.Collections;

public class TetrominoBag {
    private ArrayList<Tetromino> bag = new ArrayList<>();
    private int current_slot = 0;

    public TetrominoBag() {
        bag.add(new Tetromino_I());
        bag.add(new Tetromino_L());
        bag.add(new Tetromino_J());
        bag.add(new Tetromino_O());
        bag.add(new Tetromino_S());
        bag.add(new Tetromino_Z());
        bag.add(new Tetromino_T());
    }

    public Tetromino getNext() {
        Tetromino returnValue;
        returnValue = bag.get(current_slot);
        if (current_slot == 6) {
            current_slot = 0;
            Collections.shuffle(bag);
        } else {
            current_slot++;
        }
        return returnValue;
    }
}
