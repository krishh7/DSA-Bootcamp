package org.example.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        // Convert the integers to strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort the array with a custom comparator
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // reverse order to get the largest number
            }
        });

        // If the largest number is "0", the result is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the largest number from the sorted array
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }

    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();
        int[] nums = {1, 2};
        System.out.println(solution.largestNumber(nums)); // Output: "9534330"
    }
}