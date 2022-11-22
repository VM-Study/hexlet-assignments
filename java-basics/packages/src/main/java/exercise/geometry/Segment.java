// BEGIN
package exercise.geometry;

import java.util.Arrays;

public class Segment {
    public static double[][] makeSegment(double[] point1, double[] point2) {
        double[][] segment = {
                {Point.getX(point1), Point.getY(point1)},
                {Point.getX(point2), Point.getY(point2)}
        };
        return segment;
    }

    public static double[] getBeginPoint(double[][] segment) {
        return segment[0];
    }

    public static double[] getEndPoint(double[][] segment) {
        return segment[1];
    }

    public static void main(String[] args) {
        double[] point1 = Point.makePoint(2, 3);
        double[] point2 = Point.makePoint(4, 5);
        double[][] segment = Segment.makeSegment(point1, point2);
        double[] beginPoint = Segment.getBeginPoint(segment);
        double[] endPoint = Segment.getEndPoint(segment);
        System.out.println(Arrays.toString(beginPoint)); // => [2, 3]
        System.out.println(Arrays.toString(endPoint)); // => [4, 5]

    }
}
// END
