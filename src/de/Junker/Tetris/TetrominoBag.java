package de.Junker.Tetris;

import de.Junker.Tetris.Tetrominos.*;

import java.util.ArrayList;
import java.util.Collections;

public class TetrominoBag {
    private ArrayList<Tetromino> bag = new ArrayList<>();
    private int current_slot = 0;

    public TetrominoBag() {

    }

    //Gets the next tetromino in the queue
    //Creates a new bag if the new bag is used up
    public Tetromino getNext() {
        try {
            bag.get(current_slot);
        } catch (IndexOutOfBoundsException e) {
            bag.clear();
            current_slot = 0;
            refill();
            Collections.shuffle(bag);
            getNext();
        }
        Tetromino returnvalue = bag.get(current_slot);
        return returnvalue;
    }

    //adds one Tetromino of each type to the bag
    public void refill() {
        bag.add(new Tetromino_L());
        bag.add(new Tetromino_J());
        bag.add(new Tetromino_I());
        bag.add(new Tetromino_O());
        bag.add(new Tetromino_S());
        bag.add(new Tetromino_Z());
        bag.add(new Tetromino_T());
    }

    //increments the position of the bag
    public void increment() {
        current_slot++;
    }
}
