package de.Junker.Tetris.Tetrominos;

import de.Junker.Tetris.Block;
import de.Junker.Tetris.Colors;
import de.Junker.Tetris.Tetromino;

public class Tetromino_S extends Tetromino {


    public Tetromino_S() {
        //initializes the shape for all rotationstates of the tetromino
        blocks = new Block[][]{
                {
                        new Block(Colors.Light_green, 4, 0),
                        new Block(Colors.Light_green, 5, 0),
                        new Block(Colors.Light_green, 3, 1),
                        new Block(Colors.Light_green, 4, 1)
                },
                {
                        new Block(Colors.Light_green, 4, 0),
                        new Block(Colors.Light_green, 4, 1),
                        new Block(Colors.Light_green, 5, 1),
                        new Block(Colors.Light_green, 5, 2)
                },
                {
                        new Block(Colors.Light_green, 4, 1),
                        new Block(Colors.Light_green, 5, 1),
                        new Block(Colors.Light_green, 3, 2),
                        new Block(Colors.Light_green, 4, 2)
                },
                {
                        new Block(Colors.Light_green, 3, 0),
                        new Block(Colors.Light_green, 3, 1),
                        new Block(Colors.Light_green, 4, 1),
                        new Block(Colors.Light_green, 4, 2)
                },
        };
    }

}
