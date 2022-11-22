package exercise;

import java.util.Arrays;

class App {
    // BEGIN
    // Сортировка ПУЗЫРЬКОМ (БУЛЬ БУЛЬ)
    public static int[] sort(int[] arr) {
        boolean isFinish = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isFinish = false;
                }
            }
            if (isFinish) {
                break;
            } else {
                isFinish = true;
            }
        }
        return arr;
    }

    // Сортировка ВЫБОРОМ
    public static int[] sortSelected(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 10, 4, 3};
        int[] sorted = App.sort(numbers);
        System.out.println(Arrays.toString(sorted)); // => [3, 3, 4, 10]

        int[] numbers2 = {4, 9, 7, 6, 2, 3};
        int[] sorted2 = App.sortSelected(numbers2);
        System.out.println(Arrays.toString(sorted2)); // => [2, 3, 4, 6, 7, 9]

    }
    // END
}
