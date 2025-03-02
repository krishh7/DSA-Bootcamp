package org.example.strings;

//https://leetcode.com/problems/valid-palindrome-ii/
public class ValidPalindromeII {
    public static void main(String[] args) {
        String input = "abca";
        System.out.println(isValidPalindromeII(input));
    }

    private static boolean isValidPalindromeII(String string) {
        int start = 0, end = string.length() - 1;
        while (start <= end) {
            if (Character.toLowerCase(string.charAt(start)) == Character.toLowerCase(string.charAt(end))) {
                start++;
                end--;
            } else {
                return isPalindrome(string, start + 1, end) || isPalindrome(string, start, end - 1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String string, int start, int end) {
        while (start <= end) {
            if (Character.toLowerCase(string.charAt(start)) != Character.toLowerCase(string.charAt(end))) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
