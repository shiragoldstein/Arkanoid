package level;

import collision.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.util.ArrayList;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */
/**
 * A LevelInformation interface.
 * The interface describe an LevelInformation interface and its operation -
 * numberOfBalls, paddleSpeed, paddleWidth, initialBallVelocities, levelName,
 * getBackground, blocks, numberOfBlocksToRemove, getIsLast and setLast.
 */
public interface LevelInformation {

    /**
     * @return the number of balls in the level
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     * @return ArrayList<Velocity> the velocities of the balls in the level
     */
    ArrayList<Velocity> initialBallVelocities();
    /**
     * @return the speed of the paddle in the level
     */
    int paddleSpeed();
    /**
     * @return the width of the paddle in the level
     */
    int paddleWidth();
    /**
     * @return the name of the level
     */
    String levelName();
    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();
    /**
     * @return The Blocks that make up this level, each block contains
     *     its size, color and location.
     */
    ArrayList<Block> blocks();

    /**
     * @return The Number of blocks that should be removed from the level
     */
    int numberOfBlocksToRemove();

    /**
     * @return true if this level is the last one in the game
     * else return false
     */
    boolean getIsLast();
    /**
     * set if the level is the last one or not.
     * @param b the true or false
     */
    void setLast(boolean b);
}
