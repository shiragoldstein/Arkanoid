package listener;

import game.Counter;
import sprites.Ball;
import sprites.Block;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

/**
 * A ScoreTrackingListener.
 * The class describe a ScoreTrackingListener object and its operation -
 * hitEvent.
 * It is implemented using a Counter.
 */
public class ScoreTrackingListener implements HitListener {
    //fields
    private Counter currentScore;

    /**
     * create a ScoreTrackingListener with the specified Counter.
     * @param scoreCounter the number of the current score
     */
    //constructor
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * hitEvent is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the object that being hit
     * @param hitter the hitter ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        //remove the listener
        beingHit.removeHitListener(this);
        //add 5 to the score
        this.currentScore.increase(5);
    }
}
