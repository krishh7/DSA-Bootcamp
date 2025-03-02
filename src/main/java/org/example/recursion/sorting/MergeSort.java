package org.example.recursion.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = {1, 7, 11, 8, 10, 18, 13, 9, 0, -3, -44, 3, 2, 5, 4};
        System.out.println(Arrays.toString(mergeSort(input)));

    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int mid = array.length / 2;
        int[] leftHalf = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] rightHalf = mergeSort(Arrays.copyOfRange(array, mid, array.length));
        return merge(leftHalf, rightHalf);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mergedArray = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mergedArray[k] = first[i];
                i++;
            } else {
                mergedArray[k] = second[j];
                j++;
            }
            k++;
        }
        //Adding remaining elements in case of unequal arrays
        while (i < first.length) {
            mergedArray[k] = first[i];
            i++;
            k++;
        }
        while ( j < second.length) {
            mergedArray[k] = second[j];
            j++;
            k++;
        }
        return mergedArray;
    }
}
