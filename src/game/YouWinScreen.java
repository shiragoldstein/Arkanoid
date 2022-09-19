package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

import static biuoop.KeyboardSensor.SPACE_KEY;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A YouWinScreen.
 * The class describe a YouWinScreen and its operations -
 * doOneFrame and shouldStop.
 * It is implemented using a KeyboardSensor, boolean and int.
 */
public class YouWinScreen implements Animation {
    //fields
    private KeyboardSensor keyboard;
    private boolean stop;
    private int finalScore;

    //constructor
    /**
     * create a YouWinScreen with the specified KeyboardSensor and int.
     * @param k the KeyboardSensor
     * @param score the score
     */
    public YouWinScreen(KeyboardSensor k, int score) {
        this.keyboard = k;
        this.stop = false;
        this.finalScore = score;
    }

    /**
     * make one frame of the animation.
     * @param d the DrawSurface of the animation game
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawText(400, 300, "You Win! Final score: " + this.finalScore, 35);
        d.drawText(300, 400, "Final Score: " + this.finalScore, 35);
        d.drawText(50, 550, "Press Space To Continue", 25);
        if (this.keyboard.isPressed(SPACE_KEY)) {
            this.stop = true;
        }
    }
    /**
     * @return true if the animation should stop,
     * else return false
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
