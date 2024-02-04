package org.example.patterns;

/*

 * * * * *
  * * * *
   * * *
    * *
     *
     *
    * *
   * * *
  * * * *
 * * * * *

 */
public class Pattern12 {
    public static void main(String[] args) {
        pattern12(5);
    }
    private static void pattern12(int n) {
        for (int i = 1; i <= 2 * n; i++) {
            int spaces = i > n ? 2 * n - i + 1: i;
            for (int s = 1; s < spaces; s++) {
                System.out.print(" ");
            }
            int col = i > n ? i - n  : n - i + 1;
            for (int j = 1; j <= col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
