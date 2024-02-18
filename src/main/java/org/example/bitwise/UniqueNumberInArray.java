package org.example.bitwise;

/*
 * Adn array will be given find the unique in it
 * eg {1, 4, 3, 3, 5, 1, 4}
 * 1, 3, 4 are occurred two times but 5 is only once
 * So 5 is the answer.
 */
public class UniqueNumberInArray {
    public static void main(String[] args) {
        int[] array = {1, 4, 3, 7, 1, 4, 3};
        System.out.println(findUniqueNumberInArray(array));
    }

    private static int findUniqueNumberInArray(int[] array) {
        int unique = 0;
        for (int n : array) {
            unique ^= n;
        }
        return unique;
    }
}
