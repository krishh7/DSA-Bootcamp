package org.example.binary_search;

public class PCeilingOfNumber {
    public static void main(String[] args) {
        int[] number = {2, 3, 5, 9, 14, 16, 18};
        System.out.println(findCeiling(number, 15));
        System.out.println(findFloor(number, 1));

    }

    //Ceiling  = min number which is >= target

    private static int findCeiling(int[] number, int target) {
        int start = 0;
        int end = number.length - 1;

        if (target > number[end]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > number[mid]) {
                start = mid + 1;
            } else if (target < number[mid]) {
                end = mid - 1;
            } else {
                return number[mid];
            }
        }
        return number[start];
    }

    //Floor = biggest number <= target
    private static int findFloor(int[] number, int target) {
        int start = 0;
        int end = number.length - 1;

        if (number[start] > target) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > number[mid]) {
                start = mid + 1;
            } else if (target < number[mid]) {
                end = mid - 1;
            } else {
                return number[mid];
            }
        }
        return number[end];
    }
}
