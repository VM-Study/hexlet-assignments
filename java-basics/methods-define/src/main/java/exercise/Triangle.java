package exercise;

class Triangle {
    // BEGIN
    public static double getSquare(int sizeA, int sizeB, int level) {
        double radian = level * Math.PI / 180;
        return 0.5 * sizeA * sizeB * Math.sin(radian);

    }
    public static void main(String[] args) {
        System.out.println(Triangle.getSquare(4, 5, 45));    // 7.07
    }
    // END
}
