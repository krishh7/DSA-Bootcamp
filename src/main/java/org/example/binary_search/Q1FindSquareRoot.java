package org.example.binary_search;

//This question is to find out square root of a number
public class Q1FindSquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(85));

    }
    private static int squareRoot(int number) {
        int start = 1;
        int end = number;
        if (isPerfectSquare(number)) {
            System.out.print("Number is a perfect square. And the square root is : ");
            while(start <= number) {
                int mid = start + (end - start) / 2;

                if (mid * mid > number) {
                    end = mid - 1;
                } else if (mid * mid < number) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        } else {
            System.out.print("Number is not a perfect square, so cannot calculate exact square root for : ");
        }
        return end;
    }

    //Second method using inbuilt functions.
    private static boolean isPerfectSquare(int number) {
        if (number < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}
