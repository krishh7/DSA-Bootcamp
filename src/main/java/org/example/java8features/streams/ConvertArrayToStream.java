package org.example.java8features.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertArrayToStream {
    public static void main(String[] args) {

        int[] numbers = {1, 3, 4, 5, 6, 7};
        IntStream stream = Arrays.stream(numbers); // Use this method for primitive arrays
        stream.forEach(System.out::println);
        System.out.println("--------------");

        Integer[] numbers2 = {2,3, 4, 44, 555, 33};
        Stream<Integer> streamOfWrapper = Stream.of(numbers2); // Use this method for wrapper arrays
        streamOfWrapper.forEach(System.out::println);

    }
}
