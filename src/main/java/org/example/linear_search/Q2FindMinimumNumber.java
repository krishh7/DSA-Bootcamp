package org.example.linear_search;

//This is to find the minimum number of an array
public class Q2FindMinimumNumber {
    public static void main(String[] args) {
        int[] numbers = {12, 134, 21, 342, 2442, 3, 223,0};
        System.out.println(findMin(numbers));

    }
    private static int findMin(int[] arr) {
        int min = arr[0];
        for (int j : arr) {
            if (j < min) { //change to > if you want to find max number
                min = j;
            }
        }
        return min;
    }
}
