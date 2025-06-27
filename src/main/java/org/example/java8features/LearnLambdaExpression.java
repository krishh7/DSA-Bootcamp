package org.example.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@FunctionalInterface
interface MathOperation {
    public abstract int operate(int a, int b);
}

public class LearnLambdaExpression {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("Thread is starting");
            System.out.println("------------------");
        };
        Thread t1 = new Thread(runnable);
        t1.start();

        //Using with Collections
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        numbers.forEach(n -> System.out.println(n));
        System.out.println("----------------------");

        //Using with Custom Functional Interface
        MathOperation addition = (a, b) -> a + b;
        MathOperation multiplication = (a, b) -> a * b;
        System.out.println("addition: " + addition.operate(5, 4));
        System.out.println("multiplication: " + multiplication.operate(5, 4));
        System.out.println("----------------------");

        // Using with Stream API
        List<Integer> numbers2 = List.of(3, 4, 5, 6, 7, 8);
        List<Integer> squaredNumbers = numbers2.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(squaredNumbers);
        System.out.println("----------------------");

        //Using Stream API eg2

        ArrayList<Integer> oddNumbers = new ArrayList<>(Arrays.asList(3, 5, 7, 9, 11, 13, 15));
        List<Integer> doubledOddNumbers = oddNumbers.stream().map(odd -> odd * 2).collect(Collectors.toList());
        System.out.println(doubledOddNumbers);
        System.out.println("----------------------");

        //Find second largest numbers in the list
        ArrayList<Integer> someNumbers = new ArrayList<>(Arrays.asList(3, 5, 7, 9, 44, 21, 110,111, 55, 36, 30, 36, 26, 11, 13, 15));
        Optional<Integer> secondLargestNumber = someNumbers.stream().distinct().sorted((a, b) -> b - a).skip(1).findFirst();
        secondLargestNumber.ifPresent(answer -> System.out.println(answer));

        Optional<Integer> smallerNumber = someNumbers.stream().max(Integer::compareTo);
        smallerNumber.ifPresent(answer -> System.out.println(answer));
    }
}
