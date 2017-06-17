package de.Junker.Tetris.Tetrominos;

import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_Z extends Tetromino {


    public Tetromino_Z() {
        blocks = new Block[][]{
                {
                        new Block(Colors.Red, 3, 0),
                        new Block(Colors.Red, 4, 0),
                        new Block(Colors.Red, 4, 1),
                        new Block(Colors.Red, 5, 1)
                },
                {
                        new Block(Colors.Red, 5, 0),
                        new Block(Colors.Red, 4, 1),
                        new Block(Colors.Red, 5, 1),
                        new Block(Colors.Red, 4, 2)
                },
                {
                        new Block(Colors.Red, 3, 1),
                        new Block(Colors.Red, 4, 1),
                        new Block(Colors.Red, 4, 2),
                        new Block(Colors.Red, 5, 2)
                },
                {
                        new Block(Colors.Red, 4, 0),
                        new Block(Colors.Red, 3, 1),
                        new Block(Colors.Red, 4, 1),
                        new Block(Colors.Red, 3, 2)
                },

        };
    }

}
