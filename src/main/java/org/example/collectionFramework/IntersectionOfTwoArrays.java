package org.example.collectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 2, 1, 2, 2, 2, 2, 2, 3};
        int[] array2 = {2, 2};
        int[] intersection = findIntersection(array1, array2);
        System.out.println(Arrays.toString(intersection));
    }

    private static int[] findIntersection(int[] numbers1, int[] numbers2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int number : numbers1) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        for (int number : numbers2) {
            if (map.containsKey(number) && map.get(number) > 0) {
                result.add(number);
                map.put(number, map.get(number) - 1);
            }
        }

        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }
        return intersection;
    }
}
