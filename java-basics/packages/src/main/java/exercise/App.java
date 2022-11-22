package exercise;

import exercise.geometry.Point;
import exercise.geometry.Segment;

import java.util.Arrays;

// BEGIN
public class App {
    public static double[] getMidpointOfSegment(double[][] segment) {
        double[] beginPoint = Segment.getBeginPoint(segment);
        double[] endPoint = Segment.getEndPoint(segment);
        double[] midpointOfSegment = {
                (Point.getX(beginPoint) + Point.getX(endPoint)) / 2,
                (Point.getY(beginPoint) + Point.getY(endPoint)) / 2
        };
        return midpointOfSegment;
    }

    public static double[][] reverse(double[][] segment) {
        double[] beginPoint = Segment.getBeginPoint(segment);
        double[] endPoint = Segment.getEndPoint(segment);
        double[][] reversedSegment = {
                {Point.getX(endPoint), Point.getY(endPoint)},
                {Point.getX(beginPoint), Point.getY(beginPoint)}
        };
        return reversedSegment;
    }

    public static boolean isBelongToOneQuadrant(double[][] segment) {
        double[] beginPoint = Segment.getBeginPoint(segment);
        double x1 = Point.getX(beginPoint);
        double y1 = Point.getY(beginPoint);
        double[] endPoint = Segment.getEndPoint(segment);
        double x2 = Point.getX(endPoint);
        double y2 = Point.getY(endPoint);

        if (x1 == 0 || x2 == 0 || y1 ==0 || y2 == 0) {
            return false;
        }
        int segment1Quadrant = getQuadrant(x1, y1);
        int segment2Quadrant = getQuadrant(x2, y2);

        if (segment1Quadrant == segment2Quadrant) {
            return true;
        }
        return false;

    }
    public static int getQuadrant(double x, double y) {
        boolean isXPlus = x > 0;
        boolean isYPlus = y > 0;
        int segmentQuadrant = 0;
        if (isXPlus && isYPlus) {
            segmentQuadrant = 1;
        } else if (!isXPlus && isYPlus) {
            segmentQuadrant = 2;
        } else if (!isXPlus && !isYPlus) {
            segmentQuadrant = 3;
        } else  {
            segmentQuadrant = 4;
        }
        return segmentQuadrant;
    }

    public static void main(String[] args) {
        double[] point1 = Point.makePoint(3, 4);
        double[] point2 = Point.makePoint(6, 7);
        double[][] segment = Segment.makeSegment(point1, point2);

        double[] midPoint = App.getMidpointOfSegment(segment);
        System.out.println(Arrays.toString(midPoint)); // => [4.5, 5.5]

        double[][] reversedSegment = App.reverse(segment);
        double[] beginPoint = Segment.getBeginPoint(reversedSegment);
        double[] endPoint = Segment.getEndPoint(reversedSegment);
        System.out.println(Arrays.toString(beginPoint)); // => [6, 7]
        System.out.println(Arrays.toString(endPoint)); // => [3, 4]

        double[][] segment1 = Segment.makeSegment(Point.makePoint(1, 4), Point.makePoint(5, 8));
        System.out.println(App.isBelongToOneQuadrant(segment1)); // true
        double[][] segment2 = Segment.makeSegment(Point.makePoint(1, 4), Point.makePoint(-2, 8));
        System.out.println(App.isBelongToOneQuadrant(segment2)); // false
        double[][] segment3 = Segment.makeSegment(Point.makePoint(1, 4), Point.makePoint(0, 0));
        System.out.println(App.isBelongToOneQuadrant(segment3)); // false

    }
}

// END
