package org.example.recursion;

/*
 * Find total numbers of 0 in a number
 * eg 50503020
 * answer = 4 because 4 zeros are there
 */
public class FindZerosInNumber {
    public static void main(String[] args) {
        System.out.println(findZeros(3989));
    }

    private static int findZeros(int n) {
        int count = 0;
        if (n == 0) {
            return 0;
        }
        int rem = n % 10;
        if (rem == 0) {
            count++;
        }
        return count + findZeros(n/10);
    }
}
