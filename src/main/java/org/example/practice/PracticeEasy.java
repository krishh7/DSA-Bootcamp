package org.example.practice;

import java.util.concurrent.atomic.AtomicInteger;

class SharedResource {
    public int counter;

    public int getCounter() {
        return counter;
    }

    public synchronized void increment() {
        counter++;
    }
}
public class PracticeEasy {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");
        SharedResource sharedResource = new SharedResource();

        Runnable runnable1 = () -> {
            for (int i = 0; i < 5000; i++) {
                sharedResource.increment();
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 5000; i++) {
                sharedResource.increment();
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(sharedResource.getCounter());

        System.out.println("Main thread ended");
    }
}
