package org.example.sorting;

import java.util.Arrays;

import static org.example.arrays.Q1SwapIndex.swap;

public class CyclicSort {
    public static void main(String[] args) {
        int[] numbers = {3, 5, 2, 1, 4, 7, 6, 9, 8};
        cyclicSort(numbers);
        System.out.println(Arrays.toString(numbers));

    }

    private static void cyclicSort(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            int correctIndex = numbers[i] - 1;
            if (numbers[i] != numbers[correctIndex]) {
                swap(numbers, correctIndex, i);
            } else
                i++;
        }
    }
}
