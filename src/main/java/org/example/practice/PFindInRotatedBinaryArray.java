package org.example.practice;

public class PFindInRotatedBinaryArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8, 8, 9, 9, 10, 11, 13, 14, 15};
        int answer = findAnswer(nums, 7);
        System.out.println(answer);
    }

    private static int findAnswer(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if (nums[pivot] == target) {
            return pivot;
        }
        if (target > nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    //For duplicates
    private static int findPivot(int[] nums) {
        int start = 0; int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid+1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            boolean isAsc = nums[start] < nums[end];
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (isAsc) {
                if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
