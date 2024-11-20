package org.example.recursion.Strings;

import java.sql.SQLOutput;

public class skipAChar {
    public static void main(String[] args) {
        String input = "Chakrapani";
        skipChar1(input, "");
        System.out.println(skipChar2(input));
        System.out.println(skipChar3(input));
        System.out.println(skipASpecificString("Chakraapplepani"));
    }

    //Removes char a from the string
    private static void skipChar1(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        char ch = input.charAt(0);
        if (ch == 'a') {
            skipChar1(input.substring(1), output);
        } else {
            skipChar1(input.substring(1), output + ch);
        }
    }

    private static String skipChar2(String input) {
        if (input.isEmpty()) {
            return "";
        }
        char ch = input.charAt(0);
        if (ch == 'a') {
            return skipChar2(input.substring(1));
        } else {
            return ch + skipChar2(input.substring(1)); // you have to first add the result and then call the recursion again to avoid stackoverflow error
        }
    }

    private static String skipChar3(String input) {
        StringBuilder builder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch != 'a') {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    //Will skip specific String for example apple
    private static String skipASpecificString(String input) {
        if (input.isEmpty()) {
            return "";
        }
        if (input.startsWith("apple")) {
            return skipASpecificString(input.substring(5));
        } else {
            return input.charAt(0) + skipASpecificString(input.substring(1));
        }
    }
}
