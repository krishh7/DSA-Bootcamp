package org.example.linear_search;

//This question is to find max number in an 2D array
public class Q5findMaxNumberIn2D_Array {
    public static void main(String[] args) {
        int[][] matrix = {
                {15, 6, 9},
                {15, 7, 13, 5},
                {11, 12, 247, 21, 8},
                {22, 4, 30, 22}

        };
        System.out.println(maxNumber(matrix));

    }

    private static int maxNumber(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] rowArray : array) {
            for (int number : rowArray) {
                if (max < number) {
                    max = number;
                }
            }
        }
        return max;
    }
}
