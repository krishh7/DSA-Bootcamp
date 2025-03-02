package org.example.collection_framework.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LearnImmutableMap {
    public static void main(String[] args) {
        Map<String, Integer> persons = new HashMap<>();
        persons.put("A", 1);
        persons.put("B", 2);
        persons.put("C", 3);
        persons.put("D", 4);

        Map<String, Integer> immutableMap = Collections.unmodifiableMap(persons);
        persons.put("E", 5);
        System.out.println(persons);
        Map<String, Integer> names = Map.ofEntries(
                Map.entry("Key", 67),
                Map.entry("dm", 67),
                Map.entry("bt", 67)
        );
    }
}
