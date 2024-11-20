package org.example.recursion;

import java.util.ArrayList;

public class LC17Keypad {
    public static void main(String[] args) {
        keyPad("", "12");
        System.out.println("------------------");
        System.out.println(keyPad2("", "12"));
    }

    private static void keyPad(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        int digit = unprocessed.charAt(0) - '0'; //this will convert '2' into 2
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch = (char) ('a' + i);
            keyPad(processed + ch, unprocessed.substring(1));
        }
    }

    private static ArrayList<String> keyPad2(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String>  answer = new ArrayList<>();
        int digit = unprocessed.charAt(0) - '0';
        for (int i = (digit-1)*3; i < digit*3; i++) {
            char ch = (char)('a' + i);
            answer.addAll(keyPad2(processed+ch, unprocessed.substring(1)));
        }
        return answer;
    }
}
