package org.example.functions;

import java.util.Arrays;
import java.util.Scanner;

public class SwappingNumbers {

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.print(a + " ");
        System.out.print(b);
    }

    public void changeArray(int[] arr) {
        arr[0] = 99;
    }

    public static void main(String[] args) {
        SwappingNumbers obj = new SwappingNumbers();
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int[] array = {1, 2,56,567,7866};
        System.out.print("Swapped numbers are : ");
        obj.swap(num1, num2);
        System.out.println();
        obj.changeArray(array);
        System.out.println(Arrays.toString(array));

    }
}
