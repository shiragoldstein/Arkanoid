package collision;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

import geometry.Point;
import geometry.Rectangle;
import sprites.Ball;

/**
 * A collision.Collidable.
 * The interface describe a collision.Collidable object and its operations -
 * getCollisionRectangle and hit.
 */
public interface Collidable {
    /**
     * @return rectangle the the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();
    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint the collision geometry.Point that we check
     * @param currentVelocity the current collision.Velocity of the object
     * @param hitter the hitter ball
     * @return velocity the new velocity expected after the hit
     * based on the force the object inflicted on us.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
