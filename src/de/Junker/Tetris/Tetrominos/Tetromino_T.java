package de.Junker.Tetris.Tetrominos;

import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_T extends Tetromino {
    Block[] blocks = {
            new Block(Colors.Purple, 4, 0),
            new Block(Colors.Purple, 3, 1),
            new Block(Colors.Purple, 4, 1),
            new Block(Colors.Purple, 5, 1)};
    public Tetromino_T() {

    }

    @Override
    public Block[] getBlocks() {
        return blocks;
    }
}
