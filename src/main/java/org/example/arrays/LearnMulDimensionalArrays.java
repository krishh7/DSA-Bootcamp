package org.example.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LearnMulDimensionalArrays {
    public static void main(String[] args) {

        /*
            1 2 3
            4 5 6
            7 8 9
         */

        Scanner input = new Scanner(System.in);
        int[][] number = new int[3][3];

        //Just load input
        for (int row = 0; row < number.length; row++) {
            for(int col = 0; col < number[row].length; col++) {
                number[row][col] = input.nextInt();
            }
        }

        //This is printing output
        for (int row = 0; row < number.length; row++) {
            for (int col = 0; col < number[row].length; col++) {
                System.out.print(number[row][col] + " ");
            }
            System.out.println();
        }

        //Using Arrays.toString()
        for ( int row = 0; row < number.length; row++) {
            System.out.println(Arrays.toString(number[row]));
        }

        System.out.println();

        //using enhanced for loop
        for (int[] num : number) {
            System.out.println(Arrays.toString(num));
        }
    }
}
