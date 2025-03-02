package org.example.strings;

public class Palindrome {
    public static void main(String[] args) {
        String s1 = "Hello";

        String s2 = s1.concat(" World");
        String s3 = new String("Hello World");
        String s4 = s1.concat(" World").intern();

        System.out.println(s1);
        System.out.println(s2);
//        System.out.println(s3);
        System.out.println(s4);
//        System.out.println(s2.equals(s3));
        System.out.println(s2.equals(s4));
    }

    private static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        str = str.toLowerCase();
        for (int i = 0; i <= str.length()/2; i++) {
            int start = str.charAt(i);
            int end = str.charAt(str.length() - 1 - i);
            if (start != end) {
                return false;
            }
        }
        return true;
    }
}
