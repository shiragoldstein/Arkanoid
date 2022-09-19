package game;

import biuoop.DrawSurface;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */
/**
 * A Animation interface.
 * The interface describe an Animation interface and its operation -
 * doOneFrame and shouldStop.
 */
public interface Animation {
    /**
     * make one frame of the animation.
     * @param d the DrawSurface of the animation game
     */
    void doOneFrame(DrawSurface d);
    /**
     * @return true if the animation should stop,
     * else return false
     */
    boolean shouldStop();
}
