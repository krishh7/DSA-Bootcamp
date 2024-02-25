package org.example.recursion;

/*
 * Product of digits/\.
 * eg 25
 * 2*5 = 10
 */
public class ProductOfDigits {
    public static void main(String[] args) {
        System.out.println(productOfDigits(504));
    }

    private static int productOfDigits(int n) {
        if (n%10 == n) {
            return n;
        }
        return (n%10) * productOfDigits(n/10);
    }
}
