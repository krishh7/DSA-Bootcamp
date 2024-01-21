package org.example.binary_search;

/*
 * Find out Ceiling of a Number
 * Ceiling = the smallest number which is >= target
 * Floor = greatest number which is <= target
 */
public class Q3CeilingOfANumber {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 5 , 8, 14, 18, 22, 25, 29, 35, 39, 43, 47, 50 };
        int target = 34;
        System.out.println(findCeiling(numbers, target));
        System.out.println(findFloor(numbers, target));
    }
    private static int findCeiling(int[] num, int target) {
        //If the target number is greater than last index then
        // there will not be any ceiling return -1
        if (target > num[num.length-1]) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (target > num[mid]) {
                start = mid + 1;
            } else if (target < num[mid]) {
                end = mid - 1;
            } else {
                return num[mid];
            }
        }
        return num[start];
    }
    private static int findFloor(int[] num, int target) {
        // If the target is less than start / do not exist then return -1;
        if (target < num[0]) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (target > num[mid]) {
                start = mid + 1;
            } else if (target < num[mid]) {
                end = mid - 1;
            } else {
                return num[mid];
            }
        }
        return num[end];
    }
}
