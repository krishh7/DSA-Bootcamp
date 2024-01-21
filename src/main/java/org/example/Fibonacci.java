package org.example;

import java.util.Scanner;


/*
 * Fibonacci series program
 */
public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = 0;
        int b = 1;
        int count = 2;
        System.out.print("Fibonacci series is : ");
        System.out.print(a + " ");
        System.out.print(b + " ");

        while(count <= n) {
            int temp = b;
            b += a;
            a = temp;
            count++;
            System.out.print(b + " ");
        }
    }
}
