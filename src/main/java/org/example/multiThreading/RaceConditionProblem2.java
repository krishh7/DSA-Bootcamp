package org.example.multiThreading;

class SharedCounter2 {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public synchronized void increment() {
        counter++;
    }
}
public class RaceConditionProblem2 {

    public static void main(String[] args) throws InterruptedException {
        SharedCounter2 counter2 = new SharedCounter2();
        System.out.println("Main thread is started");

        Thread t1 = new Thread( () -> {
            System.out.println("Thread 1 has started");

            for (int i = 0; i < 50000; i++) {
                counter2.increment();
            }
            System.out.println("Thread 1 has ended");
        });

        Thread t2 = new Thread( () -> {
            System.out.println("Thread 2 has started");

            for (int i = 0; i < 50000; i++) {
                counter2.increment();
            }
            System.out.println("Thread 2 has ended");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Main thread is ended");
        System.out.println("Total count is " + counter2.getCounter());
    }

    /*
    ** This problem is can also be solved using Synchronized keyword instead of using AtomicInteger;
    * This approach is lock based whereas AtomicInteger is not lock based classes.
    * This approach is a bit slower compares to AtomicInteger because AtomicInteger class takes the advantage of Hardware support
    * AtomicInteger is more efficient
     */

    /*
     * Synchronized keyword can be used in 4 ways
     *  1. Methods
     *  2. Static methods
     *  3. On particular lines eg:
     *  public void increment() {
     *      System.out.println("No need of synchronized");
     *      synchronized(this) {
     *          counter++;
     *      }
     * }
     */
}
