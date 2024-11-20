package org.example.strings;

//https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        String answer = findLongestCommonPrefix(input);
        System.out.println(answer);
    }

    private static String findLongestCommonPrefix(String[] string) {
        if (string == null || string.length == 0)
            return "";
        String prefix = string[0];
        for (int i = 1; i < string.length; i++) {
            while (string[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}
