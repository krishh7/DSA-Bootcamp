package org.example.java8features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 4, 6, 6, 8, 15, 4, 9, 8, 98, 11, 12);

        //Squares of even numbers
        List<Integer> squaresOfEvenNumbers = numbers.stream().distinct().filter(num -> num % 2 == 0).map(num -> num * num).collect(Collectors.toList());
        System.out.println(squaresOfEvenNumbers);

        //Squares of odd numbers
        List<Integer> squaresOfOddNumbers = numbers.stream().distinct().filter(num -> num % 2 == 1).map(num -> num * num).collect(Collectors.toList());
        System.out.println(squaresOfOddNumbers);

        long count = numbers.stream().distinct().filter(num -> num > 5).count();
        System.out.println(count);
    }
}
