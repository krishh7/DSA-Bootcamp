package org.example.practice.repeat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSet1 {
    public static void main(String[] args) {
        //1. Find the longest string in a list of strings using Java streams:
        Stream<String> names = Stream.of("Khalil", "Vishal", "Chandra", "Anirudh", "Ajay", "Gayle", "Rahul", "Vishwamithra");
        Optional<String> longestString = names.sorted((a, b) -> b.length() - a.length()).findFirst();
        System.out.println(longestString);

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
        OptionalDouble average = persons.mapToInt(Person::age).average();
        System.out.println(average);


        //3 Check if list of integers contains prime number or not
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 31);
        List<Integer> prime = numbers.stream().filter(n -> (n == 2 || n == 3) || n % 2 != 0 && n % 3 != 0).collect(Collectors.toList());
        System.out.println(prime);


        //4. Merge two sorted lists into a single sorted list using Java streams:
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> mergedSorted = Stream.concat(list1.stream(), list2.stream()).sorted().collect(Collectors.toList());
        System.out.println(mergedSorted);

        //5Q. Find the intersection of two lists using Java streams:
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list4 = Arrays.asList(3, 4, 5, 8, 10);
        List<Integer> intersection = list3.stream().filter(list4::contains).collect(Collectors.toList());
        System.out.println(intersection);

        //6Q Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> list5 = Arrays.asList(2, 2, 6, 7, 8, 9, 9, 9, 11, 11, 13, 2, 2, 5, 5, 6);
        List<Integer> unique = list5.stream().distinct().collect(Collectors.toList());
        System.out.println(unique);

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

        int sum = persons2.mapToInt(Person::age).sum();
        System.out.println(sum);

        //8Q. Find the 5th smallest element in an array using Java streams:
        List<Integer> list6 = Arrays.asList(2, 2, 6, 7, 8, 9, 9, 9, 11, 11, 13, 2, 2, 5, 5, 6);
        Optional<Integer> min = list6.stream().min(Integer::compareTo);
        System.out.println(min);

        //9Q. Given a list of strings, find the frequency of each word using Java streams:
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        Map<String, Long> frequency = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequency);

        //10Q. Implement a method to partition a list into two groups based on a predicate using Java streams:
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> evenOdd = numbers3.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(evenOdd);

        //11Q. Given a list of strings, find the longest string using Java streams.
        List<String> strings = Arrays.asList("apple", "banana", "orangearmy", "grape", "kiwi");
        Optional<String> longest = strings.stream().max(String::compareTo);
        System.out.println(longest);

        //12Q Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> list7 = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        List<String> startingWith1 = list7.stream().map(n -> n + "").filter(n -> n.startsWith("1")).collect(Collectors.toList());
        System.out.println(startingWith1);

        //13Q How to find duplicate elements in a given integers list in java using Stream functions?
        List<Integer> list8 = Arrays.asList(10, 15, 8, 10, 49, 25, 49, 98, 32, 15, 8, 21);
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = list8.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
        System.out.println(duplicates);


        //14Q Given the list of integers, find the first element of the list using Stream functions?
        List<Integer> list9 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Optional<Integer> first = list9.stream().findFirst();
        System.out.println(first);

        //15Q Given the list of integers, find the last element of the list using Stream functions?
        List<Integer> list10 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 151232);
        Optional<Integer> last = list10.stream().reduce((first1, second) -> second);
        System.out.println(last);


        //16Q Given a list of integers, find the total number of elements present in the list using Stream functions?
        List<Integer> list11 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 1232);
        Long count = list11.stream().count();
        System.out.println(count);

        //17Q Given a list of integers, find the maximum value element present in it using Stream functions?
        List<Integer> list12 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Optional<Integer> max = list12.stream().max(Integer::compareTo);
        System.out.println(max);


    }
}
