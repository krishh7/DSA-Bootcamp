package org.example.sorting;

import static org.example.arrays.Q1SwapIndex.swap;

/*
https://leetcode.com/problems/first-missing-positive/
 */
public class Q6FindFirstMissingPositive {
    public static void main(String[] args) {
        int[] numbers = {1};
        System.out.println(findFirstMissingPositive(numbers));
    }

    private static int findFirstMissingPositive(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            int correctIndex = numbers[i] - 1;
            if (numbers[i] > 0 && numbers[i] <= numbers.length && numbers[i] != numbers[correctIndex]) {
                swap(numbers, correctIndex, i);
            } else {
                i++;
            }
        }
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != index + 1) {
                return index + 1;
            }
        }
        return numbers.length + 1; //for eg {1}; ans = 2
    }
}
