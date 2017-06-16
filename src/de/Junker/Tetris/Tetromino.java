package de.Junker.Tetris;


public class Tetromino {

    protected Block[] blocks;

    public Block[] getBlocks() {
        return blocks;
    }

    public boolean moveDown() {
        try {
            for (Block b : blocks
                    ) {
                b.setY(b.getY() + 1);
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }


    public boolean canMoveDown(Block[][] spielfeld) {
        boolean returnvalue = true;
        try {
            for (Block b : blocks
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
            for (Block b : blocks
                    ) {
                b.setX(b.getX() - 1);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean moveRight() {
        try {
            for (Block b : blocks
                    ) {
                b.setX(b.getX() + 1);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean canMoveLeft(Block[][] spielfeld) {
        boolean returnvalue = true;
        try {
            for (Block b : blocks
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
            for (Block b : blocks
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
}
