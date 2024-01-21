package org.example.binary_search;

//https://leetcode.com/problems/split-array-largest-sum/
//Input: nums = [7,2,5,10,8], k = 2
//Output: 18
//Explanation: There are four ways to split nums into two subarrays.
//The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
public class Q11SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] array = {7,2,5,10,8};
        int chunks = 2;
        System.out.println(splitArray(array, chunks));
    }

    private static int splitArray(int[] array, int k) {
        int start = 0; int end = 0;
        for (int i : array) {
            start = Math.max(start, i);
            end += i;
        }
        while(start < end) {
            //try for the middle as potential answer
            int mid = start + (end - start) / 2;
            //Calculate how many pieces you can divide with this max sum.
            int sum = 0; int pieces = 1; // answer = how many min peaces
            for (int arr : array) {
                if (sum + arr > mid) {
                    //you can not add this in sub array, make new sub array.
                    sum = arr;
                    pieces++;
                } else
                    sum += arr;
            }
            if (pieces > k) {
                start = mid + 1;
            } else
                end = mid;

        }
        return start; //return start or end. Both will be same.
    }
}
