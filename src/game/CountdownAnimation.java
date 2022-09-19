package game;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import level.LevelInformation;
import sprites.SpriteCollection;

import java.awt.Color;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A CountdownAnimation.
 * The class describe a CountdownAnimation and its operations -
 * doOneFrame and shouldStop.
 * It is implemented using a double, SpriteCollection, LevelInformation and int.
 */
public class CountdownAnimation implements Animation {
    //fields
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private LevelInformation level;

    //constructor
    /**
     * create a CountdownAnimation with the specified double, SpriteCollection, LevelInformation and int.
     * @param numOfSeconds the number of second
     * @param level the level
     * @param gameScreen the sprites
     * @param countFrom the number that we count from
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, LevelInformation level) {
        this.countFrom = countFrom;
        this.numOfSeconds = numOfSeconds;
        this.gameScreen = gameScreen;
        this.level = level;
    }

    /**
     * make one frame of the animation.
     * @param d the DrawSurface of the animation game
     */
    public void doOneFrame(DrawSurface d) {
        level.getBackground().drawOn(d);
        gameScreen.drawAllOn(d);
        d.setColor(Color.black);
        d.drawText(630, 15, "Level Name: " + level.levelName(), 13);
        Sleeper sleeper = new Sleeper();
        if (this.countFrom != 3) {
            sleeper.sleepFor(2000 / 3);
        }
        if (this.countFrom > 0) {
            d.setColor(Color.red);
            d.drawText((d.getWidth() / 2), (d.getHeight() / 2) + 20, String.valueOf(this.countFrom), 40);
        }
        this.countFrom = this.countFrom - 1;

    }

    /**
     * @return true if the animation should stop,
     * else return false
     */
    public boolean shouldStop() {
        if (this.countFrom == -1) {
            return true;
        }
        return false;
    }
}
