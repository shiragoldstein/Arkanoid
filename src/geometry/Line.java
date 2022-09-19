package geometry;

/**
 * @author Shira Goldstein
 *
 * ID:211398086
 */


/**
 * A geometry.Line.
 * The class describe a geometry.Line object and its operations - length, middle, start, end,
 * isIntersecting, intersectionWith, and equals.
 * It is implemented using two Points- start and end, slope and another point.
 */
public class Line {
    //fields
    private Point start;
    private Point end;
    //represent the slope of the line
    private double m;
    //represent the intersect point of the line with the y route.
    private double b;

    /**
     * create a geometry.Line with the specified points.
     *
     * @param start the point where the line begin
     * @param end   the point where the line over
     */
    // constructors
    public Line(Point start, Point end) {
        //compare the points
        int result = Double.compare(start.getX(), end.getX());
        if (result < 0) {
            this.start = new Point(start.getX(), start.getY());
            this.end = new Point(end.getX(), end.getY());
        } else {
            this.start = new Point(end.getX(), end.getY());
            this.end = new Point(start.getX(), start.getY());
        }
        //if the x values of the points are equals
        if (result == 0) {
            this.start = new Point(start.getX(), java.lang.Math.min(start.getY(), end.getY()));
            this.end = new Point(start.getX(), java.lang.Math.max(start.getY(), end.getY()));
        }

        //this.start = start;
        //this.end = end;
        //calculate the slope
        this.m = (start.getY() - end.getY()) / (start.getX() - end.getX());
        //calculate the b point
        this.b = start.getY() - (start.getY() - end.getY()) / (start.getX() - end.getX()) * start.getX();
    }

    /**
     * create a geometry.Line with the specified doubles.
     *
     * @param x1 the x value of the start point
     * @param x2 the x value of the end point
     * @param y1 the y value of the start point
     * @param y2 the y value of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        //compare the points
        int result = Double.compare(x1, x2);
        if (result < 0) {
            this.start = new Point(x1, y1);
            this.end = new Point(x2, y2);
        } else {
            this.start = new Point(x2, y2);
            this.end = new Point(x1, y1);
        }
        //if the x values of the points are equals
        if (result == 0) {
            this.start = new Point(start.getX(), java.lang.Math.min(start.getY(), end.getY()));
            this.end = new Point(start.getX(), java.lang.Math.max(start.getY(), end.getY()));
        }

        //calculate the slope
        this.m = (y1 - y2) / (x1 - x2);
        //calculate the b point
        this.b = y1 - ((y1 - y2) / (x1 - x2)) * x1;
    }

    /**
     * Return the length of the line.
     *
     * @return double representing the length of the line.
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return geometry.Point representing the middle point of the line.
     */
    public Point middle() {
        return new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
    }

    /**
     * Returns the start point of the line.
     *
     * @return geometry.Point representing the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return geometry.Point representing the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Returns true if the lines intersect, false otherwise.
     *
     * @param other the line that we check.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if (this.intersectionWith(other) == null) {
            return false;
        }
        return true;
    }

    /**
     * check if the lines intersect and gets the intersection point .
     *
     * @param other the line that we check.
     * @return the intersection point if the lines intersect,
     * and null otherwise.
     */
    public Point intersectionWith(Line other) {
        //if they are equal
        if (this.equals(other)) {
            return null;
        }
        //if they are anachim
        if (this.areVerticals(other) != null) {
            return this.areVerticals(other);
        }

        //if they have the same m
        if (this.m == other.m) {
            //if they have the same b
            if (this.b == other.b) {
                if (this.start.equals(other.end)) {
                    return new Point(this.start.getX(), this.start.getY());
                }
                if (this.end.equals(other.start)) {
                    return new Point(this.end.getX(), this.end.getY());
                }
            }
            //if they have different b and will never touch each other
            return null;
        }
        double xn;
        double yn;
       //if the x values of the points of one of the lines are equal
        if ((int) this.start.getX() == (int) this.end.getX()) {
            xn = this.start.getX();
            yn = other.m * this.start.getX() + other.b;
            if ((int) yn >= (int) java.lang.Math.min(other.start.getY(), other.end.getY())
                    && (int) yn <= (int) java.lang.Math.max(other.start.getY(), other.end.getY())) {
                return new Point((int) xn, (int) yn);
            }
            return null;
        }
       /* if (other.start.getX() == other.end.getX()) {
            xn = other.start.getX();
            yn = this.m * other.start.getX() + this.b;
            if (yn >= java.lang.Math.min(this.start.getY(), this.end.getY())
            && yn <= java.lang.Math.max(this.start.getY(), this.end.getY())) {
                return new geometry.Point(xn, yn);
            }
            return null;
        }*/

        //if they have different m
        xn = (other.b - this.b) / (this.m - other.m);
        yn = this.m * xn + this.b;
        //check that the point is in the lines
        if (xn <= this.end.getX() && xn >= this.start.getX() && xn >= other.start.getX() && xn <= other.end.getX()) {
            return new Point(xn, yn);
        }
        return null;

    }


    /**
     * check if the lines are equal.
     * @param other the other line
     * @return true if the lines are equal, else return false.
     */
    // equals -- return true if the lines are equal, false otherwise
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end) && this.m == other.m && this.b == other.b;
    }


    /**
     * check if the lines are areVerticals.
     * @param other the other line
     * @return geometry.Point the intersecting point of the lines, else return null.
     */
    public Point areVerticals(Line other) {
        if ((int) this.start.getX() == (int) this.end.getX() && (int) other.start.getY() == (int) other.end.getY()) {
            if ((int) this.start.getX() >= (int) other.start.getX() && (int) this.start.getX() <= (int) other.end.getX()
                    && other.start.getY() >= this.start.getY() && other.start.getY() <= this.end.getY()) {
                return new Point((int) this.start.getX(), (int) other.start.getY());
            }
        }
        if ((int) this.start.getY() == (int) this.end.getY() && (int) other.start.getX() == (int) other.end.getX()) {
            if ((int) other.start.getX() >= (int) this.start.getX() && (int) other.start.getX() <= (int) this.end.getX()
                    && this.start.getY() >= other.start.getY() && this.start.getY() <= other.end.getY()) {
                return new Point((int) other.start.getX(), (int) this.start.getY());
            }
        }
         return null;
    }


    /**
     * check if the line intersect with the rectangle.
     * @param rect the other line
     * @return the closest intersection point to the start of the line.
     * If this line does not intersect with the rectangle, return null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //if the list is empty
        if (rect.intersectionPoints(this).isEmpty()) {
            return null;
        }
        //len to save the length between the first point in the list and the start point of the line.
        double len = rect.intersectionPoints(this).get(0).distance(this.start);
        //find the closest point in the list to the start point of the line
        Point p1 = rect.intersectionPoints(this).get(0);
        for (Point p : rect.intersectionPoints(this)) {
            if ((int) p.distance(this.start) < len) {
                p1 = new Point(p.getX(), p.getY());
                len = p1.distance(this.start);
            }
        }
        return p1;
    }
}
