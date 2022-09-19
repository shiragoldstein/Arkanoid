package game;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
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
public /*abstract*/ class KeyPressStoppableAnimation implements Animation {
    //fields
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;

    //constructor
    /**
     * create a KeyPressStoppableAnimation with the specified KeyboardSensor, String and Animation.
     * @param sensor the KeyboardSensor
     * @param key the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
    }

    /**
     * make one frame of the animation.
     * @param d the DrawSurface of the animation game
     */
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
    }

    /**
     * @return true if the animation should stop,
     * else return false
     */
    public boolean shouldStop() {
        //return this.animation.shouldStop();
        if (this.sensor.isPressed(this.key)) {
            return true;
        }
        return false;
    }
}
