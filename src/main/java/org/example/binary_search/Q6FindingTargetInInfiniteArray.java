package org.example.binary_search;

//Finding target in infinite array
public class Q6FindingTargetInInfiniteArray {
    public static void main(String[] args) {
        int[] numbers = {12, 34, 45, 56, 67, 78, 79, 89, 90, 101, 122, 123, 145, 178, 200, 244, 344, 455};
        int target = 56;
        System.out.println(getTarget(numbers, target));
    }

    private static int getTarget(int[] numbers, int target) {
        //first find range. First start with box of size 2
        int start = 0;
        int end = 1;

        while(target > numbers[end]) {
            int newStart = end + 1;
            end = end + ((end - start + 1) * 2);
            start = newStart;
        }
        return findTarget(numbers, target, start, end);

    }

    private static int findTarget(int[] numbers, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (target > numbers[mid]) {
                start = mid + 1;
            } else if (target < numbers[mid]) {
                end = mid - 1;
            } else
                return mid;
        }
        return -1;
    }
}
