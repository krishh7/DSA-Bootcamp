package org.example.practice;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/first-missing-positive/?envType=problem-list-v2&envId=array
public class PFindFirstMissingNumber {
    public static void main(String[] args) {
        int[] input = {2, 4, 1, 3, 7, 5, 8, 9, 6};
        System.out.println(findFirstMissingNumber(input));
        System.out.println(findMissingNumber2(input));
    }

    private static int findFirstMissingNumber(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            int correctIndex = numbers[i] - 1;
            if (numbers[i] > 0 && numbers[i] <= numbers.length && numbers[i] != numbers[correctIndex]) {
                int temp = numbers[i];
                numbers[i] = numbers[correctIndex];
                numbers[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != index + 1) {
                return index + 1;
            }
        }
        return numbers.length + 1;
    }

    private static int findMissingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int smallest = 1;
        while (set.contains(smallest)) {
            smallest++;
        }
        return smallest;
    }
}
