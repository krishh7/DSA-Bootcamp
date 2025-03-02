package org.example.recursion.permutations;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        findPermutations("", "abc");
        System.out.println("-----------------------------");
        System.out.println(findPermutations2("", "abc"));
        System.out.println("-----------------------------");
        System.out.println(findPermutationsCount("", "abc"));
    }

    private static void findPermutations(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);
//            String second = processed.substring(i, processed.length());
            findPermutations(first + ch + second, unprocessed.substring(1));
        }
    }

    private static ArrayList<String> findPermutations2(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);
            answer.addAll(findPermutations2(first + ch + second, unprocessed.substring(1)));
        }
        return answer;
    }

    private static int findPermutationsCount(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return 1;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> answer = new ArrayList<>();
        int count = 0;
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i);
            count += findPermutationsCount(first + ch + second, unprocessed.substring(1));
        }
        return count;
    }
}
