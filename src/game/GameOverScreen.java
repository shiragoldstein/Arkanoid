package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A GameOverScreen.
 * The class describe a GameOverScreen and its operations -
 * doOneFrame and shouldStop.
 * It is implemented using a KeyboardSensor, boolean and int.
 */
public class GameOverScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private int finalScore;
    //private Animation animation;

    /**
     * create a GameOverScreen with the specified KeyboardSensor and int.
     * @param k the KeyboardSensor
     * @param score the score
     */
    public GameOverScreen(KeyboardSensor k, int score /*Animation animation*/) {
        this.keyboard = k;
        this.stop = false;
        this.finalScore = score;
        //this.animation = animation;
    }
    /**
     * make one frame of the animation.
     * @param d the DrawSurface of the animation game
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.black);
        d.drawText(350, 300, "Game Over", 35);
        d.drawText(300, 400, "Final Score: " + this.finalScore, 35);
        d.drawText(50, 550, "Press Space To Continue", 25);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
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
