package rubytest.findpointsincircle.services;

import rubytest.findpointsincircle.model.Circle;
import rubytest.findpointsincircle.model.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the service class that provides the method that can find random
 * {@link rubytest.findpointsincircle.model.Point} objects in a given {@link rubytest.findpointsincircle.model.Circle}
 * object.
 *
 * User: Jon Aharrah
 * Date: 7/12/14
 * Time: 9:15 AM
 */
public class CircleRandomPointsService implements ICircleRandomPointsService {

    /**
     * This helper method finds a random Point object that falls within the square that surrounds the given
     * Circle object.
     * <p>
     * The x and y values are found at random by starting at the circle center coordinates, and adding to that by
     * using Math.random() times the radius.  That gives us a random coordinate in the top right quadrant of the circle
     * graph, if the circle was split by horizontal and vertical sections.  We are then flipping a coin,
     * by calling (Math.random() > .5) to determine if the x-axis should be flipped, and the same for the y-axis.
     *
     * @param circle The Circle object for which a random point inside it should be found.
     * @return A Point object that falls within the square surrounding the Circle passed in as a parameter.
     */
    protected Point getRandomPointInSquare (Circle circle) {
        // we are finding random x and y values to add to the circle center, by using Math.random() * radius.
        double x = Math.random() * circle.getRadius();
        double y = Math.random() * circle.getRadius();

        // We then will flip a coin on whether we need to flip the x-axis, as well as the y-axis.
        if(Math.random() > .5) {
            x *= -1;
        }
        if(Math.random() > .5) {
            y *= -1;
        }

        // since the circle center can be anywhere on xy graph, we need to add these values based on circle center.
        return new Point(circle.getCenter().getX() + x, circle.getCenter().getY() + y);
    }

    /**
     * This service finds a random Point object that falls within the given Circle object.
     * <p>
     * A call is made to the getRandomPointInSquare method to find a random point inside the square that surrounds
     * the Circle object.  If the random Point falls within the Circle, we return that object.
     *
     * @param circle The Circle object for which a random point inside it should be found.
     * @return A Point object that falls within the Circle passed in as a parameter.
     * @throws Exception Propagating exception that could be thrown in getting the distance between points.
     */
    public Point getRandomPointInCircle(Circle circle) throws Exception {

        Point randomPoint = this.getRandomPointInSquare(circle);

        // If the distance between the center and random point are less than the radius,
        // or equal to the radius (being on the circumference), it is in the circle, and it should be returned.
        // Otherwise, we continue to call the getRandomPointInSquare method.
        while(this.getDistanceBetweenTwoPoints(randomPoint, circle.getCenter()) > circle.getRadius()) {
            randomPoint = this.getRandomPointInSquare(circle);
        }

        // return the Point that is in the circle.
        return randomPoint;
    }

    /**
     * This service finds the number of Point objects in the given Circle object, specified by the amount parameter.
     *
     * @param circle The Circle object for which random points inside it should be found.
     * @param numberOfPoints The total number of points to be returned in the ArrayList.
     * @return A List of Point objects that fall within the Circle passed in as a parameter.
     * @throws Exception If the amount passed in is not a positive integer, throw an Exception
     */
    public List<Point> getRandomPointsInCircle(Circle circle, int numberOfPoints) throws Exception {

        // if the amount value passed in is less than zero, throw an Exception.
        if(numberOfPoints < 1) {
            throw new Exception("You must supply a total number of points greater than zero.");
        }

        ArrayList<Point> points = new ArrayList<Point>();

        // while we don't have enough points in the list, continue searching for random points
        // that are inside the circle.
        while(points.size() < numberOfPoints) {
            points.add(this.getRandomPointInCircle(circle));
        }

        return points;
    }

    /**
     * This method finds the distance between two Point objects.
     * @param a Point A
     * @param b Point B
     * @return distance between the two points
     * @throws Exception If either of the Point objects passed in are null, throw an Exception
     */
    public double getDistanceBetweenTwoPoints(Point a, Point b) throws Exception {

        // if a or b is null, throw an Exception
        if(a == null || b == null) {
            throw new Exception("You need to pass in two instantiated Point objects as parameters.");
        }

        // return the math formula of distance between two points, which is
        // sqrt((ax - bx)^2 + (ay - by)^2)
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}
