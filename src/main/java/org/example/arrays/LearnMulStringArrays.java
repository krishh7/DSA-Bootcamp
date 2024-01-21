package org.example.arrays;

import java.util.Arrays;

public class LearnMulStringArrays {
    public static void main(String[] args) {

        String[][] names = {
                {"Krish", "Venky", "Shiv"},
                {"Prashanth", "Vikram"},
                {"Varun", "Teja", "Krish", "Ravi"}
        };
        for (String[] iNames : names) {
            System.out.println(Arrays.toString(iNames));
        }
    }
}
