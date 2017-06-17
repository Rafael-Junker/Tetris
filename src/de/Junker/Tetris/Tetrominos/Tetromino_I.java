package de.Junker.Tetris.Tetrominos;


import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_I extends Tetromino {



    public Tetromino_I() {
        blocks = new Block[][]{
                {
                        new Block(Colors.Light_blue, 3, 1),
                        new Block(Colors.Light_blue, 4, 1),
                        new Block(Colors.Light_blue, 5, 1),
                        new Block(Colors.Light_blue, 6, 1)
                },
                {
                        new Block(Colors.Light_blue, 4, 0),
                        new Block(Colors.Light_blue, 4, 1),
                        new Block(Colors.Light_blue, 4, 2),
                        new Block(Colors.Light_blue, 4, 3)
                },
                {
                        new Block(Colors.Light_blue, 3, 0),
                        new Block(Colors.Light_blue, 4, 0),
                        new Block(Colors.Light_blue, 5, 0),
                        new Block(Colors.Light_blue, 6, 0)
                },
                {
                        new Block(Colors.Light_blue, 3, 0),
                        new Block(Colors.Light_blue, 3, 1),
                        new Block(Colors.Light_blue, 3, 2),
                        new Block(Colors.Light_blue, 3, 3)
                }

        };
    }
    }

