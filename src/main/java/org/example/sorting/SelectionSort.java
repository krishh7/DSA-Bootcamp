package org.example.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {5, 4, 3, 2, 1};
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void selectionSort(int[] number) {
        for (int i = 0; i < number.length; i++) {
            int end = number.length - i - 1;
            int max = findMaxIndex(number, 0, end);
            swap(number, max, end);
        }

    }
    private static int findMaxIndex(int[] numbers, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
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
