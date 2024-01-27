package org.example.bubbleSort;

import java.util.Arrays;

public class LearnBubbleSort {
    public static void main(String[] args) {
        int[] array = {15, 23, 43, 32, 1, 2, 45, 12};
        int[] array2 = {1, 2, 3, 4, 5, 6};
        int[] array3 = {-32, -78, -1, 25, 13, 45, 15, -66};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        efficientBubbleSort(array2);
        efficientBubbleSort(array3);
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
    }

    private static void bubbleSort(int[] array) {
        //run the steps for n-1 times
        for (int i = 0; i < array.length; i++) {
            //for each step the max num will come at the last respective index
            for (int j = 1; j < array.length - i; j++) {
                //swap if the num is smaller than previous item
                if (array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    /*
    The above method has a minor problem that in case of a sorted array given like
    [1, 2, 3, 4, 5] the swap will never happen but the loop runs for i = 0 to i = N-1
    To avoid that we knew if the swap not happened for any i = something then that array has been sorted.
    Meaning we can stop the loop.
     */
    private static void efficientBubbleSort(int[] array) {
        boolean swapped = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
