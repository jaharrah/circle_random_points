package rubytest.findpointsincircle.model;

/**
 * This class represents the physical representation of a point in the x y axis.
 * User: Jon Aharrah
 * Date: 7/12/14
 * Time: 8:46 AM
 */
public class Point {
    private double x;
    private double y;

    /**
     * empty constructor
     */
    public Point() {
    }

    /**
     * Constructor passing in the x and y values.
     * @param x The value of the x-axis position
     * @param y The value of the y-axis position
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method for value of position on x-axis
     * @return value of position on x-axis
     */
    public double getX() {
        return x;
    }

    /**
     * Setter method for value of position on x-axis
     * @param x value of position on x-axis
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Getter method for value of position on y-axis
     * @return value of position on y-axis
     */
    public double getY() {
        return y;
    }

    /**
     * Setter method for value of position on x-axis
     * @param y value of position on x-axis
     */
    public void setY(double y) {
        this.y = y;
    }
}
