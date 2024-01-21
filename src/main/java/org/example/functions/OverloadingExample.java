package org.example.functions;

import java.util.Scanner;

public class OverloadingExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter numbers");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        addNumbers(a, b, c);
        addNumbers(a, b);
    }

    private static void addNumbers(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println("Sum of three numbers is : " + sum );

    }
    private static void addNumbers(int a, int b) {
        int sum = a + b;
        System.out.println("Sum of two numbers is : " + sum);

    }
}
