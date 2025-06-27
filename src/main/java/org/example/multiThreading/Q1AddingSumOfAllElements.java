package org.example.multiThreading;

/*
 * You are given an array of integers. Implement a Java program to sum up all elements of the array using multiple threads, where:
    You must split the array into equal parts and assign each part to a thread.
    Each thread computes the sum of its part, and the results are combined for the final sum.
 */

import java.util.*;
import java.util.concurrent.*;

class PartialSum implements Callable<Long> {
    private final int[] numbers;
    private final int start;
    private final int end;

    public PartialSum(int[] numbers, int start,int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
public class Q1AddingSumOfAllElements {
    private static final int NUMBER_OF_THREADS = 5;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] numbers = new int[23];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Future<Long>> results = new ArrayList<>();
        int chunkSize = numbers.length / NUMBER_OF_THREADS;
        long finalSum = 0;

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int start = i * chunkSize;
            int end = (i == NUMBER_OF_THREADS - 1) ? numbers.length : start + chunkSize;
            results.add(executor.submit(new PartialSum(numbers, start, end)));
        }

        for (Future<Long> result : results) {
            finalSum += result.get();
        }
        executor.shutdown();
        System.out.println("Final Sum: " + finalSum);

//        Map<Integer, String> nums = new HashMap<>();
//        nums.put(1, "A");
//        nums.put(2, "B");
//        nums.put(1, "C");
//        nums.forEach((k, v) -> System.out.println(k + " = " + v));

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(5);
        numbers2.add(2);
        numbers2.add(8);

        Collections.sort(numbers2, Collections.reverseOrder());
        System.out.println(numbers2);

        List<? extends Number> numbers3 = new ArrayList<Integer>();

    }
}
