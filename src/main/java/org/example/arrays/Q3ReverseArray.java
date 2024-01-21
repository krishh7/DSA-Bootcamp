package org.example.arrays;

import java.util.Arrays;

public class Q3ReverseArray {
    public static void main(String[] args) {
        int[] numbers = {1, 13, 13, 23,12, 23, 11, 1, 14, 14, 1};
        reverse(numbers);
        System.out.println(Arrays.toString(numbers));

    }

    private static void reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2]  = temp;
    }
}
