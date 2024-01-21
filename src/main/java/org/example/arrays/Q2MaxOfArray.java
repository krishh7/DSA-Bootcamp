package org.example.arrays;

//This is to find maximum number in an array

public class Q2MaxOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 11,  8, 9, 12, 1};
        System.out.println(max(arr));
        System.out.println(maxRange(arr, 1, 3));
    }

   /*
    * This method will take an array as input
    * Assumes it's first index as max
    * And iterates over the array
    * if the next index element is greater than assumed
    * Then max value will be replaced its current index
    */
    private static int max(int[] array) {
        int maxVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        return maxVal;
    }

    /*
     * This method will return max values for the provided range
     * It will take array, starting range and ending range
     * it will assume starting index as max, then iterate through the array till end
     * if the current iterate is greater than max value, then max value will be updated
     */
    private static int maxRange(int[] array, int start, int end) {
        int maxVal = array[start];
        for (int i = start; i < end; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        return maxVal;
    }
}
