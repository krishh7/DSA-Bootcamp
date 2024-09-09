package org.example.arrays;

import java.util.ArrayList;

public class SpiralMatrix {
    static ArrayList<Integer> spiral = new ArrayList<>();

    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        spiral = findSpiralMatrix(input);
        System.out.println(spiral);

    }

    static ArrayList<Integer> findSpiralMatrix(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        int total = m * n; int count = 0;
        int startRow = 0; int endRow = m - 1;
        int startCol = 0; int endCol = n - 1;

        while (count < total ){
            //Traverse top row from left to right
            for (int i = startRow; count < total && i <= endCol; i++) {
                spiral.add(matrix[startRow][i]);
                count++;
            }
            startRow++;

            //Traverse right colum from top to bottom
            for (int i = startRow; count < total && i <= endRow; i++) {
                spiral.add(matrix[i][endCol]);
                count++;
            }
            endCol--;

            //Traverse bottom row from right to left
            for (int i = endCol; count < total && i >= startCol; i--) {
                spiral.add(matrix[endRow][i]);
                count++;
            }
            endRow--;

            //Traverse left column from bottom to top
            for (int i = endRow; count < total && i >= startRow; i--) {
                spiral.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
        }
        return spiral;
    }
}
