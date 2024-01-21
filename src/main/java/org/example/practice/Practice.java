package org.example.practice;


public class Practice {
    public static void main(String[] args) {
        int[][] input = { {1, 5}, {7, 3}, {2, 5} };
        System.out.println(maxWealth(input));


    }
    private static int maxWealth(int[][] number) {
        int total = Integer.MIN_VALUE;
        for (int[] rowArray : number) {
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
