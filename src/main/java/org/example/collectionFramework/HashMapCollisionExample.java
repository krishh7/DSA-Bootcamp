package org.example.collectionFramework;

import java.util.HashMap;

public class HashMapCollisionExample {
    static class CustomKey {
        private int id;

        CustomKey(int id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id % 5; // Forces collisions
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CustomKey)) return false;
            CustomKey key = (CustomKey) o;
            return id == key.id;
        }
    }

    public static void main(String[] args) {
        HashMap<CustomKey, String> map = new HashMap<>();

        // Add elements that cause collisions
        map.put(new CustomKey(1), "A");
        map.put(new CustomKey(6), "B"); // Collision with key 1
        map.put(new CustomKey(11), "C"); // Collision with key 1 and 6

        // Retrieve data
        System.out.println("Retrieve key 6: " + map.get(new CustomKey(6))); // Output: B
    }
}

