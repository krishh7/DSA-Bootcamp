package org.example.multiThreading;

/*
 * 3 ways of creating a thread
 *  1. Extending Thread class
 *  2. Implementing Runnable interface
 *  3. Lambda Expression
 */

//Defining a new class which extends Thread class is legacy
class MyThread extends Thread {

    public void run() {
        System.out.println("Started Thread 1");
    }
}
public class LearnMultiThreading {
    public static void main(String[] args) {

        System.out.println("Main Thread started");

        MyThread newThread = new MyThread(); //Legacy way of creating threads
        newThread.start();

        //Not so efficient
        Thread thread2 = new Thread( () ->
                System.out.println("Started Thread 2")
        );
        thread2.start();

        //Best way is to use Runnable interface
        Runnable runnable = () -> {
            System.out.println("Starting Thread 3");
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 3 is completed");
            System.out.println(Thread.currentThread().getState());
            System.out.println(Thread.currentThread().getId());
            System.out.println(Thread.currentThread().getPriority());

        };

        Thread thread3 = new Thread(runnable, "Runnable Thread");
        thread3.setDaemon(true); //Your main thread was not getting exit until your 3rd thread is completed.
        //For main thread to get out as the 3rd thread is sleeping  for 20 secs.
        //defining that 3rd thread to demon thread can help your main thread to exit without waiting for that
        // 3rd thread to be completed.
        thread3.start();
        System.out.println("Main Thread completed");
    }

}
