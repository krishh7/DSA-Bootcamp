package org.example.practice;

import java.util.Arrays;

public class PFindIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {  {2, 9, 18},
                            {4, 10, 19},
                            {6, 15, 22},
                            {7, 16, 23}
                        };
        int[] answer = search(matrix, 4);
        System.out.println(Arrays.toString(answer));
    }
    //This way TC = O(N);
    private static int[] search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            }
            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return new int[]{-1, -1};
    }
}
