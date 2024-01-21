package org.example.binary_search;

public class LearnOrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] incNumbers = {-16, -12, -8, -5, -2, -1, 0, 2, 4, 5, 7, 12, 16, 21, 28, 32, 36, 42, 50};
        int[] decNumbers = {90, 87, 81, 75, 66, 52, 44, 39, 31, 27, 22, 19, 15, 11, 7, 4, 1, 0};
        int target = 7;
        System.out.println(orderAgnosticBinarySearch(incNumbers, target));
        System.out.println(orderAgnosticBinarySearch(decNumbers, target));
    }

    private static int orderAgnosticBinarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        //Finds which sorting true = asc or dcs
        boolean isAscSorted = array[start] < array[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == array[mid]) {
                return mid;
            }
            if (isAscSorted) {
                if (target > array[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < array[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
