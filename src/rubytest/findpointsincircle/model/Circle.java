package rubytest.findpointsincircle.model;

/**
 * This class represents the physical interpretation of a circle object.  It contains a radius value and
 * a {@link rubytest.findpointsincircle.model.Point} to represent where the center of the circle is.
 * User: Jon Aharrah
 * Date: 7/12/14
 * Time: 8:40 AM
 */
public class Circle {

    private double radius;
    private Point center;

    /**
     * empty constructor
     */
    public Circle() {
    }

    /**
     * Constructor passing in the radius and center values.
     * @param center The Point value of the center
     * @param radius The double value of the radius
     */
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    /**
     * Getter method for value of radius
     * @return value of radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Setter method for value of radius
     * @param radius value of radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Getter method for value of center
     * @return value of center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Setter method for value of center
     * @param center value of center
     */
    public void setCenter(Point center) {
        this.center = center;
    }
}
