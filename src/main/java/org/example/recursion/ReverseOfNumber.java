package org.example.recursion;

/*
 * Reverse a number
 * 56789 = 98765
 */
public class ReverseOfNumber {
    static int sum = 0;
    public static void main(String[] args) {
        reverse(56789);
        System.out.println(sum);
    }

    private static void reverse(int n) {
        if (n == 0) {
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverse(n/10);
    }
}
