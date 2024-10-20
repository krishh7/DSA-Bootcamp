package org.example.practice;

import java.util.Arrays;

public class PTwoSum {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        int[] answer = twoSum(input, target);
        System.out.println(Arrays.toString(answer));

    }
    private static int[] twoSum(int[] numbers, int target) {
        int start = 0; int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                return new int[]{start, end};
            }
        }
        return new int[]{-1, -1};
    }
}
