package de.Junker.Tetris.Tetrominos;


import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_I extends Tetromino {

    Block[] blocks = {
            new Block(Colors.Light_blue, 3, 0),
            new Block(Colors.Light_blue, 4, 0),
            new Block(Colors.Light_blue, 5, 0),
            new Block(Colors.Light_blue, 6, 0)};

    public Tetromino_I() {

    }

    @Override
    public Block[] getBlocks() {
        return blocks;
    }
}
