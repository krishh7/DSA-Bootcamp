package org.example.collection_framework;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class LearnSortedMap {
    public static void main(String[] args) {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.put(25, "Ruchi");
        sortedMap.put(26, "Heena");
        sortedMap.put(27, "Krishna");
        sortedMap.put(22, "Preethi");
        sortedMap.put(23, "Vijay");
        sortedMap.put(24, "Ajay");

        System.out.println(sortedMap); //Keys ate sorted in natural order (asc)

        //Bydefault it uses compareTo method but you can also sort using comparator
        SortedMap<Integer, String> sortedMap2 = new TreeMap<>((a, b) -> b - a);
        sortedMap2.put(25, "Ruchi");
        sortedMap2.put(26, "Heena");
        sortedMap2.put(27, "Krishna");
        sortedMap2.put(22, "Preethi");
        sortedMap2.put(23, "Vijay");
        sortedMap2.put(24, "Ajay");
        System.out.println(sortedMap2);

        //Now same thing you can achieve with reference variable Map.
        //But why specifically SortedMap.
        //Answer is it provides some addition methods which will be helpful
        System.out.println(sortedMap.headMap(25)); //excludes to key
        System.out.println(sortedMap.tailMap(25)); //includes from key
        System.out.println(sortedMap.subMap(23, 26));
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());

    }
}
