package org.example.arrays;


import java.util.Arrays;

//https://leetcode.com/problems/build-array-from-permutation/
public class BuildArrayPermutation {
    public static void main(String[] args) {
        int[] numbers = {0,2,1,5,3,4};
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            numbers[i] = numbers[i] + ( numbers[numbers[i]] % n ) * n;
            System.out.println(Arrays.toString(numbers));
        }
        System.out.println("changed numbers" + Arrays.toString(numbers));
        for (int i = 0; i < n; i++) {
            numbers[i] = numbers[i] / n;
        }
        System.out.println(Arrays.toString(numbers));

    }
}
