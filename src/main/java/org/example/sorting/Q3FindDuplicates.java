package org.example.sorting;


import static org.example.arrays.Q1SwapIndex.swap;

/*
https://leetcode.com/problems/find-the-duplicate-number/description/
Input: nums = [1,3,4,2,2]
Output: 2
 */
public class Q3FindDuplicates {
    public static void main(String[] args) {
        int[] numbers = {1,3,4,4,2};
        int answer = findDuplicate(numbers);
        System.out.println(answer);
    }

    private static int findDuplicates(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            if (numbers[i] != i + 1) {
                int correctIndex = numbers[i] - 1;
                if (numbers[i] != numbers[correctIndex]) {
                    swap(numbers, i, correctIndex);
                } else {
                    return numbers[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    //Second method
    private static int findDuplicate(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            int correctIndex = numbers[i] - 1;
            if (numbers[i] != numbers[correctIndex]) {
                swap(numbers, i, correctIndex);
            } else {
                i++;
            }
        }
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != index + 1) {
                return numbers[index];
            }
        }
        return -1;
    }
}
