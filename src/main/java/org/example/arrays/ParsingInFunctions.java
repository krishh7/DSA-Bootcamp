package org.example.arrays;

import java.util.Arrays;

public class ParsingInFunctions {
    public static void main(String[] args) {

        int[] nums = {60, 55, 62, 70, 61};
        System.out.println(Arrays.toString(nums));
        change(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void change(int[] arr) {
        arr[1] = 68;
        arr[4] = 72;
    }
}
