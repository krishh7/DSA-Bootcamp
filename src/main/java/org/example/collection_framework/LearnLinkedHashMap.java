package org.example.collection_framework;

import java.util.LinkedHashMap;
import java.util.Map;


class LRU<K, V> extends LinkedHashMap<K, V> {
    public int capacity;

    public LRU(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

public class LearnLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LRU<>(4);
        linkedHashMap.put("Krishna", 27);
        linkedHashMap.put("Lissa", 25);
        linkedHashMap.put("Yogi", 27);
        linkedHashMap.put("Meenu", 24);
        linkedHashMap.get("Krishna");
        System.out.println(linkedHashMap);
        linkedHashMap.put("Kranthi", 28);
        System.out.println("-------------------------");
        System.out.println(linkedHashMap);

        System.gc();

//        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
//        System.out.println(linkedHashMap.values());


    }
}
