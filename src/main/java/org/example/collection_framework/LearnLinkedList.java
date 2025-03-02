package org.example.collection_framework;

import java.util.LinkedList;

public class LearnLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.addFirst(4);
        linkedList.addLast(9);
        System.out.println(linkedList);

    }
}
