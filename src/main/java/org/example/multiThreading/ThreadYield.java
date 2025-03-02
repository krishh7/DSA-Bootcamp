package org.example.multiThreading;

public class ThreadYield {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int counter = 0;
            while (counter < 100) {
                System.out.println(Thread.currentThread().getName());
                counter++;
                Thread.yield();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
