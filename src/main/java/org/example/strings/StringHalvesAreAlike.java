package org.example.strings;

public class StringHalvesAreAlike {
    public static void main(String[] args) {
        String inputString = "book";
        boolean alike = stringHalvesAreAlike(inputString);
        System.out.println(alike);
    }

    private static boolean stringHalvesAreAlike(String string) {
        int n = string.length();
        String firstHalf = string.substring(0, n/2);
        String secondHalf = string.substring(n/2);
        return countVowels(firstHalf) == countVowels(secondHalf);
    }

    private static int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (isVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
