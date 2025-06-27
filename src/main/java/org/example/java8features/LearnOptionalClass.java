package org.example.java8features;

import java.util.ArrayList;
import java.util.Optional;

class Simple {
    public String findByUserId(int userId) {
        if (userId == 0) {
            return null;
        } else {
            return "Krishna";
        }
    }
}
class SimpleOptional {
    public Optional<String> findByUserId(int userId) {
        if (userId == 0) {
            return Optional.empty();
        } else {
            return Optional.ofNullable("Krishnaaaa");
        }
    }
}
public class LearnOptionalClass {
    public static void main(String[] args) {
        Simple simple = new Simple();
        String user = simple.findByUserId(0);
        System.out.println(user);

        System.out.println("-------------------");

        //In above code, this is not doing null check, during run time to avoid NPE we use Optional class
        SimpleOptional simp = new SimpleOptional();
        Optional<String> optionalUser = simp.findByUserId(98);
        optionalUser.ifPresentOrElse( u -> System.out.println(optionalUser), () -> System.out.println("User Not found"));
        optionalUser.map( u -> u.toUpperCase()).ifPresent(System.out::println);
    }

}
