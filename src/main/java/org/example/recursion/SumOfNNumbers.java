package org.example.recursion;

/*
 * Sum of N numbers
 * N = 5
 * 1 + 2 + 3 + 4 + 5 = 15
 */
public class SumOfNNumbers {
    public static void main(String[] args) {
        System.out.println(sumOfNumbers(5));
    }
    private static int sumOfNumbers(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNumbers(n-1);
    }
}
