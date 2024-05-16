package org.example.recursion.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {9, 6, 3, 4, 7, 10};
        bubbleSort(numbers, numbers.length - 1, 0);
        System.out.println(Arrays.toString(numbers));
    }

    private static void bubbleSort(int[] numbers, int row, int col) {
        if (row == 0) {
            return;
        }
        if ( col < row) {
            if (numbers[col] > numbers[col + 1]) {
                int temp = numbers[col];
                numbers[col] = numbers[col+1];
                numbers[col+1] = temp;
            }
            bubbleSort(numbers, row, col + 1);
        } else {
            bubbleSort(numbers, row - 1, 0);
        }
    }
}
