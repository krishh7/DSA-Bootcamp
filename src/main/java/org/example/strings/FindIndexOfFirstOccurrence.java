package org.example.strings;

//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
public class FindIndexOfFirstOccurrence {
    public static void main(String[] args) {
        int i = firstOccurrenceOfString("leetcode", "leeto");
        System.out.println(i);
    }

    private static int firstOccurrenceOfString(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= h - n; i++) {
            if (haystack.substring(i, i + n).equals(needle))
                return i;
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle));
            return i;
        }
        return -1;
    }
}
