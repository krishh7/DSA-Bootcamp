package org.example.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
    int[] array = {1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> answer = find4Sum(array, -294967296);
        System.out.println("answer is : " + answer);
    }

    private static List<List<Integer>> find4Sum(int[] numbers, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return list;
        }
        for (int i = 0; i < numbers.length - 3; i++) {
            if (i > 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j > i + 1 && numbers[j] == numbers[j-1]) {
                    continue;
                }
                int k = j + 1, l = numbers.length - 1;
                while (k < l) {
                    long sum = (long) numbers[i] + numbers[j] + numbers[k] + numbers[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        list.add(Arrays.asList(numbers[i], numbers[j], numbers[k], numbers[l]));
                        k++;
                        while ( k < l && numbers[k] == numbers[k-1]) {
                            k++;
                        }
                        l--;
                        while ( k < l && numbers[l] == numbers[l+1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return list;
    }
}
