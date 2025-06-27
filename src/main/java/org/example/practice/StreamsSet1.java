package org.example.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsSet1 {
    public static void main(String[] args) {

        //1. Find the longest string in a list of strings using Java streams:
        Stream<String> names = Stream.of("Khalil", "Vishal", "Chandra", "Anirudh", "Ajay", "Gayle", "Rahul", "Vishwamithra");
//        System.out.println(names.max((a, b) -> b.length() - a.length()));
        System.out.println(names.max(Comparator.comparingInt(String::length)));

        //2. Calculate the average age of a list of Person objects using Java streams
        record Person(String name, int age){};

        Stream<Person> persons = Stream.of(
                new Person("Krishna", 28),
                new Person("Venky", 28),
                new Person("Shiva", 28),
                new Person("Charan", 28),
                new Person("Tharun", 28),
                new Person("Mahesh", 28),
                new Person("Vishal", 28)
        );

//        System.out.println(persons.collect(Collectors.averagingInt(Person::age)));
        System.out.println(persons.mapToInt(Person::age).average().orElse(0.0));

        //3 Check if list of integers contains prime number or not
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 31);
        System.out.println(numbers.stream().filter(num -> (num == 2 || num == 3) || num % 2 != 0 && num % 3 != 0).collect(Collectors.toList()));


        //4. Merge two sorted lists into a single sorted list using Java streams:
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        System.out.println(Stream.concat(list1.stream(), list2.stream()).sorted((a, b) -> b - a).collect(Collectors.toList()));

        //5Q. Find the intersection of two lists using Java streams:
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list4 = Arrays.asList(3, 4, 5, 8, 10);
        System.out.println(list3.stream().filter(list4::contains).collect(Collectors.toList()));

        //6Q Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> list5 = Arrays.asList(2, 2, 6, 7, 8, 9, 9, 9, 11, 11, 13, 2, 2, 5, 5, 6);
        System.out.println(list5.stream().distinct().collect(Collectors.toList()));

        // 7Q Given a list of Persons, find the sum of age for each person using Java streams:
        Stream<Person> persons2 = Stream.of(
                new Person("Krishna", 28),
                new Person("Venky", 28),
                new Person("Shiva", 28),
                new Person("Charan", 28),
                new Person("Tharun", 28),
                new Person("Mahesh", 28),
                new Person("Vishal", 28)
        );
        System.out.println(persons2.mapToInt(Person::age).sum());

        //8Q. Find the 5th smallest element in an array using Java streams:
        List<Integer> list6 = Arrays.asList(2, 2, 6, 7, 8, 9, 9, 9, 11, 11, 13, 2, 2, 5, 5, 6);
        System.out.println(list6.stream().distinct().sorted().skip(4).findFirst());

        //9Q. Given a list of strings, find the frequency of each word using Java streams:
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        System.out.println(words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        //10Q. Implement a method to partition a list into two groups based on a predicate using Java streams:
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitioned = numbers3.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned);

        //11Q. Given a list of strings, find the longest string using Java streams.
        List<String> strings = Arrays.asList("apple", "banana", "orangearmy", "grape", "kiwi");
        Optional<String> longest = strings.stream().sorted((a, b) -> b.length() - a.length()).findFirst();
        System.out.println(longest);


    }
}
