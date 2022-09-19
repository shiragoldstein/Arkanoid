package level;

import collision.Velocity;
import geometry.Point;
import geometry.Rectangle;
import sprites.Block;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A DirectHit.
 * The class describe a DirectHit level and its operations -
 * numberOfBalls, paddleSpeed, paddleWidth, initialBallVelocities, levelName,
 * getBackground, blocks, numberOfBlocksToRemove, getIsLast and setLast.
 */
public class FinalFour implements LevelInformation {

    private boolean isLast = false;

    /**
     * @return the number of balls in the level
     */
    public int numberOfBalls() {
        return 3;
    }

    /**
     * The initial velocity of each ball.
     * @return ArrayList<Velocity> the velocities of the balls in the level
     */
    public ArrayList<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(4, -4));
        velocities.add(new Velocity(-4, -4));
        velocities.add(new Velocity(0, -4));
        return velocities;
    }

    /**
     * @return the speed of the paddle in the level
     */
    public int paddleSpeed() {
        return 0;
    }

    /**
     * @return the width of the paddle in the level
     */
    public int paddleWidth() {
        return 70;
    }


    /**
     * @return the name of the level
     */
    public String levelName() {
        return "Final Four";
    }

    /**
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        return new FinalFourBackground();
    }

    /**
     * @return The Blocks that make up this level, each block contains
     *     its size, color and location.
     */
    public ArrayList<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            blocks.add(new Block(new Rectangle(new Point(712 - (i * 48), 120), 48, 25), Color.gray));
            blocks.add(new Block(new Rectangle(new Point(712 - (i * 48), 145), 48, 25), Color.red));
            blocks.add(new Block(new Rectangle(new Point(712 - (i * 48), 170), 48, 25), Color.yellow));
            blocks.add(new Block(new Rectangle(new Point(712 - (i * 48), 195), 48, 25), Color.green));
            blocks.add(new Block(new Rectangle(new Point(712 - (i * 48), 220), 48, 25), Color.white));
            blocks.add(new Block(new Rectangle(new Point(712 - (i * 48), 245), 48, 25), Color.pink));
            blocks.add(new Block(new Rectangle(new Point(712 - (i * 48), 270), 48, 25), Color.cyan));
        }
        return blocks;
    }

    /**
     * @return The Number of blocks that should be removed from the level
     */
    public int numberOfBlocksToRemove() {
        return 105;
    }

    /**
     * @return true if this level is the last one in the game
     * else return false
     */
    public boolean getIsLast() {
        return this.isLast;
    }

    /**
     * set if the level is the last one or not.
     * @param b the true or false
     */
    public void setLast(boolean b) {
        this.isLast = b;
    }
}
