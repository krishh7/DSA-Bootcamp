package org.example.recursion;

/*
 * sum of digits
 * eg 1024 = 1+0+2+4 = 7
 */
public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(2));
    }
    private static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n%10 + sumOfDigits(n/10);
    }
}
