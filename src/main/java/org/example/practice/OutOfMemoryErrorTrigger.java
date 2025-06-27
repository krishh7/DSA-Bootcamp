package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class OutOfMemoryErrorTrigger {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            numbers.add(5);
        }


    }
}
