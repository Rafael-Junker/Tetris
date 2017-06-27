package de.Junker.Tetris;


public abstract class Tetromino {
    //Shape of the Tetromino in all rotationstates as array
    protected Block[][] blocks;
    //currently active rotation of tetromino
    private int rotationstate;

    //gets the current block positions of the Tetromino
    public Block[] getBlocks() {
        return blocks[rotationstate];
    }

    //moves the Tetromino down if possible
    public boolean moveDown(Block[][] gameField) {
        boolean valid = true;
        try {
            for (Block b : blocks[rotationstate]
                    ) {
                if (gameField[b.getX()][b.getY() + 1] != null) {
                    valid = false;
                }
            }

        } catch (Exception e) {
            valid = false;
        }
        if (valid) {
            for (Block[] t : blocks
                    ) {
                for (Block b : t
                        ) {
                    b.setY(b.getY() + 1);
                }
            }
        }
        return valid;
    }

    //moves the Tetromino Left if possible
    public boolean moveLeft(Block[][] gameField) {
        boolean valid = true;
        try {
            for (Block b : blocks[rotationstate]
                    ) {
                if (gameField[b.getX() - 1][b.getY()] != null) {
                    valid = false;
                }
            }

        } catch (Exception e) {
            valid = false;
        }

        if (valid) {
            for (Block[] t : blocks
                    ) {
                for (Block b : t
                        ) {
                    b.setX(b.getX() - 1);
                }
            }
        }
        return valid;
    }

    //moves the Tetromino Right if possible
    public boolean moveRight(Block[][] gameField) {
        boolean valid = true;
        try {
            for (Block b : blocks[rotationstate]
                    ) {
                if (gameField[b.getX() + 1][b.getY()] != null) {
                    valid = false;
                }
            }

        } catch (Exception e) {
            valid = false;
        }
        if (valid) {
            for (Block[] t : blocks
                    ) {
                for (Block b : t
                        ) {
                    b.setX(b.getX() + 1);
                }
            }
        }
            return valid;
    }

    //Rotates the Tetromino Counterclockise if possible
    public boolean rotateCounterClockwise(Block[][] GameField) {
        boolean valid = true;
        try {
            if (rotationstate-1 == -1) {
                for (Block block : blocks[3]) {
                    if (GameField[block.getX()][block.getY()] != null) {
                        valid = false;
                    }
                }
            }
            else {
                for (Block block : blocks[rotationstate-1]) {
                    if (GameField[block.getX()][block.getY()] != null) {
                        valid = false;
                    }
                }
            }
        }
        catch (Exception e) {
            valid = false;
        }
        if (valid) {
            if (rotationstate - 1 == -1) {
                rotationstate = 3;
            } else {
                rotationstate = (rotationstate - 1);
            }
        }
        return valid;
    }

    //Rotates the Tetromino clockwise if possible
    public boolean rotateClockwise(Block[][] gameField) {
        boolean valid = true;
        try {
            for (Block block : blocks[(rotationstate+1) %4]) {
                if (gameField[block.getX()][block.getY()] != null) {
                    valid = false;
                }
            }
        }
        catch (Exception e) {
            valid = false;
        }
        if (valid) {
            rotationstate = (rotationstate + 1) % 4;
        }
        return valid;
    }
}
