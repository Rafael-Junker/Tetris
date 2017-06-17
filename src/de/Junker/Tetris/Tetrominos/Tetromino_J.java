package de.Junker.Tetris.Tetrominos;


import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_J extends Tetromino {


    public Tetromino_J() {
        blocks = new Block[][]{
                {
                        new Block(Colors.Dark_blue, 3, 0),
                        new Block(Colors.Dark_blue, 3, 1),
                        new Block(Colors.Dark_blue, 4, 1),
                        new Block(Colors.Dark_blue, 5, 1)
                },
                {
                        new Block(Colors.Dark_blue, 4, 0),
                        new Block(Colors.Dark_blue, 5, 0),
                        new Block(Colors.Dark_blue, 4, 1),
                        new Block(Colors.Dark_blue, 4, 2)
                },
                {
                        new Block(Colors.Dark_blue, 5, 2),
                        new Block(Colors.Dark_blue, 3, 1),
                        new Block(Colors.Dark_blue, 4, 1),
                        new Block(Colors.Dark_blue, 5, 1)
                },
                {
                        new Block(Colors.Dark_blue, 4, 0),
                        new Block(Colors.Dark_blue, 3, 2),
                        new Block(Colors.Dark_blue, 4, 1),
                        new Block(Colors.Dark_blue, 4, 2)
                }
        };

    }
}
