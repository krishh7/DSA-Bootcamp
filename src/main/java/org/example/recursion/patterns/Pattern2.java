package org.example.recursion.patterns;

/*
 *
 * *
 * * *
 * * * *
 * * * * *
 */
public class Pattern2 {
    public static void main(String[] args) {
        pattern2(5, 0);
    }

    private static void pattern2(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            pattern2(r, c + 1);
            System.out.print("* ");
        } else {
            pattern2(r - 1, 0);
            System.out.println();
        }
    }
}
