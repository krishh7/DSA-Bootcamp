package org.example.arrays;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] question = {1, 2, 3, 2, 2,  1, 1, 3, 2, 0, 2, 2};
        int answer = numIdenticalPairs(question);
        System.out.println(answer);

    }
    public static int numIdenticalPairs(int[] nums) {
        int[] frequency = new int[101];
        int count = 0;
        for (int n : nums) {
            count += frequency[n];
            frequency[n]++;
        }
        System.out.println(Arrays.toString(frequency));
        return count;
    }
}
