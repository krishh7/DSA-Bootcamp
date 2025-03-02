package org.example.strings;

//https://leetcode.com/problems/valid-palindrome/description/
public class ValidPalindrome {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        boolean answer = validPalindrome2(input);
        System.out.println(answer);
    }

    private static boolean validPalindrome(String string) {
        if (string == null || string.length() == 0 || string.length() == 1) {
            return true;
        }
        int start = 0, end = string.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(string.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(string.charAt(end))) {
                end--;
            }
            if (Character.toLowerCase(string.charAt(start)) != Character.toLowerCase(string.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean validPalindrome2(String string) {
        StringBuilder builder = new StringBuilder();
        for (char str : string.toCharArray()) {
            if (Character.isLetterOrDigit(str)) {
                builder.append(Character.toLowerCase(str));
            }
        }
        return builder.toString().equals(builder.reverse().toString());
    }
}
