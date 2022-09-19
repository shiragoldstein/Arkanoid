package geometry;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

/**
 * A geometry.Point.
 * The class describe a geometry.Point object and its operations - distance, equals, getX and getY.
 * It is implemented using two doubles.
 */
public class Point {
    //fields
    private double x;
    private double y;

    /**
     * create a point with the specified doubles.
     * @param x the x value of the point
     * @param y the y value of the point
     */
    //constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * return the distance of this point to the other point.
     * @param other the other point
     * @return a double number representing the distance.
     */
    public double distance(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    /**
     * return true if the points are equal, false otherwise.
     * @param other the other point
     * @return true if the points are equal, else return false.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        if ((int) this.getX() == (int) other.getX() && (int) this.getY() == (int) other.getY()) {
            return true;
        }
        return false;
    }

    /**
     * gets the x value of the point.
     * @return double representing the x value of the point
     */
    public double getX() {
        return this.x;
    }

    /**
     * gets the y value of the point.
     * @return double representing the y value of the point
     */
    public double getY() {
        return this.y;
    }
}
