package org.example.functions;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun(1, 11, 8, 9, 12, 1);
    }

    private static void fun(int... numbers) {
        System.out.println(Arrays.toString(numbers));
    }
}
