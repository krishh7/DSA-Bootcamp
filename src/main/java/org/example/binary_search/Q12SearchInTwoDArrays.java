package org.example.binary_search;

import java.util.Arrays;

public class Q12SearchInTwoDArrays {
    public static void main(String[] args) {
        int[][] array = {
                {10, 15, 20, 30, 50, 60},
                {15, 21, 27, 29},
                {42, 48, 49, 50, 55}
        };
        System.out.println(findColumns(array));
        System.out.println(Arrays.toString(search(array, 50)));

    }
    //To find max column count
    private static int findColumns(int[][] array) {
        int answer = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            int length = array[i].length;
            if (length > answer) {
                answer = length;
            }
        }
        return answer;
    }
    private static int[] search(int[][] array, int target) {
        int row = 0;
        int column = findColumns(array) - 1;
        while (row < array.length && column > 0) {
            if (array[row][column] == target) {
                return new int[]{row, column};
            }
            if (array[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return new int[]{-1, -1};
    }
}
