package org.example.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 3, 12, 22, 34, 47, 88, 109, 123, 246};
        int target = 246;
        System.out.println(search(array, target, 0, array.length - 1));
    }

    private static int search(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == array[mid]) {
            return mid;
        }
        if (target > array[mid]) {
            return search(array, target, mid + 1, end);
        }
        return search(array, target, start, mid - 1);
    }
}
