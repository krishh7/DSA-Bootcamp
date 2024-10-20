package org.example.binary_search;

//https://leetcode.com/problems/kth-missing-positive-number/
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int missingNumber = missingNumber(input, 2);
        System.out.println(missingNumber);
    }

    private static int missingNumber(int[] array, int k) {
        int start = 0; int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] - mid - 1 < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start + k;
    }
}
