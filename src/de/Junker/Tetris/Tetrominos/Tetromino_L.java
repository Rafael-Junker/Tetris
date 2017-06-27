package de.Junker.Tetris.Tetrominos;

import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_L extends Tetromino {

    public Tetromino_L() {
        //initializes the shape for all rotationstates of the tetromino
        blocks = new Block[][]{
                {
                        new Block(Colors.Orange, 5, 0),
                        new Block(Colors.Orange, 3, 1),
                        new Block(Colors.Orange, 4, 1),
                        new Block(Colors.Orange, 5, 1)
                },
                {
                        new Block(Colors.Orange, 4, 0),
                        new Block(Colors.Orange, 4, 1),
                        new Block(Colors.Orange, 4, 2),
                        new Block(Colors.Orange, 5, 2)
                },
                {
                        new Block(Colors.Orange, 3, 2),
                        new Block(Colors.Orange, 4, 1),
                        new Block(Colors.Orange, 5, 1),
                        new Block(Colors.Orange, 3, 1)
                },
                {
                        new Block(Colors.Orange, 3, 0),
                        new Block(Colors.Orange, 4, 0),
                        new Block(Colors.Orange, 4, 1),
                        new Block(Colors.Orange, 4, 2)
                }
        };
    }


}
