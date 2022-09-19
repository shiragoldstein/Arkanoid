package listener;


import game.Counter;
import game.GameLevel;
import sprites.Ball;
import sprites.Block;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

/**
 * A BallRemover.
 * The class describe a BallRemover object and its operation -
 * hitEvent.
 * a BlockRemover is in charge of removing balls from the game, as well as keeping count
 * of the number of balls that remain.
 * It is implemented using a Game and a Counter.
 */
public class BallRemover implements HitListener {
    //fields
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * create a BallRemover with the specified Game and Counter.
     * @param game the game
     * @param removedBalls the number of the removed balls
     */
    //constructor
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * hitEvent is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the object that being hit
     * @param hitter the hitter ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        //remove the hitter ball from the game
        hitter.removeFromGame(this.game);
        //remove the listener
        hitter.removeHitListener(this);
        //decrease 1 from the counter
        this.remainingBalls.decrease(1);
    }
}
