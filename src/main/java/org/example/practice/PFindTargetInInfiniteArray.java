package org.example.practice;

public class PFindTargetInInfiniteArray {
    public static void main(String[] args) {
        int [] infiniteArray = {2, 3, 5, 8, 11, 17, 19, 22, 27, 29, 33, 36, 39, 41, 45, 47, 49, 51, 52, 55, 58, 61};
        System.out.println(findRange(infiniteArray, 51));
    }

    private static int findRange(int[] nums, int target) {
        int start = 0; int end = 1;
        while (target > nums[end]) {
            int newStart = end + 1;
            end = end + ((end - start + 1) * 2);
            start = newStart;
        }
        return findTarget(nums, target, start, end);
    }

    private static int findTarget(int[] nums, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
