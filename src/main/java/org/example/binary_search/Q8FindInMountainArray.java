package org.example.binary_search;

/*
 * https://leetcode.com/problems/find-in-mountain-array/
 * Find in Mountain array
 * Input: array = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 */
public class Q8FindInMountainArray {
    public static void main(String[] args) {
        //int[] array = {1, 2, 3, 4, 5, 3, 1};
        int[] array = {0, 1, 2, 4, 2, 1};
        int target = 3;
        System.out.println("Answer is : " + findMinIndexOfTarget(array, target));
    }

    private static int findMinIndexOfTarget(int[] array, int target) {
        int peak = findPeakNumber(array);
        return findTarget(array, target, 0, peak);
    }

    private static int findPeakNumber(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            int mid = start +  (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                //You are in decreasing part of the array.
                end = mid;
            } else
                //You are in increasing part of the array
                start = mid + 1;
        }
        return start;
    }

    private static int findTarget(int[] arr, int target, int start, int end) {
         boolean isAsc = arr[start] < arr[end];
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (isAsc) {
                if (target > arr[mid]) {
                    // [1, 4, 5, 7, 9, 10] target = 9;
                    start = mid + 1;
                } else
                    end = mid - 1;
            } else {
                if (target < arr[mid]) {
                    // [10, 9, 7, 5, 4, 1] target = 4
                    start = mid + 1;
                } else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
