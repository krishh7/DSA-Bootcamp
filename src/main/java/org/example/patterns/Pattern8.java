package org.example.patterns;

/*

         *
       * * *
     * * * * *
   * * * * * * *
 * * * * * * * * *

 */
public class Pattern8 {
    public static void main(String[] args) {
        pattern8(5);
    }
    private static void pattern8(int n) {
        for (int i = 1; i <= n; i++) {
            for (int s = 0; s < n - i; s++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= (2 * i) - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
