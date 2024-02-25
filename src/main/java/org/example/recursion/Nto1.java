package org.example.recursion;

/*
 * Print numbers N to 1
 */
public class Nto1 {
    public static void main(String[] args) {
        printNumbers(5);
        System.out.println("--------------------------------------");
        printNumbersInReverse(5);
    }

    private static void printNumbers(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumbers(n-1);
    }
    private static void printNumbersInReverse(int n) {
        if (n == 0) {
            return;
        }
        printNumbersInReverse(n-1);
        System.out.println(n);
    }
}
