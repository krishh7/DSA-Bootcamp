package org.example.arrays;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] input = {9};
        System.out.println(Arrays.toString(plusOne(input)));
    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 != 10) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
