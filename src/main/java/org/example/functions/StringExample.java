package org.example.functions;

import java.util.Scanner;

public class StringExample {

    public static String greet() {
        return "Hey, how are you?";
    }

    public static String myGreet(String name) {
        return "Hey " + name + ", long time!";
    }

    public static void main(String[] args) {
//        String message = greet();
//        System.out.println(message);
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter name : ");
        String name = input.next();
        String message = myGreet(name);
        System.out.println(message);
    }
}
