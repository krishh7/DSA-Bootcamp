package org.example.bitwise;

// Find a number os even or odd
public class EvenOrOdd {
    public static void main(String[] args) {
        System.out.println(isOdd(48));
    }

    private static boolean isOdd(int n) {
        return ((n & 1) == 1);
    }
}
