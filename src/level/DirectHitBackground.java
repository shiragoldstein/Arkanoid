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
 * A DirectHitBackground.
 * The class describe a DirectHitBackground and its operations -
 * drawOn and timePassed.
 */
public class DirectHitBackground implements Sprite {

    /**
     * draw the sprite to the screen.
     * @param d the screen that we draw on
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.blue);
        d.drawLine(400, 60, 400, 285);
        d.drawLine(240, 165, 550, 165);
        d.drawCircle(400, 165, 30);
        d.drawCircle(400, 165, 70);
        d.drawCircle(400, 165, 110);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {
        return;
    }
}
