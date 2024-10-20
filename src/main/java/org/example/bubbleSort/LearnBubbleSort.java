package org.example.bubbleSort;

import java.util.Arrays;

public class LearnBubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] numbers) {
        boolean swapped = false;
        for (int i = 0; i <= numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length - i - 1; j++) {
                if (numbers[j] < numbers[j-1]) {
                    //swap
                    int temp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

}
