package org.example.linear_search;

// This question is to search in a range
public class Q3SearchInRange {
    public static void main(String[] args) {
        String name = "Krishna";
        char target = 'n';
        System.out.println(searchInRange(name, 1, 5, target));

    }
    private static boolean searchInRange(String str, int start, int end, char target) {
        if (str.length() == 0) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            if ( target == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
