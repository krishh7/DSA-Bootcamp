package org.example.multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter {


//    private int counter;
    private AtomicInteger counter = new AtomicInteger();

//    public int getCounter() {
//        return counter;
//    }
    public int getCounter() {
        return counter.get();
    }

//    public void increment() {
//        counter++;
//    }
    public void increment() {
        counter.incrementAndGet();
    }
}
public class RaceConditionProblem {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main Thread is started");
        SharedCounter sharedCounter = new SharedCounter();

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 is started");
            for (int i = 0; i < 50000; i++) {
                sharedCounter.increment();
            }
            System.out.println("Thread 1 is completed");
        });

        Thread t2 = new Thread( () -> {
            System.out.println("Thread 2 is started");
            for (int i = 0; i < 50000; i++) {
                sharedCounter.increment();
            }
            System.out.println("Thread 2 is completed");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(sharedCounter.getCounter());
        System.out.println("Main Thread is ended");
    }

    /*
     * Here the counter gets incremented by both the threads at a time and the total count is inconsistent.
     * TO get the exact count and no multiple threads are not accessing it use AtomicInteger class.
     */
}
