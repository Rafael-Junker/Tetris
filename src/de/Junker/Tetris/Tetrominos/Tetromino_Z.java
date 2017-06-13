package de.Junker.Tetris.Tetrominos;

import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_Z extends Tetromino {

    Block[] blocks = {
            new Block(Colors.Red, 3, 0),
            new Block(Colors.Red, 4, 0),
            new Block(Colors.Red, 4, 1),
            new Block(Colors.Red, 5, 1)};

    public Tetromino_Z() {

    }

    @Override
    public Block[] getBlocks() {
        return blocks;
    }
}
