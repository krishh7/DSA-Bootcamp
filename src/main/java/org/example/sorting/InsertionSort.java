package org.example.sorting;

import java.util.Arrays;

import static org.example.arrays.Q1SwapIndex.swap;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = {0, 3, 21, -2, -87, 2, 3, 44};
        insertionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
    static private void insertionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (numbers[j] < numbers[j-1]) {
                    swap(numbers, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
}
