package org.example.java8features.streams;

//Can you create a custom functional interface and use it with a lambda expression?

@FunctionalInterface
interface Custom {
    public String process(String input);
}
public class StreamExample5 {
    public static void main(String[] args) {
        Custom custom = (input) -> input.toUpperCase();
        String hey = custom.process("Hey");
        System.out.println(hey);
    }
}
