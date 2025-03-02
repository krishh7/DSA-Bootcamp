package org.example.selectionSort;

import java.util.Arrays;

public class LearnSelectionSort {
    public static void main(String[] args) {
        int[] array = {32,41,21,29,7,53,97,76,71,53,53,53,72,53,53,14,22,53,67,53,53,53,54,98,53,46,53,53,62,53,76,20,60,53,31,53,53,53,95,27,53,53,53,53,36,59,40,53,53,64,53,53,53,21,53,51,53,53,2,53,53,53,53,53,50,53,53,53,23,88,3,53,61,19,53,68,53,35,42,53,53,48,34,54,53,75,53,53,50,44,92,41,71,53,53,82,53,53,14,53};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(array[array.length/2]);
    }

    private static void selectionSort(int[] numbers) {
        for (int i = 0; i <= numbers.length - 1; i++) {
            int end = numbers.length - 1 - i;
            int maxIndex = findMaxIndex(numbers, 0, end);
            swap(numbers, maxIndex, end);
        }
    }

    private static int findMaxIndex(int[] numbers, int start, int end) {
        int max = start;
        for (int i = 0; i <= end; i++) {
            if (numbers[max] < numbers[i]) {
                max = i;
            }
        }
        return max;
    }

    private static void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }
}
