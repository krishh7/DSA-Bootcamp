package org.example.arrays;

//Here in this question, we will swap the indices of an array

import java.util.Arrays;

public class Q1SwapIndex {
    public static void main(String[] args) {
        int[] arr = {1, 11, 8, 9, 12, 1};
        System.out.println(Arrays.toString(arr));
        swap(arr, 1, 5);
        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }
}
