package org.example.recursion.sorting;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] input = {1, 7, 11, 8, 10, 18, 13, 9, 0, -3, -44, 3, 2, 5, 4};
        mergeSortInPlace(input, 0, input.length);
        System.out.println(Arrays.toString(input));
    }

    private static void mergeSortInPlace(int[] array, int s, int e) {
        if (e - s == 1) {
            return;
        }
        int mid = (s + e) / 2;
        mergeSortInPlace(array, s, mid);
        mergeSortInPlace(array, mid, e);

        mergeInPlace(array, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];
        int i = s, j = m, k = 0;
        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }

    }
}
