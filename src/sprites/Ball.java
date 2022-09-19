// ID: 211398086
package sprites;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

import game.GameLevel;
import game.GameEnvironment;
import biuoop.DrawSurface;
import collision.Collidable;
import collision.Velocity;
import geometry.Line;
import geometry.Point;
import listener.HitListener;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A sprites.Ball.
 * The class describe a sprites.Ball object and its operations - getX, getY,
 * getSize, getColor, setMin, setMax, drawOn, setVelocity, getVelocity,
 * moveOneStep, isOnSideFrame and isOnTopFrame.
 * It is implemented using a geometry.Point, an int, a color and a velocity.
 */
public class Ball implements Sprite {
    //fields
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    //the size of the gui board
    private int min = 0;
    private int max = 600;
    private List<HitListener> hitListeners;

    private GameEnvironment gameEnvironment;
    /**
     * create a sprites.Ball with the specified point, int and color.
     * @param center the point
     * @param r the radius
     * @param color the color of the ball
     */
    // constructors
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.gameEnvironment = new GameEnvironment(new ArrayList<Collidable>());
        this.hitListeners = new ArrayList<>();
    }

    /**
     * create a sprites.Ball with the specified doubles, int and color.
     * @param x the x value of the center point
     * @param y the y value of the center point
     * @param r the radius
     * @param color the color of the ball
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.gameEnvironment = new GameEnvironment(new ArrayList<Collidable>());
    }

    /**
     * create a sprites.Ball with the specified doubles, int and color.
     * @param p the center point
     * @param r the radius
     * @param color the color of the ball
     * @param environment the environment
     */
    public Ball(Point p, int r, java.awt.Color color, GameEnvironment environment) {
        this.center = p;
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.gameEnvironment = environment;
        this.hitListeners = new ArrayList<>();
    }



    // accessors
    /**
     * gets the x value of the center point.
     * @return Game.GameEnvironment representing the gameEnvironment
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }
    /**
     * gets the x value of the center point.
     * @return double representing the x value of the center point
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * gets the y value of the center point.
     * @return double representing the y value of the center point
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * gets the radius length of the ball.
     * @return int representing the radius length of the ball.
     */
    public int getSize() {
        return this.r;
    }
    /**
     * gets the color of the ball.
     * @return java.awt.Color representing the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * gets the size of the frame that the ball can be in.
     * @param m the size that we want to change
     */
    public void setMin(int m) {
        this.min = m;
    }

    /**
     * gets the size of the frame that the ball can be in.
     * @param m the size that we want to change
     */
    public void setMax(int m) {
        this.max = m;
    }

    /**
     * draw the ball on the given DrawSurface.
     * @param surface the surface that we want to draw the ball on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * set the given velocity.
     * @param v1 the velocity that we change
     */
    public void setVelocity(Velocity v1) {
        this.v = v1;
    }

    /**
     * set the given velocity.
     * @param dx the x value of the velocity that we set
     * @param dy the y value of the velocity that we set
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * gets the collision.Velocity.
     * @return collision.Velocity
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * move the ball to the next step, and change its direction if it needed.
     */
    public void moveOneStep() {
        //check if the ball need to change its direction because it collide a block
        Line trajectory = new Line(this.center, new Point(this.center.getX() + this.getVelocity().getDx(),
                this.center.getY() + this.getVelocity().getDy()));

        //organize the start and end points of the trajectory
        if (this.center.getX() > this.center.getX() + this.getVelocity().getDx()) {
            trajectory = new Line(new Point(this.center.getX() + this.getVelocity().getDx(),
                    this.center.getY() + this.getVelocity().getDy()), this.center);
        }
        //if the ball collide something
        if (this.gameEnvironment.getClosestCollision(trajectory) != null) {
            //move the ball to almost the hit point
            Point hit;
            hit = this.gameEnvironment.getClosestCollision(trajectory).collisionPoint();

            Collidable bhit;
            bhit = this.gameEnvironment.getClosestCollision(trajectory).collisionObject();
            //check if the hit point is one of the pinot of the rect
            if (hit.equals(bhit.getCollisionRectangle().getUpperLeft())
                    || hit.equals(bhit.getCollisionRectangle().getLowerLeft())
                    || hit.equals(bhit.getCollisionRectangle().getLowerLeft())
                    || hit.equals(bhit.getCollisionRectangle().getLowerRight())) {
                this.setVelocity(this.gameEnvironment.getClosestCollision(trajectory).collisionObject().
                        hit(this, this.gameEnvironment.getClosestCollision(trajectory).collisionPoint(),
                                this.getVelocity()));
                this.center = this.getVelocity().applyToPoint(this.center);
                return;
            }

            //check 4 cases of the shape of the trajectory line
            //case 1:
            if (trajectory.start().getX() >= hit.getX() && trajectory.start().getY() <= hit.getY()) {
                while (this.center.getX() > this.gameEnvironment.getClosestCollision(trajectory).
                        collisionPoint().getX() + 4) {
                    this.center = this.getVelocity().applyToPoint(this.center);

                }
            } else {
                //case 2:
                if (trajectory.start().getX() <= hit.getX() && trajectory.start().getY() <= hit.getY()) {
                    while (this.center.getX() < this.gameEnvironment.getClosestCollision(trajectory).
                            collisionPoint().getX() - this.getSize()) {
                        this.center = this.getVelocity().applyToPoint(this.center);
                    }
                } else {
                    //case 3:
                    if (trajectory.start().getX() >= hit.getX() && trajectory.start().getY() >= hit.getY()) {
                        while (this.center.getX() > this.gameEnvironment.getClosestCollision(trajectory).
                                collisionPoint().getX() + 4) {
                            this.center = this.getVelocity().applyToPoint(this.center);
                        }
                    } else {
                        //case 4:
                        if (trajectory.start().getX() <= hit.getX() && trajectory.start().getY() >= hit.getY()) {
                            while (this.center.getX() < this.gameEnvironment.getClosestCollision(trajectory).
                                    collisionPoint().getX() - 4) {
                                this.center = this.getVelocity().applyToPoint(this.center);

                            }
                            /*geometry.Point t = this.getVelocity().applyToPoint(this.center);
                            geometry.Line tt = new geometry.Line(this.center, t);
                            if (this.center.getX() > t.getX()) {
                                tt = new geometry.Line(t, this.center);
                            }
                            if (this.gameEnvironment.getClosestCollision(tt) != null) {

                            }*/
                        }
                    }
                }
            }

            //set the new velocity
            this.setVelocity(this.gameEnvironment.getClosestCollision(trajectory).collisionObject().
                    hit(this, this.gameEnvironment.getClosestCollision(trajectory).collisionPoint(),
                            this.getVelocity()));
        }

        //change the balls velocity
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * @return true if the ball touch the sides frame, otherwise return false.
     */
    public boolean isOnSideFrame() {
        if (this.getX() - this.getSize() <= this.min || this.getX() + this.getSize() >= this.max) {
            return true;
        }
        return false;
    }

    /**
     * @return true if the ball touch the up/down frame, otherwise return false.
     */
    public boolean isOnTopFrame() {
        if (this.getY() - this.getSize() <= this.min || this.getY() + this.getSize() >= this.max) {
            return true;
        }
        return false;
    }

    /**
     * move the ball to his next step
     * using move one step method.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * add this ball to the sprites.SpriteCollection of the Game.Game g.
     * @param g the Game.Game that we add  the ball to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Add hl as a listener to hit events.
     * @param hl the listener that we add to the list.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * remove hl from the listeners to hit events.
     * @param hl the listener that we remove from the list.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * remove this ball from the game.
     * @param game the game that we remove the ball from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

}
