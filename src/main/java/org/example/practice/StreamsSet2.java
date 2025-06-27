package org.example.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsSet2 {
    public static void main(String[] args) {

        //1Q Given a list of integers, find out all the numbers starting with 1 using Stream functions?
        List<Integer> list1 = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        List<String> numbersStartingWith1 = list1.stream().map(n -> n + "")
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(numbersStartingWith1);

        //2Q How to find duplicate elements in a given integers list in java using Stream functions?
        List<Integer> list2 = Arrays.asList(10, 15, 8, 10, 49, 25, 49, 98, 32, 15, 8, 21);
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = list2.stream().filter(n -> !set.add(n)).collect(Collectors.toList());
        System.out.println(duplicates);

        //3Q Given the list of integers, find the first element of the list using Stream functions?
        List<Integer> list3 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Optional<Integer> first = list3.stream().findFirst();
        System.out.println(first);

        //4Q Given a list of integers, find the total number of elements present in the list using Stream functions?
        List<Integer> list4 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        long count = list4.stream().count();
        System.out.println(count);

        //5Q Given a list of integers, find the maximum value element present in it using Stream functions?
        List<Integer> list5 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        OptionalInt max = list5.stream().mapToInt(Integer::intValue).max();
        System.out.println(max);

        //6Q Given a String, find the first non-repeated character in it using Stream functions?
        String input = "Java articles are Awesome";
//        Arrays.stream(input.chars().toArray()).mapToObj(String::toLowerCase);
    }
}
