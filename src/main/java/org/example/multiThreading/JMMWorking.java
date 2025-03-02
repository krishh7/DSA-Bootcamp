package org.example.multiThreading;


public class JMMWorking {

    public static Object sharedObject = new Object();

    public static void main(String[] args) {

        System.out.println("Main thread is started");
        Runnable runnable1 = () -> {
            System.out.println("Thread 1 is started ");
            System.out.println(Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getName());
            System.out.println(sharedObject.hashCode());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 1 is completed");
        };

        Runnable runnable2 = () -> {
            System.out.println("Thread 2 is started");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            System.out.println(sharedObject.hashCode());
            try {
                Thread.sleep(2000);
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 is completed");
        };

        Thread thread1 = new Thread(runnable1, "Runnable Thread 1");
        thread1.start();
        Thread thread2 = new Thread(runnable2, "Runnable Thread 2");
        thread2.start();

        System.out.println("Main Thread completed");
    }
}
