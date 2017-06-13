package de.Junker.Tetris.Tetrominos;

import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_L extends Tetromino {
    Block[] blocks = {
            new Block(Colors.Orange, 5, 0),
            new Block(Colors.Orange, 3, 1),
            new Block(Colors.Orange, 4, 1),
            new Block(Colors.Orange, 5, 1)};
    public Tetromino_L() {

    }

    @Override
    public Block[] getBlocks() {
        return blocks;
    }
}
