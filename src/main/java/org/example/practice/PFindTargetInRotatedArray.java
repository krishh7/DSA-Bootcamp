package org.example.practice;

public class PFindTargetInRotatedArray {

    public static void main(String[] args) {
        int[] numbers = {3,4,5,6,1,2};
        int answer = search(numbers, 2);
        System.out.println(answer);

    }

    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            return searchTarget(nums, target, 0, nums.length - 1);
        }
        if (pivot == target) {
            return pivot;
        }
        if (target >= nums[0]) {
            return searchTarget(nums, target, 0, pivot - 1);
        }
        return searchTarget(nums, target, pivot + 1, nums.length - 1);
    }

    private static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            //case 1
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            //case 2
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            //case 3
            if (nums[start] >= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int searchTarget(int[] nums, int target, int start, int end) {
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
