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
 * A BlockRemover.
 * The class describe a BlockRemover object and its operation -
 * hitEvent.
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 * It is implemented using a Game and a Counter.
 */
public class BlockRemover implements HitListener {
    //fields
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * create a BlockRemover with the specified Game and Counter.
     * @param game the game
     * @param removedBlocks the number of the removed blocks
     */
    //constructor
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * hitEvent is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit the object that being hit
     * @param hitter the hitter ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        //remove the being hit from the game
        beingHit.removeFromGame(this.game);
        //remove the listener
        beingHit.removeHitListener(this);
        //decrease 1 from the counter
        this.remainingBlocks.decrease(1);
    }
}
