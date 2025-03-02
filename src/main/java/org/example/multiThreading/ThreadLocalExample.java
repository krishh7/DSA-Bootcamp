package org.example.multiThreading;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        //Example 1

        new Thread( () -> {
            threadLocal.set(100);
            System.out.println("value: " + threadLocal.get() );
        }).start();

        System.out.println("value: " + threadLocal.get() );


        //Example 2
        Integer userID = 12345;

        new Thread(() -> {
            System.out.println("Started Thread for user: " + userID);
            threadLocal.set(userID);
            System.out.println("Completed Thread for UserId: " + threadLocal.get());
            threadLocal.remove();
            System.out.println("removed thread for userId: " + threadLocal.get());
        }).start();


        //Example 3
        new Thread(() -> {
            InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
            inheritableThreadLocal.set("Instagram");
            System.out.println("Get value: " + inheritableThreadLocal.get());

            new Thread(() -> {
                inheritableThreadLocal.set("Twitter");
                System.out.println("Get inner thread value: " + inheritableThreadLocal.get());
            }).start();
        }).start();

    }
}
