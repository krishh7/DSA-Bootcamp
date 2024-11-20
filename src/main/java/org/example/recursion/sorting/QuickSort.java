package org.example.recursion.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] input = {2, 3, 4, 1, 5};
        quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    private static void quickSort(int[] numbers, int low, int high) {
        //high and low will define which part of the array are you working in
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = numbers[mid]; //Pivot we can take anything but taking mid here
        while (start <= end) {
            while (numbers[start] < pivot) {
                start++;
            }
            while (pivot < numbers[end]) {
                end--;
            }
            if (start <= end) {
                int temp = numbers[start];
                numbers[start] = numbers[end];
                numbers[end] = temp;
                start++;
                end--;
            }
        }

        //Now my pivot is at correct index, sort two halves
        quickSort(numbers, low, end);
        quickSort(numbers, start, high);
    }
}
