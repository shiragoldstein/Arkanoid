package listener;

import sprites.Ball;
import sprites.Block;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */
/**
 * A HitListener interface.
 * The interface describe a HitListener interface and its operation -
 * hitEvent.
 */
public interface HitListener {
    /**
     * hitEvent is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the object that being hit
     * @param hitter the hitter ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}
