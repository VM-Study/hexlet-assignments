package exercise;

import java.util.Arrays;

class App {
    // BEGIN
    public static int getIndexOfMaxNegative(int[] array) {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 && (array[i] > max || max == 0)) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int[] getElementsLessAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        if (sum == 0) {
            return array;
        }
        int average = sum / array.length;
        int numApproveElements = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= average) {
                numApproveElements++;
            }
        }
        int[] approveArray = new int[numApproveElements];
        int indexApprove = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= average) {
                approveArray[indexApprove] = array[i];
                indexApprove++;
            }
        }
        return approveArray;
    }

    public static int getSumBeforeMinAndMax(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            min = min > array[i] ? array[i] : min;
            max = max < array[i] ? array[i] : max;
        }
        int sum = 0;
        boolean isMinumim = false;
        boolean isMaximum = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                isMinumim = true;
            }
            if (array[i] == max) {
                isMaximum = true;
            }
            if (array[i] != max && array[i] != min) {
                if (isMinumim && !isMaximum || !isMinumim && isMaximum) {
                    sum += array[i];
                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] numbers1 = {};
        System.out.println(App.getIndexOfMaxNegative(numbers1)); // -1
        int[] numbers2 = {1, 4, 3, 4, 5};
        System.out.println(App.getIndexOfMaxNegative(numbers2)); // -1
        int[] numbers3 = {1, 4, -3, 4, -5};
        System.out.println(App.getIndexOfMaxNegative(numbers3)); // 2
        int[] numbers4 = {1, -3, 5, 4, -3, -10};
        System.out.println(App.getIndexOfMaxNegative(numbers4)); // 1

        int[] numbers5 = {1, 2, 6, 3, 8, 12};
        int[] result = App.getElementsLessAverage(numbers5);
        System.out.println(Arrays.toString(result)); // => [1, 2, 3]

        int[] numbers6 = {5, 4, 34, 8, 11, -5, 1};
        System.out.println(App.getSumBeforeMinAndMax(numbers6)); // 19
        int[] numbers7 = {7, 1, 37, -5, 11, 8, 1};
        System.out.println(App.getSumBeforeMinAndMax(numbers7)); // 0
    }
    
    // END
}
