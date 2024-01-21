package org.example.linear_search;

/*
 * Question is { {1, 2, 3}, {4, 5, 6}, {7, 8,9} }
 * Need to add individual array elements
 * 1+2+3 = 6
 * 4+5+6 = 15
 * 7+8+9 = 24
 */
public class Q7AddArrayElements {
    public static void main(String[] args) {
        int[][] input = { {1, 5}, {7, 3}, {2, 5} };
        System.out.println(maxWealth(input));

    }

    private static int maxWealth(int[][] array) {
        int total = Integer.MIN_VALUE;
        for (int[] rowArray : array) {
            int sum = 0;
            for (int num : rowArray) {
                sum += num;
            }
            if (sum > total) {
                total = sum;
            }
        }
        return total;
    }
}
