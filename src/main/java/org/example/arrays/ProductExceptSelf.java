package org.example.arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }

    private static int[] productExceptSelf(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefixProduct;
            prefixProduct *= numbers[i];
        }
        System.out.println(Arrays.toString(answer));
        System.out.println("----------------");

        int suffixProduct = 1;
        for (int j = n - 1; j >= 0; j--) {
            answer[j] *= suffixProduct;
            suffixProduct *= numbers[j];
        }
        return answer;

    }
}
