package org.example.binary_search;

/*
 * Mountain array is nothing but increasing then decreasing array
 * eg - {2, 4, 6, 7, 5, 3, 1, 0}
 */
public class Q7FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        System.out.println("Answer is : " + findPeakNumber(arr));
    }

    private static int findPeakNumber(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                //You are in decreasing part of the array. In that case the peak number will be in
                // the left hand side. Then start searching to left side. Make mid as next end.
                end = mid;
            } else
                //You are in increasing part of the array.So the peak element will be in the right hand side.
                // search to right side then your start will become mid+1 because you know mid + 1 is greater
                // than mid;
                start = mid + 1;
        }
        // after every you will come to a point where start and end will be same.
        // You can return start/end. Both will be right answers.
        // Your loop should break at start = end;
        return start;
    }
}
