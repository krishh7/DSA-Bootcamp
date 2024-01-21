package org.example.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LearnStringArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Names");
        String[] names = new String[4];
        for (int i = 0; i < names.length; i++) {
            names[i] = input.next();
        }
        System.out.println(Arrays.toString(names));
        names[3] = "Vishal";
        System.out.println(Arrays.toString(names));
    }
}
