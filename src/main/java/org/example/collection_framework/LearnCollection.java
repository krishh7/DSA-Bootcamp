package org.example.collection_framework;

import java.util.*;

public class LearnCollection {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        List<Integer> key = new ArrayList<>();
        key.add(2);
        key.add(6);
        key.add(15);
        key.add(3, 22);
        key.add(4, 11);
        key.add(4, 32);
        System.out.println(key.get(4));
        key.forEach(keys -> System.out.println(key));
        System.out.println(key);
        System.out.println("-----------------------------------------");

        ArrayList<String> list = new ArrayList<>(Collections.nCopies(5, "Hello"));
        System.out.println(list);



        System.out.println("size: " + list1.size());
        System.out.println("isEmpty: " + list1.isEmpty());
        System.out.println("contains: " + list1.contains(5));
        System.out.println("add: " + list1.add(5));
        System.out.println("contains: " + list1.contains(5));
        System.out.println("remove: " + list1.remove(4));
        System.out.println("remove: " + list1.remove(Integer.valueOf(2)));
        System.out.println("list1: " + list1);

        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        stack.add(6);
        stack.add(7);

        System.out.println("addAll: " + list1.addAll(stack));
        System.out.println("list1: " + list1);
        System.out.println("removeAll: " + list1.removeAll(stack));
        System.out.println("list1: " + list1);
        list1.clear();
        System.out.println("list1: " + list1);


    }
}
