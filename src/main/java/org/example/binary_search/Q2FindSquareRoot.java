package org.example.binary_search;

import java.util.Scanner;

//This is to find square root of a number using inbuilt functions.
public class Q2FindSquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number");
        int number = scanner.nextInt();
        int squareRoot = (int) Math.sqrt(number);
        if (squareRoot * squareRoot == number) {
            System.out.print("Square root is: " + squareRoot);
        } else {
            System.out.println("Number is not a perfect square");
        }
    }
}
