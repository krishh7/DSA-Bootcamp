package org.example.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * There are 4 types of ThreadPools
 */
public class ThreadPools {
    public static void main(String[] args) {

        //Single Thread Executor
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("Single Thread Executor started");
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            singleThreadExecutor.execute(() -> {
                System.out.println("Single Thread Task " + taskId + " executed by Thread: " + Thread.currentThread().getName());
            });
        }

        //Fixed Thread Pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        System.out.println("Fixed Thread Pool");
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            fixedThreadPool.execute(() -> {
                System.out.println("Fixed Thread Task " + taskId + " is executed by Thread: " + Thread.currentThread().getName());
            });
        }

        //Cached Thread Pool
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("Cached Thread Pool");
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            cachedThreadPool.execute(() -> {
                System.out.println("Cached Thread Task " + taskId + " is executed by Thread: " + Thread.currentThread().getName());
            });
        }

        // Scheduled Thread Pool
        // Create a ScheduledThreadPool with 2 threads
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        // Schedule a task to execute after 5 seconds
        scheduledThreadPool.schedule(() ->
                        System.out.println("Scheduled Task"),
                5, TimeUnit.SECONDS);

        // Schedule a task to execute every 1 second, starting immediately
        scheduledThreadPool.scheduleAtFixedRate(() ->
                        System.out.println("Scheduled Task"),
                0, 1, TimeUnit.SECONDS);
    }
}
