package org.example.arrays;

import java.util.Arrays;

public class MixedArray {
    public static void main(String[] args) {
        Object[] array = {1, 4, 6, "abc", 67, 72,"ghk", "xyz"};
        System.out.println(Arrays.toString(intArray(array)));

    }

    private static Object[] intArray(Object[] mixedArray) {
        return Arrays.stream(mixedArray).filter(arr -> arr instanceof Integer).toList().toArray();
    }
}
