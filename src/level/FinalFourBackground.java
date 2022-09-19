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
 * A FinalFourBackground.
 * The class describe a FinalFourBackground and its operations -
 * drawOn and timePassed.
 */
public class FinalFourBackground implements Sprite {
    /**
     * draw the sprite to the screen.
     * @param d the screen that we draw on
     */
    public void drawOn(DrawSurface d) {
        Color color = new Color(39, 127, 203);
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
