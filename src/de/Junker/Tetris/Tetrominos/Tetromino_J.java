package de.Junker.Tetris.Tetrominos;


import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_J extends Tetromino {

    Block[] blocks = {
            new Block(Colors.Dark_blue, 3, 0),
            new Block(Colors.Dark_blue, 3, 1),
            new Block(Colors.Dark_blue, 4, 1),
            new Block(Colors.Dark_blue, 5, 1)};

    public Tetromino_J() {

    }

    @Override
    public Block[] getBlocks() {
        return blocks;
    }
}
