package org.example.patterns;

/*

 * * * * *
  * * * *
   * * *
    * *
     *

 */
public class Pattern11 {
    public static void main(String[] args) {
        pattern11(5);
    }
    private static void pattern11(int n) {
        for (int i = 0; i < n; i++) {
            for (int s = 0; s < i; s++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
