package collision;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

import geometry.Point;

/**
 * A collision.Velocity.
 * The class describe a collision.Velocity object and its operations - getDx, getDy,
 * applyToPoint and fromAngleAndSpeed.
 * collision.Velocity specifies the change in position on the `x` and the `y` axes.
 * It is implemented using two doubles- xd and yd.
 */
public class Velocity {
    //fields
    private double dx;
    private double dy;

    /**
     * create a collision.Velocity with the specified doubles.
     * @param dx the x value of the collision.Velocity
     * @param dy the y value of the collision.Velocity
     */
    // constructors
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * create a collision.Velocity with the specified doubles.
     * @param angle the angle of the collision.Velocity
     * @param speed the speed of the collision.Velocity
     * @return the new velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = angle;
        double dy = speed;
        return new Velocity(dx, dy);
    }

    /**
     * gets the dx value of the collision.Velocity.
     * @return double representing the dx value of the collision.Velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * gets the dy value of the collision.Velocity.
     * @return double representing the dy value of the collision.Velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Take a point with position (x,y) and return a new point
     * with position (x+dx, y+dy).
     * @param p the point the we change its velocity.
     * @return double representing the dy value of the collision.Velocity.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
        //return new geometry.Point(p.getX() + 2 * this.dx, p.getY() + 2 * this.dy);
    }
}