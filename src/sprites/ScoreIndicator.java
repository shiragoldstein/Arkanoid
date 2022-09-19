package sprites;


import biuoop.DrawSurface;
import game.Counter;

import java.awt.Color;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

/**
 * A ScoreIndicator.
 * The class describe a ScoreIndicator object and its operations -
 * drawOn and timePassed.
 * It is implemented using a Counter.
 */
public class ScoreIndicator implements Sprite {
    //fields
    private Counter remainingScore;

    /**
     * create a ScoreIndicator with the specified Counter.
     * @param scoreCounter the number of the current score
     */
    //constructor
    public ScoreIndicator(Counter scoreCounter) {
        this.remainingScore = scoreCounter;
    }

    /**
     * draw the ScoreIndicator on the given DrawSurface.
     * @param d the surface that we want to draw the ScoreIndicator on
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.BLACK);
        d.drawRectangle(0, 0, 800, 20);
        d.drawText(385, 15, "Score:" + this.remainingScore.getValue(), 13);
    }

    /**
     * the time passed method without usage.
     */
    public void timePassed() { }
}
