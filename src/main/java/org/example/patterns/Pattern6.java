package org.example.patterns;

/*

     *
    **
   ***
  ****
 *****

 */
public class Pattern6 {
    public static void main(String[] args) {
        pattern6(5);
    }

    private static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            int spaces = n - i;
            for (int s = 1; s <= spaces; s++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
