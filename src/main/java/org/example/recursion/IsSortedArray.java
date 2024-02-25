package org.example.recursion;

//Check if the array is ascending sorted?
public class IsSortedArray {
    public static void main(String[] args) {
        int[] array = {2, 2, 2,2,2,2,2,2,2};
        int[] array2 = {10, 10, 10, 10};
        int[] array3 = {2, 3, 5,8,12,22,32,42,62};
        int[] array4 = {100, 100, 10, 0};
        System.out.println(isSortedAsc(array, 0));
        System.out.println(isSortedDsc(array2, 0));
        System.out.println(isSortedAsc(array3, 0));
        System.out.println(isSortedDsc(array4, 0));

    }

    private static boolean isSortedAsc(int[] array, int index) {
        if (index == array.length - 1) {
            return true;
        }
        return array[index] <= array[index + 1] && array[index] < array[array.length - 1] && isSortedAsc(array, index + 1);
    }

    private static boolean isSortedDsc(int[] array, int index) {
        if (index == array.length - 1) {
            return true;
        }
        return array[index] >= array[index + 1] && array[index] > array[array.length - 1] && isSortedDsc(array, index + 1);
    }
}
