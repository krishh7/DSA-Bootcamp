package org.example.strings;

//https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {
    public static void main(String[] args) {
        String input = "MCMXCIV";
        System.out.println(findValue(input));
    }

    private static int findValue(String string) {
        int sum = 0, previousValue = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            int currentValue = romanToInt(string.charAt(i));
            if (currentValue < previousValue) {
                sum -= currentValue;
            } else {
                sum += currentValue;
            }
            previousValue = currentValue;
        }
        return sum;
    }
    private static int romanToInt(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
