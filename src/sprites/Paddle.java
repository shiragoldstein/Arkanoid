// ID: 211398086
package sprites;

import game.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collision.Collidable;
import collision.Velocity;
import geometry.Point;
import geometry.Rectangle;

import java.awt.Color;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

/**
 * A sprites.Paddle.
 * The class describe a sprites.Paddle object and its operations - timePassed,
 * drawOn, moveLeft, moveRight, getCollisionRectangle, hit and addToGame.
 * It is implemented using biuoop.KeyboardSensor, geometry.Rectangle and a sprites.Ball.
 */
public class Paddle implements Sprite, Collidable {
    //fields
    private biuoop.KeyboardSensor keyboard;
    private Rectangle paddle;
    private Ball ball;

    /**
     * create a sprites.Paddle with the specified biuoop.KeyboardSensor.
     * @param keyboard the KeyboardSensor
     */
    //constructors
    public Paddle(biuoop.KeyboardSensor keyboard) {
        this.keyboard = keyboard;
        this.paddle = new Rectangle(new Point(365, 565), 70, 20);
        this.ball = new Ball(this.paddle.getUpperLeft(), 0, Color.white);
        this.ball.setVelocity(0, 0);
    }

    /**
     * create a sprites.Paddle with the specified biuoop.KeyboardSensor, point and int.
     * @param keyboard the KeyboardSensor
     * @param p the point
     * @param width the width
     */
    public Paddle(biuoop.KeyboardSensor keyboard, Point p, int width) {
        this.keyboard = keyboard;
        this.paddle = new Rectangle(p, width, 20);
        this.ball = new Ball(this.paddle.getUpperLeft(), 0, Color.white);
        this.ball.setVelocity(0, 0);
    }


    // sprites.Sprite
    /**
     * check if the "left" or "right" keys are pressed,
     * and if so move it accordingly.
     */
    public void timePassed() {
        //if they pressed left
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        //if they pressed right
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }
    /**
     * draw the sprites.Paddle on the given DrawSurface.
     * @param d the surface that we want to draw the sprites.Paddle on
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.ORANGE);
        d.fillRectangle((int) this.paddle.getUpperLeft().getX(), (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.paddle.getUpperLeft().getX(), (int) this.paddle.getUpperLeft().getY(),
                (int) this.paddle.getWidth(), (int) this.paddle.getHeight());
    }
    /**
     * move the sprites.Paddle to the left.
     */
    public void moveLeft() {
        this.ball.setVelocity((-1) * 4, 0);
        this.ball = new Ball(this.ball.getVelocity().applyToPoint(new Point(this.ball.getX(),
                this.ball.getY())), 0, Color.white);

        if (this.paddle.getWidth() > 100) {
            this.paddle = new Rectangle(new Point(this.ball.getX(), this.ball.getY()), 590, 20);
        } else {
            this.paddle = new Rectangle(new Point(this.ball.getX(), this.ball.getY()), 70, 20);
        }
        if (this.ball.getX() <= 40) {
            this.ball = new Ball(new Point(40, this.ball.getY()), 0, Color.white);
        }
    }
    /**
     * move the sprites.Paddle to the right.
     */
    public void moveRight() {
        this.ball.setVelocity(4, 0);
        this.ball = new Ball(this.ball.getVelocity().applyToPoint(new Point(this.ball.getX(),
                this.ball.getY())), 0, Color.white);

        if (this.paddle.getWidth() > 100) {
            this.paddle = new Rectangle(new Point(this.ball.getX(), this.ball.getY()), 590, 20);
        } else {
            this.paddle = new Rectangle(new Point(this.ball.getX(), this.ball.getY()), 70, 20);
        }
        if (this.ball.getX() + this.paddle.getWidth() >= 760) {
            this.ball = new Ball(new Point(760 - this.paddle.getWidth(), this.ball.getY()), 0, Color.white);
        }
    }

    //collision.Collidable
    /**
     * Returns the rectangle of the sprites.Paddle.
     * @return geometry.Rectangle representing the rectangle of the sprites.Paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint the collision geometry.Point that we check
     * @param currentVelocity the current collision.Velocity of the object
     * @param hitter the ball that hit the block
     * @return velocity the new velocity expected after the hit
     * based on the force the object inflicted on us.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //if its collide on the upper line
        if (collisionPoint.getY() == this.paddle.getUpperLeft().getY() && collisionPoint.getX()
                >= this.paddle.getUpperLeft().getX() && collisionPoint.getX() <= this.paddle.getUpperRight().getX()) {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
        }
        //if its collide on the lower line
        if (collisionPoint.getY() == this.paddle.getLowerLeft().getY() && collisionPoint.getX()
                >= this.paddle.getLowerLeft().getX() && collisionPoint.getX() <= this.paddle.getLowerRight().getX()) {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
        }
        //if its collide on the left line
        if (collisionPoint.getX() == this.paddle.getUpperLeft().getX() && collisionPoint.getY()
                <= this.paddle.getLowerLeft().getY() && collisionPoint.getY() >= this.paddle.getUpperLeft().getY()) {
            return new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy());
        }
        //if its collide on the right line
        if (collisionPoint.getX() == this.paddle.getUpperRight().getX() && collisionPoint.getY()
                >= this.paddle.getUpperRight().getY() && collisionPoint.getY() <= this.paddle.getLowerRight().getY()) {
            return new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy());
        }
        //if we dont have collisionPoint
        return currentVelocity;
    }
    /**
     * Add this paddle to the game.
     * @param g the game that we add the paddle to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
