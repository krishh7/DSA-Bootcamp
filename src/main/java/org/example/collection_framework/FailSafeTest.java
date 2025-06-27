package org.example.collection_framework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> letters = new CopyOnWriteArrayList<>(Arrays.asList("a", "b", "c", "d"));
        Iterator<String> iterator = letters.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("b")) {
                letters.remove("b");
            }
        }
        System.out.println(letters);
    }
}
