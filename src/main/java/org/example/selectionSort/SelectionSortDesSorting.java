package org.example.selectionSort;

import java.util.Arrays;

// Sort the array in descending order
// 5, 4, 3, 2, 1
public class SelectionSortDesSorting {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 3};
        selectionSortDes(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectionSortDes(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = findMax(numbers, i, n - 1);
            swap(numbers, i, maxIdx);
        }
    }

    private static int findMax(int[] numbers, int start, int end) {
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            if (numbers[i] > numbers[max]) {
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