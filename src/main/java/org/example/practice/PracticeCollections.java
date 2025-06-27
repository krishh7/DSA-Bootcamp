package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PracticeCollections {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(11, 11, 22, 33, 444, 555, 666));

        Collections.sort(numbers);
        System.out.println(numbers);
//        Collections.reverse(numbers);
//        System.out.println(numbers);
//        Collections.swap(numbers, 0, 3);
//        System.out.println(numbers);
//        Collections.shuffle(numbers, new Random(1));
//        System.out.println(numbers);

//        List<Integer> unmodifiableNumbers = Collections.unmodifiableList(numbers);
//        System.out.println(unmodifiableNumbers);
//        unmodifiableNumbers.remove(34);
//        System.out.println(unmodifiableNumbers);
//        Integer max = Collections.max(numbers);
//        System.out.println(max);
//
//        Integer min = Collections.min(numbers);
//        System.out.println(min);
//
//        int frequency = Collections.frequency(numbers, 666);
//        System.out.println(frequency);

//        List<Integer> integers = new ArrayList<>(Collections.nCopies(numbers.size(), 0));
//        integers.add(666);
//        boolean disjoint = Collections.disjoint(numbers, integers);
//        System.out.println(disjoint);


        System.out.println(Collections.replaceAll(numbers, 444, 143));
        System.out.println(numbers);
        numbers.add(0, 22);
        System.out.println(numbers);

    }
}
