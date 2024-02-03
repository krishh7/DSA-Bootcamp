package org.example.sorting;

import java.util.ArrayList;
import java.util.List;

import static org.example.arrays.Q1SwapIndex.swap;

/*
https://leetcode.com/problems/set-mismatch/description/
Input: nums = [1,2,2,4]
Output: [2,3]
 */
public class Q5SetMismatch {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 4};
        System.out.println(setMismatch(numbers));
    }

    private static List<Integer> setMismatch(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            int correctIndex = numbers[i] - 1;
            if (numbers[i] != numbers[correctIndex]) {
                swap(numbers, i, correctIndex);
            } else {
                i++;
            }
        }
        List<Integer> mismatched = new ArrayList<>();
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != index + 1) {
                mismatched.add(index+1);
                mismatched.add(numbers[index]);
            }
        }
        return mismatched;
    }
}
