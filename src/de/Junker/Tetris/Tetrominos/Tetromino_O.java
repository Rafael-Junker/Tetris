package de.Junker.Tetris.Tetrominos;

import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_O extends Tetromino {


    public Tetromino_O() {

        blocks = new Block[]{
                new Block(Colors.Yellow, 4, 0),
                new Block(Colors.Yellow, 4, 1),
                new Block(Colors.Yellow, 5, 0),
                new Block(Colors.Yellow, 5, 1)};
    }



}
