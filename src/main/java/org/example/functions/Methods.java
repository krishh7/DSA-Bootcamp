package org.example.functions;

import java.util.Scanner;

public class Methods {

    public int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            Scanner input = new Scanner(System.in);
            Methods obj = new Methods();
            System.out.println("Please enter first number : ");
            int a = input.nextInt();
            System.out.println("Please enter second number : ");
            int b = input.nextInt();
            System.out.println("Sum is : " + obj.sum(a, b));
        }
    }
}
