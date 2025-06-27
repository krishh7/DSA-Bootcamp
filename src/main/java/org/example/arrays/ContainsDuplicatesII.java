package org.example.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicatesII {
    public static void main(String[] args) {
        int[] input = {1, 0, 1, 1, 2, 3};
        System.out.println(containsDuplicatesII(input, 1));
    }

    private static boolean containsDuplicatesII(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val) && i-map.get(val) <= k) {
                return true;
            }
            map.put(val, i);
        }
        return false;
    }
}
