package org.example.binary_search;

public class LearnBinarySearch {
    public static void main(String[] args) {
        int[] numbers = {-16, -12, -8, -5, -2, -1, 0, 2, 4, 5, 7, 12, 16, 21, 28, 32, 36, 42, 50};
        int[] numbers2 = {90, 87, 81, 75, 66, 52, 44, 39, 31, 27, 22, 19, 15, 11, 7, 4, 1, 0};

        int find = 22;
        int answer = findByBinarySearch(numbers, find);
        int answer2 = findByBinarySearchDes(numbers2, find);
        System.out.println("Target is at index : " + answer);
        System.out.println("Target is at index : " + answer2);
    }

    /*
     * assumed the array is sorted in ascending order
     */
    private static int findByBinarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (target > array[mid]) {
                start = mid + 1;
            } else if (target < array[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /*
     * Assumed the array is sorted in descending order
     * int[] array = {90, 87, 81, 75, 66, 52, 44, 39, 31, 27, 22, 19, 15, 11, 7, 4, 1, 0};
     * find 52;
     */
    private static int findByBinarySearchDes(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > array[mid]) {
                end = mid - 1;
            } else if ( target < array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
