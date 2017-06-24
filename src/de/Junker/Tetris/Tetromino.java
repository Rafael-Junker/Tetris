package de.Junker.Tetris;


public abstract class Tetromino {

    protected Block[][] blocks;

    private int rotationstate;

    public Block[] getBlocks() {
        return blocks[rotationstate];
    }

    public boolean moveDown(Block[][] spielfeld) {
        boolean valid = true;
        try {
            for (Block b : blocks[rotationstate]
                    ) {
                if (spielfeld[b.getX()][b.getY() + 1] != null) {
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

    public boolean moveLeft(Block[][] spielfeld) {
        boolean valid = true;
        try {
            for (Block b : blocks[rotationstate]
                    ) {
                if (spielfeld[b.getX() - 1][b.getY()] != null) {
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

    public boolean moveRight(Block[][] spielfeld) {
        boolean valid = true;
        try {
            for (Block b : blocks[rotationstate]
                    ) {
                if (spielfeld[b.getX() + 1][b.getY()] != null) {
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


    public boolean rotateCounterClockwise(Block[][] spielfeld) {
        boolean valid = true;
        try {
            if (rotationstate-1 == -1) {
                for (Block block : blocks[3]) {
                    if (spielfeld[block.getX()][block.getY()] != null) {
                        valid = false;
                    }
                }
            }
            else {
                for (Block block : blocks[rotationstate-1]) {
                    if (spielfeld[block.getX()][block.getY()] != null) {
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

    public boolean rotateClockwise(Block[][] spielfeld) {
        boolean valid = true;
        try {
            for (Block block : blocks[(rotationstate+1) %4]) {
                if (spielfeld[block.getX()][block.getY()] != null) {
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
