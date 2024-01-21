package org.example.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LearnArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] phoneNumber = new int[6];
        System.out.println("Enter phone number");

        //for many inputs
        for(int i = 0; i < phoneNumber.length; i++) {
            phoneNumber[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(phoneNumber));

        System.out.println("Enter roll number");

        //enhanced for loop
        for (int rNum : phoneNumber) {
            rNum = input.nextInt();
            System.out.print(rNum + " ");
        }
    }
}
