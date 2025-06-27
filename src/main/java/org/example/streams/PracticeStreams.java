package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeStreams {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(2, 5, 8, 12, 12, 15, 15, 17, 24, 27, 30);
        List<String> names = Arrays.asList("Krishna", "Hans", "Rajeev", "Maja", "Deepak");

        //filter even numbers
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        //find max
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        System.out.println(max);

        //find sym
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        //Double the elements
        List<Integer> doubled = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(doubled);

        //Uppercasse the names
        List<String> upperNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperNames);

        //Sort
        List<String> sorted = names.stream().sorted().collect(Collectors.toList());
        System.out.println(sorted);

        //Count
        long count = numbers.stream().filter(n -> n > 5).count();
        System.out.println(count);

        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(5, 6), Arrays.asList(7, 8), Arrays.asList(13, 14), Arrays.asList(25, 36));
        List<Integer> flatted = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(flatted);

        //avoid duplicates
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = numbers.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
        System.out.println(duplicates);

        //find second largest element
        Optional<Integer> first = numbers.stream().sorted(Collections.reverseOrder()).skip(1).findFirst();
        System.out.println(first);

    }
}
