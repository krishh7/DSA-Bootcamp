package org.example.leet_code;

// https://leetcode.com/problems/monotonic-array/

/*
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * Given an integer array nums, return true if the given array is monotonic, or false otherwise.
 *
 * Input: nums = [1,2,2,3]
 * Output: true
 */
public class Q1IsMonotonic {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
//        int[] nums = {3, 4, 1, 1};
        System.out.println(isMonotonic(nums));
    }

    private static boolean isMonotonic(int[] array) {
        return increasing(array) || decreasing(array);
    }

    private static boolean increasing(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean decreasing(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                return false;
            }
        }
        return true;
    }
}
