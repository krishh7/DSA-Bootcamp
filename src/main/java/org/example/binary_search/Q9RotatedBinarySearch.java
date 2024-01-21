package org.example.binary_search;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Pivot = max number / peak number
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */

public class Q9RotatedBinarySearch {
    public static void main(String[] args) {
        int[] array = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Answer is : " + search(array, target));

    }

    private static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        //If you did not find pivot, it means the nums is not rotated.
        if (pivot == -1) {
            return findTarget(nums, target, 0, nums.length - 1);
        }
        //case 1
        if (nums[pivot] == target) {
            return pivot;
        }
        //case 2
        if (target >= nums[0]) {
            return findTarget(nums, target, 0, pivot - 1);
        }
        return findTarget(nums, target, pivot + 1, nums.length - 1);
    }

    private static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            //case 1
            if ( mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            //case 2
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            //case 3
            if (arr[mid] <= arr[start]) {
                end = mid -1;
                //eg [4, 5, 6, 3, 2, 1, 0]
                //start 4, mid 3, end 0. For this condition after mid everything will be smaller than start.
                //in that case we will not search for pivot that side. So end gets mid - 1.                end = mid - 1;
            } else
                start = mid + 1;
        }
        return -1;

    }

    private static int findTarget(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (isAsc) {
                if (target > arr[mid]) {
                    // [1, 4, 5, 7, 9, 10] target = 9;
                    start = mid + 1;
                } else
                    end = mid - 1;
            } else {
                if (target < arr[mid]) {
                    // [10, 9, 7, 5, 4, 1] target = 4
                    start = mid + 1;
                } else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
