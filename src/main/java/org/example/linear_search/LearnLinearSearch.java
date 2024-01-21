package org.example.linear_search;

public class LearnLinearSearch {
    public static void main(String[] args) {
        int[] numbers = {2, 6, 7, 8, 9, 10, 15, 18, 22, 30};
        int target = 9;
        int answer = linearSearch(numbers, target);
        System.out.println(answer);
        int answer2 = linearSearch2(numbers, target);
        System.out.println(answer2);
        boolean answer3 = linearSearch3(numbers, target);
        System.out.println(answer3);


    }

    /*
     * This method will take an array and target value
     * if the array is empty it will return -1;
     * Will fetch value of the index and compare it with target
     * If true it will return that index or will return -1
     */
    private static int linearSearch(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            if (element == target) {
                return i;
            }
        }
        return -1;
    }

    /* This method is to return the value instead index
     * So we are using Integer.MAX_VALUE as we are returning
     * element itself so in this case there might be chance
     * the element can be -1 itself. So to avoid that we are using
     * Integer.MAX_VALUE
     */
    private static int linearSearch2(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }
        for (int element : array) {
            if (element == target) {
                return element;
            }
        }
        return Integer.MAX_VALUE;
    }

    /* This method will return true or false
     * Checks the target and return true or false
     */
    private static boolean linearSearch3(int[] array, int target) {
        if (array.length == 0) {
            return false;
        }
        for (int element : array) {
            if (element == target) {
                return true;
            }
        }
        return false;
    }
}
