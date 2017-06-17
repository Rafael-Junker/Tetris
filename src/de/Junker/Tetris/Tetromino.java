package de.Junker.Tetris;


public abstract class Tetromino {

    protected Block[][] blocks;

    private int rotationstate;

    public Block[] getBlocks() {
        return blocks[rotationstate];
    }

    public boolean moveDown() {
        try {
            for (Block[] t : blocks
                    ) {
                for (Block b : t
                        ) {
                    b.setY(b.getY() + 1);
                }
            }

        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }


    public boolean canMoveDown(Block[][] spielfeld) {
        boolean returnvalue = true;
        try {
            for (Block b : blocks[rotationstate]
                    ) {
                if (spielfeld[b.getX()][b.getY() + 1] != null) {
                    returnvalue = false;
                }
            }

        } catch (Exception e) {
            returnvalue = false;
        }

        return returnvalue;
    }

    public boolean moveLeft() {
        try {
            for (Block[] t : blocks
                    ) {
                for (Block b : t
                        ) {
                    b.setX(b.getX() - 1);
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean moveRight() {
        try {
            for (Block[] t : blocks
                    ) {
                for (Block b : t
                        ) {
                    b.setX(b.getX() + 1);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean canMoveLeft(Block[][] spielfeld) {
        boolean returnvalue = true;
        try {
            for (Block b : blocks[rotationstate]
                    ) {
                if (spielfeld[b.getX() - 1][b.getY()] != null) {
                    returnvalue = false;
                }
            }

        } catch (Exception e) {
            returnvalue = false;
        }

        return returnvalue;
    }


    public boolean canMoveRight(Block[][] spielfeld) {
        boolean returnvalue = true;
        try {
            for (Block b : blocks[rotationstate]
                    ) {
                if (spielfeld[b.getX() + 1][b.getY()] != null) {
                    returnvalue = false;
                }
            }

        } catch (Exception e) {
            returnvalue = false;
        }

        return returnvalue;
    }

    public void rotateCounterClockwise() {
        if (rotationstate - 1 == -1) {
            rotationstate = 3;
        } else {
            rotationstate = (rotationstate - 1) % 4;
        }
    }

    public void rotateClockwise() {
        rotationstate = (rotationstate + 1) % 4;
    }
}
