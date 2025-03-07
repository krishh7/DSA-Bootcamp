package org.example.collection_framework.hungryCoders;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * What is the difference between fail-fast and fail-safe Iterators ?
 */
public class FailSafeAndFailFastIterators {
    public static void main(String[] args) {

        //Fail-Fast iterators
        //While you are iterators over a data structure, you can not modify the same collection.
        //Internally this works with direct collection
        //Eg : ArrayList, HashMap, HashSet
        ArrayList<Integer> numbers = new ArrayList<>(List.of(11, 22, 33, 44, 55, 66));
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            numbers.add(500); //This will throw exception
            //Exception in thread "main" java.util.ConcurrentModificationException
        }

        //Fail-safe iterators
        //Internally it's creates a copy of collection and modification happens on the copy
        CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>(List.of("aa", "bb", "vcc", "dvd", "kids", "fun"));
        Iterator<String> nameIterator = names.iterator();
        while (nameIterator.hasNext()) {
            nameIterator.next();
            names.add("ppl"); // Gets added no Exception
        }

        System.out.println(names);
    }
}
