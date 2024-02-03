package org.example.sorting;

import java.util.ArrayList;
import java.util.List;

import static org.example.arrays.Q1SwapIndex.swap;

/*
https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
 */
public class Q4FindAllDuplicates {
    public static void main(String[] args) {
        int[] numbers = {4,3,2,7,8,2,3,1};
        System.out.println(findAllDuplicates(numbers));
    }

    private static List<Integer> findAllDuplicates(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            int correctIndex = numbers[i] - 1;
            if (numbers[i] != numbers[correctIndex]) {
                swap(numbers, i, correctIndex);
            } else {
                i++;
            }
        }
        List<Integer> duplicates = new ArrayList<>();
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != index + 1) {
                duplicates.add(numbers[index]);
            }
        }
        return duplicates;
    }
}
