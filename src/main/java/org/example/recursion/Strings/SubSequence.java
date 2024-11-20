package org.example.recursion.Strings;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        findSubSequences("abc", "");
        System.out.println(findSubSequences2("abc", ""));
    }

    private static void findSubSequences(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        char ch = input.charAt(0);
        findSubSequences(input.substring(1), output + ch);
        findSubSequences(input.substring(1), output);
    }

    //If you want to add the subsequences into an ArrayList.
    private static ArrayList<String> findSubSequences2(String input, String output) {
        if (input.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(output);
            return list;
        }

        char ch = input.charAt(0);
        ArrayList<String> leftArray = findSubSequences2(input.substring(1), output + ch);
        ArrayList<String> rightArray = findSubSequences2(input.substring(1), output);
        leftArray.addAll(rightArray);
        return leftArray;
    }
}
