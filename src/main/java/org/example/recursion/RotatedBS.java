package org.example.recursion;

//Search for an element in an array which is rotated
public class RotatedBS {
    public static void main(String[] args) {
        int[] numbers = {5, 6, 7, 8, 1, 2, 3, 4};
        System.out.println(findTarget(numbers, 2, 0, numbers.length - 1));
    }

    private static int findTarget(int[] numbers, int target, int start, int end) {
        if (start > end ) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (numbers[mid] == target) {
            return mid;
        }
        if (numbers[start] <= numbers[mid]) {
            if (target >= numbers[start] && target <= numbers[mid]) {
                return findTarget(numbers, target, start, mid - 1);
            } else {
                return findTarget(numbers, target, mid+1, end);
            }
        }
        if (target >= numbers[mid] && target <= numbers[end]) {
            return findTarget(numbers, target, mid+1, end);
        }
        return findTarget(numbers, target, start, mid - 1);
    }
}
