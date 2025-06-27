package org.example.practice;

public class StackOverFlowErrorTrigger {
    public static void main(String[] args) {
        recursiveCall();
    }

    private static void recursiveCall() {
        recursiveCall();
    }
}
