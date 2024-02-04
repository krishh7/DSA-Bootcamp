package org.example.patterns;

/*

 * * * * * * * * *
   * * * * * * *
     * * * * *
       * * *
         *



 */
public class Pattern9 {
    public static void main(String[] args) {
        pattern9(5);
    }
    private static void pattern9(int n) {
        for (int i = 0; i < n; i++) {
            int spaces = 2 * i ;
            for (int s = 0; s < spaces; s++) {
                System.out.print(" ");
            }
            int totalCol = 2 * n - 2 * i - 1;
            for (int j = 0; j < totalCol; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
