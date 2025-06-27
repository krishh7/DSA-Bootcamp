package org.example.java8features.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LearnMapVsFlatMap {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Rahul", "Virat", "Rohit", "Jadeja"));
        List<String> upperCaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseNames);

        //Nested Collection
        List<List<Integer>> nestedNumbers = Arrays.asList(
                Arrays.asList(55, 41, 32),
                Arrays.asList(14, 44, 33),
                Arrays.asList(6, 8, 98)
        );
        List<Integer> collect = nestedNumbers.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(collect);
    }
}
