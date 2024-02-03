package org.example.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] answer = findTwoSum(numbers, target);
        System.out.println(Arrays.toString(answer));
    }
    private static int[] findTwoSum(int[] numbers, int target) {
        Map<Integer, Integer> secondIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (secondIndex.containsKey(target - numbers[i])) {
                return new int[]{secondIndex.get(target - numbers[i]), i};
            }
            secondIndex.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}
