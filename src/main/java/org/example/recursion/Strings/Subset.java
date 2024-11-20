package org.example.recursion.Strings;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        List<List<Integer>> lists = findSubsequence(input);
        System.out.println(lists);
        System.out.println(findSubsetWithoutDuplicates(new int[]{1, 2, 2}));
    }

    private static List<List<Integer>> findSubsequence(int[] array) {
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        for (int num : array) {
            int outerListSize = outerList.size();
            for (int i = 0; i < outerListSize; i++) {
                List<Integer> internalList = new ArrayList<>(outerList.get(i));
                internalList.add(num);
                outerList.add(internalList);
            }
        }
        return outerList;
    }

    private static List<List<Integer>> findSubsetWithoutDuplicates(int[] array) {
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        int start = 0, end = 0;
        for (int i = 0; i < array.length; i++) {
            start = 0;
            //If current and previous element is same then start = end + 1;
            if (i > 0 && array[i] == array[i-1]) {
                start = end + 1;
            }
            end = outerList.size() - 1;
            int n = outerList.size();
            for (int j = start; j < n; j++) {
                List<Integer> innerList = new ArrayList<>(outerList.get(j));
                innerList.add(array[i]);
                outerList.add(innerList);
            }
        }
        return outerList;
    }
}
