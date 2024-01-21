package org.example.questions.problem2;

import java.util.Scanner;

/*
Find if the number is Armstrong number or not.
Find all the 3 digit Armstrong Numbers.
 */
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number ");
        int number = input.nextInt();
        System.out.print("The number is Armstrong number! ");
        System.out.println(isArmstrongNumber(number));

        /*
        Printing all 3 digit Armstrong numbers.
         */
        System.out.print("All 3 digit Armstrong numbers are : ");

        for (int i = 100; i <= 999; i++) {
            if (isArmstrongNumber(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    private static boolean isArmstrongNumber(int number) {
        int temp = number;
        int sum = 0;

        while(number > 0) {
            int rem = number % 10;
            number = number / 10;
            sum += (rem*rem*rem);
        }
        return sum == temp;
    }
}
