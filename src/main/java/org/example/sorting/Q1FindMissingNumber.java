package org.example.sorting;

import java.math.BigDecimal;

import static org.example.arrays.Q1SwapIndex.swap;

/*
https://leetcode.com/problems/missing-number/description/
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers,
so all numbers are in the range [0,3].
2 is the missing number in the range since it does not appear in nums.
 */
public class Q1FindMissingNumber {
    public static void main(String[] args) {
        int[] numbers = {3, 0, 1};
        int missing = findMissingNumber(numbers);
        System.out.println("Missing Number is: " + missing);

        BigDecimal decimalValue = new BigDecimal("1214.752");
        System.out.println("Decimal value: " + decimalValue);
    }

    private static int findMissingNumber(int[] numbers) {
        int i = 0;
        while (i <= numbers.length - 1) {
            int correctIndex = numbers[i];
            if (numbers[i] < numbers.length && numbers[i] != numbers[correctIndex]) {
                swap(numbers, i, correctIndex);
            } else {
                i++;
            }
        }
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != index) {
                return index + 1;
            }
        }
        //case 2
        return numbers.length;
    }
}
