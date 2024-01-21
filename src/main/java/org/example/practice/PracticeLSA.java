package org.example.practice;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Pivot = max number / peak number
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */
public class PracticeLSA {
    public static void main(String[] args) {
        int[] array = {7,2,5,10,8};
        int chunks = 2;
        System.out.println(splitArray(array, chunks));
    }

    private static int splitArray(int[] array, int chunks) {
        int start = 0;
        int end = 0;
        for (int i : array) {
            start = Math.max(start, i);
            end += i;
        }
        while (start < end) {
            int mid = start + (end - start)/2;
            int sum = 0;
            int pieces = 1;
            for (int i : array) {
                if (sum + i > mid) {
                    sum = i;
                    pieces++;
                } else {
                    sum += i;
                }
            }
            if (pieces > chunks) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}
