package rubytest.findpointsincircle.tests;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import rubytest.findpointsincircle.model.Circle;
import rubytest.findpointsincircle.model.Point;
import rubytest.findpointsincircle.services.CircleRandomPointsService;
import rubytest.findpointsincircle.services.ICircleRandomPointsService;

import java.util.List;

/**
 * Unit test case for methods in CircleRandomPointsService
 * User: Jon Aharrah
 * Date: 7/12/14
 * Time: 11:29 AM
 */
public class CircleRandomPointsServiceTest extends TestCase {

    private ICircleRandomPointsService service;

    @Before
    public void setUp() {
        service = new CircleRandomPointsService();
    }

    @Test
    public void testDistanceBetweenTwoPoints() {
        try {
            Point a = new Point (-10, 10);
            Point b = new Point (10, 10);
            Point c = new Point (10, -10);
            Point d = new Point (-10, -10);

            // left to right
            assertTrue(service.getDistanceBetweenTwoPoints(a, b) == 20);
            // right to left
            assertTrue(service.getDistanceBetweenTwoPoints(b, c) == 20);
            // diagonal left
            assertTrue(service.getDistanceBetweenTwoPoints(a, c) == Math.sqrt(800));
            // diagonal right
            assertTrue(service.getDistanceBetweenTwoPoints(b, d) == Math.sqrt(800));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testPointInsideCircle() {
        try {
            double radius = 10;
            Point center = new Point(10,10);
            Circle circle = new Circle(center, radius);

            // get point inside the circle.
            Point point = service.getRandomPointInCircle(circle);
            assertTrue(service.getDistanceBetweenTwoPoints(point, center) <= radius);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testPointsInsideCircle() {
        try {
            double radius = 10;
            Point center = new Point(10,10);
            Circle circle = new Circle(center, radius);

            // get 1000 points inside the circle.
            List<Point> points = service.getRandomPointsInCircle(circle, 1000);
            for(int i = 0; i < points.size(); i++) {
                Point p = points.get(i);
                assertTrue(service.getDistanceBetweenTwoPoints(p, center) <= radius);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
