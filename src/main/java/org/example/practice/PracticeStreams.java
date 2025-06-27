package org.example.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 6, 9, 15, 17, 17, 21, 21, 25, 28, 33, 36, 42);

        //Numbers divisible by 3
        List<Integer> collect = numbers.stream().filter(num -> num % 3 == 0).collect(Collectors.toList());
        System.out.println(collect);

        //Squares of even numbers
        List<Integer> squaresOfNumbers = numbers.stream().distinct()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                        .toList();

        System.out.println(squaresOfNumbers);

        //squares of odd numbers
        List<Integer> squaresOfOddNumbers = numbers.stream().distinct()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .toList();
        System.out.println(squaresOfOddNumbers);

        //Count numbers which are > 10
        long count = numbers.stream().filter(n -> n > 10).count();
        System.out.println(count);

        //Count of unique number > 10
        long count2 = numbers.stream().distinct().filter(num -> num > 10).count();
        System.out.println(count2);

        //List numbers which are > 10
        List<Integer> numsGreaterThanTen = numbers.stream()
                .filter(n -> n > 10).toList();
        System.out.println(numsGreaterThanTen);

        //Sort a list of strings in alphabetical order.
        List<String> names = Arrays.asList("Ajay", "Varun", "Teja", "Balu", "Manoj", "Sharath", "Bharath", "Krishna", "Charan", "Tharun", "Venky", "Shiva");
        List<String> sortedNames1 = names.stream().sorted().toList(); //ASC
        System.out.println("Method 1: " + sortedNames1);

        List<String> sortedNames2 = names.stream().sorted((a, b) -> b.length() - a.length()).toList(); //sorted based on length dec
        System.out.println("Method 2: " + sortedNames2);

        List<String> sortedNames3 = names.stream().sorted((a, b) -> b.compareToIgnoreCase(a)).toList(); //DES
        System.out.println("Method 3: " + sortedNames3);

        List<String> sortedNames4 = names.stream().sorted((a, b) -> a.compareToIgnoreCase(b)).toList();
        System.out.println("Method 4: " + sortedNames4);

        //Nested Collection
        List<List<String>> nestedNumbers = Arrays.asList(
                Arrays.asList("55", "41", "32"),
                Arrays.asList("14", "44", "33"),
                Arrays.asList("6", "8", "98")
        );

        List<String> list = nestedNumbers.stream().flatMap(List::stream).toList();
        System.out.println(list);

    }

}
