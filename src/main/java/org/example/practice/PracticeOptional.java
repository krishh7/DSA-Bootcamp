package org.example.practice;

import java.util.Optional;

class Simple {
    public String findById(int id) {
        if (id == 0) {
            return null;
        } else {
            return "Krishna";
        }
    }
}

class SimpleOptional {
    public Optional<String> findById(int id) {
        if (id == 0) {
            return Optional.empty();
        } else {
            return Optional.ofNullable("Krishnaaaaaa");
        }
    }

}
public class PracticeOptional {
    public static void main(String[] args) {
        Simple simple = new Simple();
        System.out.println(simple.findById(0));

        System.out.println("-------------------------");

        SimpleOptional simpleOptional = new SimpleOptional();
        Optional<String> optionalResult = simpleOptional.findById(0);
        optionalResult.ifPresentOrElse(s -> System.out.println(optionalResult), () -> System.out.println("User not found"));
    }
}
