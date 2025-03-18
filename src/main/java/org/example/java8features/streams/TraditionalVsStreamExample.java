package org.example.java8features.streams;

import java.util.ArrayList;

public class TraditionalVsStreamExample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(7);
        numbers.add(8);


        //Traditional Way
        int totalSum = 0;
        for (int num : numbers) {
            if (num % 2 != 0) {
                int square = num * num;
                totalSum += square;
            }
        }
        System.out.println("Sum of Squares of even numbers: " + totalSum);

        //Streams
        double sum = numbers.stream().filter(num -> num % 2 != 0).mapToDouble(num -> num * num).sum(); //Can use mapToInt or mapToDouble based on the data you are operating on.
        System.out.println("Stream sum: " + sum);

    }
}
