package collision;


/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


import geometry.Point;

/**
 * A collision.CollisionInfo.
 * The class describe a collision.CollisionInfo and its operations -
 * collisionPoint and collisionObject.
 * It is implemented using a point who present the collision point,
 * and a collidable that present the collisionObject.
 */
public class CollisionInfo {
    //fields
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * create a collision.CollisionInfo with the specified geometry.Point and collision.Collidable.
     * @param collisionPoint the collision geometry.Point
     * @param collisionObject the collision Object
     */
    //constructor
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * get the point at which the collision occurs.
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * get the collidable object that involved in the collision.
     * @return the collision.Collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
