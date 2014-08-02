package rubytest.findpointsincircle.services;

import rubytest.findpointsincircle.model.Circle;
import rubytest.findpointsincircle.model.Point;

import java.util.List;

/**
 * Interface that defines methods for finding one to many random {@link rubytest.findpointsincircle.model.Point}
 * objects in a {@link rubytest.findpointsincircle.model.Circle} object.
 *
 * User: Jon Aharrah
 * Date: 7/12/14
 * Time: 9:36 AM
 */
public interface ICircleRandomPointsService {

    /**
     * This service finds a random Point object that falls within the given Circle object.
     *
     * @param circle The Circle object for which a random point inside it should be found.
     * @return A Point object that falls within the Circle passed in as a parameter.
     * @throws Exception Propagating exception that could be thrown in getting the distance between points.
     */
    public Point getRandomPointInCircle(Circle circle) throws Exception;

    /**
     * This service finds the number of Point objects in the given Circle object, specified by the
     * numberOfPoints parameter.
     *
     * @param circle The Circle object for which random points inside it should be found.
     * @param numberOfPoints The total number of points to be returned in the ArrayList.
     * @return A List of Point objects that fall within the Circle passed in as a parameter.
     * @throws Exception If the amount passed in is not a positive integer, throw an Exception
     */
    public List<Point> getRandomPointsInCircle(Circle circle, int numberOfPoints) throws Exception;

    /**
     * This service finds the distance between two Point objects.
     * @param a Point A
     * @param b Point B
     * @return distance between the two points
     * @throws Exception If either of the Point objects passed in are null, throw an Exception
     */
    public double getDistanceBetweenTwoPoints(Point a, Point b) throws Exception;
}
