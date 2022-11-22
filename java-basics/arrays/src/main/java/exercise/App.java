package exercise;

import java.util.Arrays;

class App {
    // BEGIN
    public static int[] reverse(int[] matrix) {
        int[] matrixRe = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            matrixRe[matrix.length - i - 1] = matrix[i];
        }
        return matrixRe;

    }

    public static int mult(int[] matrix) {
        int sum = 1;
        for (int matrixValue: matrix) {
            sum *= matrixValue;
        }
        return sum;
    }

    public static int[] flattenMatrix(int[][] doubleMatrix) {
        int matrixSize = 0;
        for (int i = 0; i < doubleMatrix.length; i++) {
            matrixSize += doubleMatrix[i].length;
        }

        int[] singleMatrix = new int[matrixSize];
        int i = 0;
        for (int[] matrixValue2: doubleMatrix) {
            for (int matrixValue1: matrixValue2) {
                singleMatrix[i] = matrixValue1;
                i++;
            }
        }
        return singleMatrix;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, -6, 3, 8};
        int[] result = App.reverse(numbers);
        System.out.println(Arrays.toString(result)); // => [8, 3, -6, 2, 1]

        int[] numbers1 = {};
        System.out.println(App.mult(numbers1)); // 1
        int[] numbers2 = {1, 4, 3, 4, 5};
        System.out.println(App.mult(numbers2)); // 240
        int[] numbers3 = {1, 4, -3, 2};
        System.out.println(App.mult(numbers3)); // -24
        int[] numbers4 = {1, -3, 5, 4, -3, 0};
        System.out.println(App.mult(numbers4)); // 0

        int[][] matrix1 = new int[0][0];
        int[] result1 = App.flattenMatrix(matrix1);
        System.out.println(Arrays.toString(result1));  // => []
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[] result2 = App.flattenMatrix(matrix2);
        System.out.println(Arrays.toString(result2));  // => [1, 2, 3, 4, 5, 6]
    }


    // END
}
