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
public class DirectHit implements LevelInformation {
    //fields
    private boolean isLast = false;

    /**
     * @return the number of balls in the level
     */
    public int numberOfBalls() {
        return 1;
    }

    /**
     * The initial velocity of each ball.
     * @return ArrayList<Velocity> the velocities of the balls in the level
     */
    public ArrayList<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(4, 4));
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
        return "Direct Hit";
    }

    /**
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        return new DirectHitBackground();
    }

    /**
     * @return The Blocks that make up this level, each block contains
     *     its size, color and location.
     */
    public ArrayList<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(385, 150), 30, 30), Color.red));
        return blocks;
    }

    /**
     * @return The Number of blocks that should be removed from the level
     */
    public int numberOfBlocksToRemove() {
        return 1;
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
