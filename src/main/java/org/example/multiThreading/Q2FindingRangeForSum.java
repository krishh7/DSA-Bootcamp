package org.example.multiThreading;

/*
 * You are given an array of integers. Implement a Java program to sum up all elements of the array using multiple threads, where:
    You must split the array into equal parts and assign each part to a thread.
    Each thread computes the sum of its part, and the results are combined for the final sum.
    *
    * For this know find range from which element to which element the thread range is?
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CalculateRange implements Runnable {
    private final int[] numbers;
    private final int start, end;

    public CalculateRange(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " processing from " + start + " to " + end);
    }
}
public class Q2FindingRangeForSum {
    private static final int THREAD_COUNT = 5;
    public static void main(String[] args) {
        int[] numbers =  new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        int chunkSize = numbers.length/THREAD_COUNT;

        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * chunkSize;
            int end = (i == THREAD_COUNT - 1) ? numbers.length - 1 : start + (chunkSize - 1);
            executor.execute(new CalculateRange(numbers,start, end));
        }
        executor.shutdown();
    }
}
