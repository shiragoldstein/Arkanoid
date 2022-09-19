package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A PauseScreen.
 * The class describe a PauseScreen and its operations -
 * doOneFrame and shouldStop.
 * It is implemented using a KeyboardSensor, boolean.
 */
public class PauseScreen implements Animation {
    //fields
    private KeyboardSensor keyboard;
    private boolean stop;

    //constructor
    /**
     * create a PauseScreen with the specified KeyboardSensor.
     * @param k the KeyboardSensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    /**
     * make one frame of the animation.
     * @param d the DrawSurface of the animation game
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
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
