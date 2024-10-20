package org.example.practice;

public class PSquareRootBinarySearch {
    public static void main(String[] args) {
        int number = 14;
        boolean perfectSquare = isPerfectSquare(number);
        System.out.println(perfectSquare);
    }

    private static boolean isPerfectSquare(int number) {
        int start = 1; int end = number; {
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (mid * mid > number) {
                    end = mid - 1;
                } else if (mid * mid < number) {
                    start = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
