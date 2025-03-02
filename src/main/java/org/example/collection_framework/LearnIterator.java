package org.example.collection_framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearnIterator {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);

        //Iterating through the List using iterator
        Iterator<Integer> iterator = values.iterator();
        System.out.println("Iterating the List");
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
            if (next == 3) {
                iterator.remove();
            }
        } //Iterated through the list, printed the values and remove 3

        System.out.println("updated list");
        for (Integer value : values) {
            System.out.println(value);
        }
        System.out.println("--------------------------");

        //You can also iterate using forEach method
        values.forEach((Integer val) -> System.out.println(val));
        System.out.println("?????????????????????????????");
        values.forEach(System.out::println);

    }
}
