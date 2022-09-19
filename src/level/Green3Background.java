package level;

import biuoop.DrawSurface;
import sprites.Sprite;

import java.awt.Color;
/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A Green3Background.
 * The class describe a Green3Background and its operations -
 * drawOn and timePassed.
 */
public class Green3Background implements Sprite {
    /**
     * draw the sprite to the screen.
     * @param d the screen that we draw on
     */
    public void drawOn(DrawSurface d) {
        Color color = new Color(33, 139, 15);
        d.setColor(color);
        d.fillRectangle(0, 0, 800, 600);

    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {
        return;
    }
}
