package org.example.java8features.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Provide an example of a lambda expression to sort a list of strings in alphabetical order.
public class StreamExample4 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Shubman", "Rohit", "Kohli", "Shreyas", "Axar", "Rahul", "Hardik", "Jadeja", "Kuldeep", "Shami", "Varun");
        List<String> sorted = names.stream().sorted().collect(Collectors.toList());
        System.out.println("First :" + sorted);

        //Method 2
        names.sort(String::compareTo);
        System.out.println("Second: " + names);

        //Method 3
        List<String> alphaNames = names.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        System.out.println("Third: " + alphaNames);
    }
}
