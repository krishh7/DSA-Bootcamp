package org.example.linear_search;

// Search a char in the string
public class Q1SearchInString {
    public static void main(String[] args) {
        String name = "Krishna";
        char target = 'k';
        System.out.println(search(name, target));
        System.out.println(search2(name, target));

    }

    private static boolean search(String str, char target) {
        if (str.isEmpty() || str.isBlank()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /*
     * same thing we can do using enhanced for loop
     * here we have to convert the string into char array
     */
    private static boolean search2(String str, char target) {
        if (str.isEmpty()) {
            return false;
        }
        for (char element : str.toCharArray()) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }
}
