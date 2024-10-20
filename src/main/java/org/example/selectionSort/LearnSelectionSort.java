package org.example.selectionSort;

import java.util.Arrays;

public class LearnSelectionSort {
    public static void main(String[] args) {
        int[] array = {3, 2, 4, 5, 1};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSort(int[] numbers) {
        for (int i = 0; i <= numbers.length - 1; i++) {
            int end = numbers.length - 1 - i;
            int maxIndex = findMaxIndex(numbers, 0, end);
            swap(numbers, maxIndex, end);
        }
    }

    private static int findMaxIndex(int[] numbers, int start, int end) {
        int max = start;
        for (int i = 0; i <= end; i++) {
            if (numbers[max] < numbers[i]) {
                max = i;
            }
        }
        return max;
    }

    private static void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }
}
