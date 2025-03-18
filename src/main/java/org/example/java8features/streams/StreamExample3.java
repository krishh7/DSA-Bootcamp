package org.example.java8features.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//How would you use the Streams API to filter a list of integers to find even numbers and sort them?
public class StreamExample3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 18, 45, 22, 34, 11, 90, 99, 47, 55, 76, 23, 17, 67, 7, 11);
        List<Integer> sortedEvenNumbers = numbers.stream().filter(num -> num % 2 == 0).sorted().collect(Collectors.toList());
        System.out.println(sortedEvenNumbers);
    }
}
