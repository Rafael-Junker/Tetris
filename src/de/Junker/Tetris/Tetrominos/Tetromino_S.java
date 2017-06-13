package de.Junker.Tetris.Tetrominos;

import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_S extends Tetromino {

    Block[] blocks = {
            new Block(Colors.Light_green, 4, 0),
            new Block(Colors.Light_green, 5, 0),
            new Block(Colors.Light_green, 3, 1),
            new Block(Colors.Light_green, 4, 1)};

    public Tetromino_S() {

    }

    @Override
    public Block[] getBlocks() {
        return blocks;
    }
}
