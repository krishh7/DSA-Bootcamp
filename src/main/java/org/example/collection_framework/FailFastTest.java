package org.example.collection_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// FailFast iterators will throw concurrent modification exception when the collection gets
//modified during iteration
public class FailFastTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 7, 8, 9));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            list.add(3);
        }
    }
}
