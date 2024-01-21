package org.example.binary_search;

import java.util.Arrays;

/*
 * Find first and last position of an element in a sorted array.
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Q5FindFirstAndLastPositionOfAnElement {
    public static void main(String[] args) {
        int[] numbers = {5,7,7,8,8,8,8,8,8,8,8,8,8,8,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(getFirstAndLast(numbers, target)));

    }
    private static int[] getFirstAndLast(int[] numbers, int target) {
        int[] answer = {-1, -1};
        int start = searchFistAndLast(numbers, target, true);
        int end = searchFistAndLast(numbers, target, false);
        answer[0] = start;
        answer[1] = end;
        return answer;
    }

    private static int searchFistAndLast(int[] numbers, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = numbers.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (target > numbers[mid]) {
                start = mid + 1;
            } else if (target < numbers[mid]) {
                end = mid - 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else
                    start = mid + 1;
            }
        }
        return ans;
    }
}
