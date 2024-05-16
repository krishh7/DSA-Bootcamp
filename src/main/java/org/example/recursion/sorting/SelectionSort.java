package org.example.recursion.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {4, 3, 2, 8, 5, 9, 1};
        selectionSort(numbers, numbers.length, 0, 0);
        System.out.println(Arrays.toString(numbers));
    }

    private static void selectionSort(int[] numbers, int row, int col, int maxIndex) {
        if (row == 0) {
            return;
        }
         if (col < row) {
             if (numbers[col] > numbers[maxIndex]) {
                 selectionSort(numbers, row, col+1, col);
             } else {
                 selectionSort(numbers, row, col+1, maxIndex);
             }
         } else {
             int temp = numbers[maxIndex];
             numbers[maxIndex] = numbers[row-1];
             numbers[row-1] = temp;
             selectionSort(numbers, row-1, 0, 0);
         }
    }
}
