package org.example.linear_search;

import java.util.Arrays;

//This question is about searching an element in 2D array
public class Q4SearchIn2D_Array {
    public static void main(String[] args) {
        int[][] matrix = {
                {15, 6, 9},
                {15, 7, 13, 5},
                {11, 12, 24, 21, 8},
                {22, 4, 30, 22}

        };

        int target = 9;
        int answer = searchIn2D_Array(matrix, target);
        System.out.println(answer);
        int[] answer2 = searchIn2D_Array2(matrix, target);
        System.out.println(Arrays.toString(answer2));
    }

    private static int searchIn2D_Array(int[][] array, int target) {
        for (int[] rowArray : array) {
            for (int j : rowArray) {
                if (j == target) {
                    return j;
                }
            }
        }
        return -1;
    }

    /*
     * This method is to return the index for e.g.,
     * [2, 3]
     */
    private static int[] searchIn2D_Array2(int[][] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
