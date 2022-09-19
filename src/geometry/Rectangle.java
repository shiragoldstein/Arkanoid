package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */

/**
 * A geometry.Rectangle.
 * The class describe a geometry.Rectangle object and its operations -
 * intersectionPoints, getWidth, getHeight, getUpperLeft.
 * It is implemented using a geometry.Point and two doubles.
 */
public class Rectangle {
    //fields
    private Point upperLeft;
    private double width;
    private double height;

    private Point upperRight;
    private Point lowerLeft;
    private Point lowerRight;

    /**
     * create a rectangle with the specified doubles and point.
     * @param width the width
     * @param height the height
     * @param upperLeft the location point
     */
    //constructor
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        //create the 3 other points of the rectangle
        this.upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        this.lowerLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        this.lowerRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }

    /**
     * check if the rectangle has intersection points with the specified geometry.Line.
     * @param line the width
     * @return java.util.List<geometry.Point> the List with the intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        //creating a list
        List l = new ArrayList<Point>();
        //create the 4 lines of the rectangle
        Line up = new Line(this.upperLeft, this.upperRight);
        Line down = new Line(this.lowerLeft, this.lowerRight);
        Line left = new Line(this.upperLeft, this.lowerLeft);
        Line right = new Line(this.upperRight, this.lowerRight);
        //check for each line if they are intersecting
        // with the given line, and add them to the list.
        if (up.isIntersecting(line)) {
            l.add(up.intersectionWith(line));
        }
        if (down.isIntersecting(line)) {
            l.add(down.intersectionWith(line));
        }
        if (left.isIntersecting(line)) {
            l.add(left.intersectionWith(line));
        }
        if (right.isIntersecting(line)) {
            l.add(right.intersectionWith(line));
        }
        return l;
    }

    /**
     * Returns the width of the rectangle.
     * @return double representing the width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the rectangle.
     * @return double representing the height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper-Left geometry.Point of the rectangle.
     * @return double representing the upper-Left geometry.Point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Returns the upper-Right geometry.Point of the rectangle.
     * @return double representing the upper-Right geometry.Point.
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     * Returns the lowerLeft geometry.Point of the rectangle.
     * @return double representing the lowerLeft geometry.Point.
     */
    public Point getLowerLeft() {
        return this.lowerLeft;
    }

    /**
     * Returns the lowerRight geometry.Point of the rectangle.
     * @return double representing the lowerRight geometry.Point.
     */
    public Point getLowerRight() {
        return this.lowerRight;
    }
}