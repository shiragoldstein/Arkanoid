// ID: 211398086
package sprites;


import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

/**
 * A sprites.SpriteCollection.
 * The class describe a sprites.SpriteCollection object and its operations -
 * addSprite, notifyAllTimePassed and drawAllOn.
 * It is implemented using ArrayList<sprites.Sprite>.
 */
public class SpriteCollection {
    //fields
    private ArrayList<Sprite> sprites;

    /**
     * create a sprites.SpriteCollection with the specified sprites arraylist.
     * @param sprites the sprites
     */
    //constructor
    public SpriteCollection(ArrayList<Sprite> sprites) {
        this.sprites = sprites;
    }

    /**
     * add the given sprites.Sprite to the sprites.SpriteCollection.
     * @param s the sprites.Sprite that we add to the list
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }


    /**
     * return the sprites.Sprite list.
     * @return ArrayList<sprites.Sprite> the sprites.Sprite list.
     */
    public ArrayList<Sprite> getSprites() {
        return this.sprites;
    }

    /**
     * call timePassed() on all sprites in the sprites.SpriteCollection.
     */
    public void notifyAllTimePassed() {
        List<Sprite> tempSprites = new ArrayList<Sprite>(this.sprites);
        for (Sprite s : tempSprites) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites in the sprites.SpriteCollection.
     * @param d the DrawSurface that we draw on
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.sprites) {
            s.drawOn(d);
        }
    }
}
