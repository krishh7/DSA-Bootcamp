package org.example.sorting;

import java.util.ArrayList;
import java.util.List;

import static org.example.arrays.Q1SwapIndex.swap;

/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
 */
public class Q2FindAllDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findAllMissingNumbers(nums));
    }

    private static List<Integer> findAllMissingNumbers(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            int correctIndex = numbers[i] - 1;
            if (numbers[i] != numbers[correctIndex]) {
                swap(numbers, i, correctIndex);
            } else {
                i++;
            }
        }
        List<Integer> missing = new ArrayList<>();
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != index+1) {
                missing.add(index+1);
            }
        }
        return missing;
    }
}
