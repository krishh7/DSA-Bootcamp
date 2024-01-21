package org.example.functions;

import java.util.Arrays;

public class ChangeValue {

    public static void main(String[] args) {
        int[] array = {21, 232, 221, 53, 34};
        System.out.println(Arrays.toString(array));
        change(array);
        System.out.println(Arrays.toString(array));
    }

    private static void change(int[] numbers) {
        numbers[0] = 54;
        numbers[2] = 74;
    }
}
