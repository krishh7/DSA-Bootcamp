package org.example.java8features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

//How would you use the Streams API to filter a list of integers to find even numbers and sort them?
public class StreamExample3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 18, 45, 22, 34, 11, 90, 99, 47, 55, 76, 23, 17, 67, 7, 11);

        //1. Sort the list by even numbers
        List<Integer> sortedEvenNumbers = numbers.stream().filter(num -> num % 2 == 0).sorted().collect(Collectors.toList());
        System.out.println(sortedEvenNumbers);

        //2. Calculate Average of Integers using Streams
        OptionalDouble average = numbers.stream().mapToInt(Integer::intValue).average();
        System.out.println(average);

        //3. Calculate the sum of all even, odd numbers in a list using streams.
        int sumOfEvenNumbers = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(sumOfEvenNumbers);
        int sumOfOddNumbers = numbers.stream().filter(n -> n % 2 == 1).mapToInt(Integer::intValue).sum();
        System.out.println(sumOfOddNumbers);

        //4. Count the number of strings in a list that start with a specific letter using streams.
        List<String> names = Arrays.asList("A", "AAA", "AA", "AAAA");
        long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);

        //5. Find the maximum and minimum values in a list of integers using streams.
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println(max);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println(min);

        //6. Given a list of strings, count the number of strings that have a length greater than 1.
        long stringGreaterThan1 = names.stream().filter(s -> s.length() > 1).count();
        System.out.println(stringGreaterThan1);

        //7. Find the frequency of each character in a string using Java 8 streams
        Map<String, Long> frequency = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency: " + frequency );

    }
}
