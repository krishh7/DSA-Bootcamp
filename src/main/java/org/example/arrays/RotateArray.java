package org.example.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArrayKTimes(input, k);
        System.out.println("------------------");
        System.out.println(Arrays.toString(input));
    }

    private static void rotateArrayKTimes(int[] numbers, int k) {
        int n = numbers.length;
        k = k % n;
        System.out.println(Arrays.toString(numbers));
        reverse(numbers, 0, n - 1); //reverse the whole array first
        System.out.println(Arrays.toString(numbers));
        reverse(numbers, 0, k - 1); // reverse the first k elements
        System.out.println(Arrays.toString(numbers));
        reverse(numbers, k, n - 1); // reverse the remaining elements
        System.out.println(Arrays.toString(numbers));
    }
    private static void reverse(int[] numbers, int start, int end) {
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }
}
