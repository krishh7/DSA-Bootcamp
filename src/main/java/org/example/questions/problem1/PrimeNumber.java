package org.example.questions.problem1;

/*
Check whether the number is prime or not
 */

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number");
        int number = input.nextInt();
        System.out.print("The entered number is a prime number! ");
        System.out.print(isPrime(number));
    }

    private static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        int a = 2;
        while(a * a <= number) {
            if(number % a == 0)
                return false;
            a++;
        }
        return a * a > number;
    }
}
