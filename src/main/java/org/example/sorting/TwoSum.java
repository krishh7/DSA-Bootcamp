package org.example.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {3, 2, 4};
        int target = 6;
        int[] answer = findTwoSum(array, target);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] findTwoSum(int[] numbers, int target) {
        int[] result = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}
