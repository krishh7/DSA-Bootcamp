package org.example.recursion;

/*
 * Factorial of a number
 * 5! = 5*4*3*2*1 = 120
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static int factorial(int n) {
        if (n <= 0) {
            return 1;
        }

        return n * factorial(n-1);
    }
}
