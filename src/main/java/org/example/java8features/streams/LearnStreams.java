package org.example.java8features.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LearnStreams {
    public static void main(String[] args) {

        //Difference between Collection and stream
        //Using Collection
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        numbers.add(3);
        numbers.add(18);
        numbers.add(24);
        numbers.add(32);
        numbers.add(45);
        numbers.add(55);

        for (int num : numbers) {
            if (num % 3 == 0) {
                answer.add(num);
            }
        }
        System.out.println(numbers);
        System.out.println(answer);

        //Using streams
        List<Integer> optionalAnswer = numbers.stream().filter(num -> num % 3 == 0).collect(Collectors.toList());
        System.out.println(optionalAnswer);
    }
}
