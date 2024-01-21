package org.example;

import java.util.Scanner;

public class Conditions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

//        int max = a;
//        if(b > max)
//            max = b;
//        if(c > max)
//            max = c;
//
//        System.out.println(max);

        /* second approach
         *
         */

        int max = Math.max(c, Math.max(a, b));
        System.out.println(max);
    }
}
