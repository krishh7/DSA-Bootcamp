package org.example.insertionSort;

import java.util.Arrays;

import static org.example.arrays.Q1SwapIndex.swap;

public class LearnInsertionSort {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 3};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(numbers, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
