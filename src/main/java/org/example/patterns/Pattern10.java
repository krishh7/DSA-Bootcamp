package org.example.patterns;

/*

     *
    * *
   * * *
  * * * *
 * * * * *

 */
public class Pattern10 {
    public static void main(String[] args) {
        pattern10(5);
    }
    private static void pattern10(int n) {
        for (int i = 1; i <= n; i++) {
            int spaces = n - i;
            for (int s = 0; s < spaces; s++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
