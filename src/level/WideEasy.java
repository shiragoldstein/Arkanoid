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
 * A WideEasy.
 * The class describe a WideEasy level and its operations -
 * numberOfBalls, paddleSpeed, paddleWidth, initialBallVelocities, levelName,
 * getBackground, blocks, numberOfBlocksToRemove, getIsLast and setLast.
 */
public class WideEasy implements LevelInformation {

    private boolean isLast = false;

    /**
     * @return the number of balls in the level
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * The initial velocity of each ball.
     * @return ArrayList<Velocity> the velocities of the balls in the level
     */
    public ArrayList<Velocity> initialBallVelocities() {
        ArrayList<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            velocities.add(new Velocity(-3, -2 * (i + 1)));
        }
        for (int i = 4; i >= 0; i--) {
            velocities.add(new Velocity(3, -2 * (i + 1)));
        }
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
        return 590;
    }


    /**
     * @return the name of the level
     */
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        return new WideEasyBackground();
    }

    /**
     * @return The Blocks that make up this level, each block contains
     *     its size, color and location.
     */
    public ArrayList<Block> blocks() {
        ArrayList<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            blocks.add(new Block(new Rectangle(new Point(40 + (i * 48), 250), 48, 25), Color.red));
            blocks.add(new Block(new Rectangle(new Point(136 + (i * 48), 250), 48, 25), Color.orange));
            blocks.add(new Block(new Rectangle(new Point(232 + (i * 48), 250), 48, 25), Color.yellow));
            blocks.add(new Block(new Rectangle(new Point(328 + (i * 48), 250), 48, 25), Color.green));
            blocks.add(new Block(new Rectangle(new Point(472 + (i * 48), 250), 48, 25), Color.blue));
            blocks.add(new Block(new Rectangle(new Point(568 + (i * 48), 250), 48, 25), Color.pink));
            blocks.add(new Block(new Rectangle(new Point(664 + (i * 48), 250), 48, 25), Color.cyan));
        }
        blocks.add(new Block(new Rectangle(new Point(424, 250), 48, 25), Color.green));
        return blocks;
    }

    /**
     * @return The Number of blocks that should be removed from the level
     */
    public int numberOfBlocksToRemove() {
        return 15;
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
