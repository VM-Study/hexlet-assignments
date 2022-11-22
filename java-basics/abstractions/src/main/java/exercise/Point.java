package exercise;

class Point {
    // BEGIN
    public static int[] makePoint(int x, int y) {
        int[] newPoint = new int[2];
        newPoint[0] = x;
        newPoint[1] = y;
        return newPoint;
    }

    public static int getX(int[] point) {
        return point[0];
    }

    public static int getY(int[] point) {
        return point[1];
    }

    public static String pointToString(int[] point) {
        return "(" + point[0] + ", " + point[1] + ")";
    }

    public static int getQuadrant(int[] point) {
        if (point[0] == 0 || point[1] == 0) {
            return 0;
        }
        boolean isXPlus = point[0] > 0;
        boolean isYPlus = point[1] > 0;

        if (isXPlus && isYPlus) {
            return 1;
        } else if (!isXPlus && isYPlus) {
            return 2;
        } else if (!isXPlus && !isYPlus) {
            return 3;
        }
        return 4;
    }

    public static int[] getSymmetricalPointByX(int[] point) {
        int[] invertPoint = new int[point.length];
        invertPoint[0] = point[0];
        invertPoint[1] = point[1] * -1;
        return invertPoint;
    }

    public static int calculateDistance(int[] firstPoint, int[] secondPoint) {
        int x1 = firstPoint[0];
        int y1 = firstPoint[1];
        int x2 = secondPoint[0];
        int y2 = secondPoint[1];

        int result = (int) Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return result;
    }


    public static void main(String[] args) {
        int[] point = Point.makePoint(3, 4);
        System.out.println(Point.getX(point)); // 3
        System.out.println(Point.getY(point)); // 4
        System.out.println(Point.pointToString(point)); // "(3, 4)"
        System.out.println(Point.getQuadrant(point)); // 1
        int[] point2 = makePoint(3, -3);
        System.out.println(Point.getQuadrant(point2)); // 4
        int[] point3 = makePoint(0, 7);
        System.out.println(Point.getQuadrant(point3)); // 0

        int[] point4 = Point.makePoint(-3, -6);
        int[] symmetricalPoint = Point.getSymmetricalPointByX(point4);
        System.out.println(Point.pointToString(symmetricalPoint)); // (-3, 6)

        int[] point5 = Point.makePoint(0, 0);
        int[] point6 = Point.makePoint(3, 4);
        System.out.println(Point.calculateDistance(point5, point6)); // 5

    }

    // END
}
