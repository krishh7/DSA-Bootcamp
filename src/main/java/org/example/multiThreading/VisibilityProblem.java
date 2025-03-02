package org.example.multiThreading;

class SharedResource {
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
public class VisibilityProblem {
    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        //Thread 1
        new Thread( () -> {
            System.out.println("Thread 1 is started");
            try {
                System.out.println("Thread 1 logic is started");
                Thread.sleep(2000);
                System.out.println("Thread 1 logic is completed");
                sharedResource.setFlag(true);
                System.out.println("Flag set by Tread 1 ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        //Thread 2
        new Thread(() -> {
            System.out.println("Thread 2 is started");
            System.out.println("Thread 2 logic is started");
            while(!sharedResource.isFlag()) {
                //It will run until the flag value is true
            }
            System.out.println("Thread 2 logic is completed");
        }).start();
    }

    /*
     * The Problem is thread 1 started and before setting the flag to true thread 2 is started
     * after thread 2 is started the thread 1 has set the flag to true, but
     * Thread 2 was still stuck in the while loop that the flag was still false when it was running.
     * This is called visibility problem, that the value set by thread 1 is invisible to thread 2.
     * To solve this problem you have to define that flag variable to volatile keyword.
     * Once you define it as volatile keyword the visibility problem will be resolved.
     */
}
