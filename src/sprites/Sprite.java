package sprites;



/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


import biuoop.DrawSurface;


/**
 * A sprites.Sprite.
 * The interface describe a sprites.Sprite object and its operations -
 * drawOn and timePassed.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d the screen that we draw on
     */
    void drawOn(DrawSurface d);
    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}
