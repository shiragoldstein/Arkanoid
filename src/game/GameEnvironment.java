package game;


import collision.Collidable;
import collision.CollisionInfo;
import geometry.Line;
import geometry.Point;

import java.util.ArrayList;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A Game.GameEnvironment.
 * The class describe a Game.GameEnvironment and its operations -
 * addCollidable and getClosestCollision.
 * It is implemented using an Array List of Collidables that are in the game..
 */
public class GameEnvironment {

    private ArrayList<Collidable> collidables;

    /**
     * create a Game.GameEnvironment with the specified collidables arraylist.
     * @param collidables the collidables
     */
    //constructors
    public GameEnvironment(ArrayList<Collidable> collidables) {
        this.collidables = collidables;
    }
    /**
     * create a Game.GameEnvironment with a new collidables arraylist.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * add the given collidable to the environment.
     * @param c the collidable that we add to the list
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * return the collidables list.
     * @return the collidables list
     */
    public ArrayList<Collidable> getCollidables() {
        return this.collidables;
    }


    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     * @param trajectory the line that the object is moving on
     * @return null If this object will not collide with any of the collidables in this collection, otherwise return
     * collision.CollisionInfo the information about the closest collision that is going to occur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //if the list is empty
        if (this.collidables.isEmpty()) {
            return null;
        }
        //save the distance from the start point of the given line
        double d = 700;
        Point p = null;
        Collidable c = this.collidables.get(0);
        for (int i = 0; i < this.collidables.size(); i++) {
            //if the specified colladiable is collide with the line
            if (trajectory.closestIntersectionToStartOfLine(this.collidables.get(i).getCollisionRectangle()) != null) {
                //check if the point is the closest to the start of the line
                if (trajectory.closestIntersectionToStartOfLine(this.collidables.get(i).getCollisionRectangle()).
                        distance(trajectory.start()) < d) {
                    d = trajectory.closestIntersectionToStartOfLine(this.collidables.get(i).getCollisionRectangle()).
                            distance(trajectory.start());
                    p = new Point(trajectory.closestIntersectionToStartOfLine(this.collidables.get(i).
                            getCollisionRectangle()).getX(),
                            trajectory.closestIntersectionToStartOfLine(this.collidables.get(i).
                                    getCollisionRectangle()).getY());
                    c = this.collidables.get(i);
                }
            }
        }
        //If this object does not collide with any of the collidables
        if (p == null) {
            return null;
        }
        return new CollisionInfo(p, c);
    }
}
