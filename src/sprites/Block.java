// ID: 211398086
package sprites;


import game.GameLevel;
import biuoop.DrawSurface;
import collision.Collidable;
import collision.Velocity;
import geometry.Point;
import geometry.Rectangle;
import listener.HitListener;
import listener.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

/**
 * A sprites.Block.
 * The class describe a sprites.Block object and its operations -
 * drawOn, getCollisionRectangle, hit, timePassed and addToGame.
 * It is implemented using geometry.Rectangle and color.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    //fields
    private Rectangle rect;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * create a sprites.Block with the specified geometry.Rectangle and color.
     * @param rect the geometry.Rectangle
     * @param color the color of the block
     */
    //constructor
    public Block(Rectangle rect, java.awt.Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * draw the block on the given DrawSurface.
     * @param surface the surface that we want to draw the block on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(), (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(), (int) this.rect.getHeight());


    }


    /**
     * @return rectangle the shape of the block
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param collisionPoint the collision geometry.Point that we check
     * @param currentVelocity the current collision.Velocity of the object
     * @return velocity the new velocity expected after the hit
     * based on the force the object inflicted on us.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //if its collide on the upper line
        if (collisionPoint.getY() == this.rect.getUpperLeft().getY() && collisionPoint.getX()
                >= this.rect.getUpperLeft().getX() && collisionPoint.getX() <= this.rect.getUpperRight().getX()) {
            //calling the listeners that a hit occurs
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
        }
        //if its collide on the lower line
        if (collisionPoint.getY() == this.rect.getLowerLeft().getY() && collisionPoint.getX()
                >= this.rect.getLowerLeft().getX() && collisionPoint.getX() <= this.rect.getLowerRight().getX()) {
            //calling the listeners that a hit occurs
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * (-1));
        }
        //if its collide on the left line
        if (collisionPoint.getX() == this.rect.getUpperLeft().getX() && collisionPoint.getY()
                <= this.rect.getLowerLeft().getY() && collisionPoint.getY() >= this.rect.getUpperLeft().getY()) {
            //calling the listeners that a hit occurs
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy());
        }
        //if its collide on the right line
        if (collisionPoint.getX() == this.rect.getUpperRight().getX() && collisionPoint.getY()
                >= this.rect.getUpperRight().getY() && collisionPoint.getY() <= this.rect.getLowerRight().getY()) {
            //calling the listeners that a hit occurs
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx() * (-1), currentVelocity.getDy());
        }
        //if we dont have collisionPoint
        return currentVelocity;

    }

    @Override
    public void timePassed() {
        return;
    }

    /**
     * add this block to the sprites.SpriteCollection and to
     * the game enviroment collidables list of the Game.Game g.
     * @param g the Game.Game that we add the block to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
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
     * called whenever a hit() occurs, and notify all of the registered
     * HitListener objects by calling their hitEvent method.
     * @param hitter the ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * remove this block from the game.
     * @param game the game that we remove the block from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }
}
