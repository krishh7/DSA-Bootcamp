package org.example.linear_search;

// Question is there will be an array of elements, we have to find how many of them are even digit numbers
// eg {12, 234, 3422, 321, 2347}
// answer = 3 (coz : 12:even , 3422:even, 2347:even)

public class Q6CountNumberOfEvenDigits {
    public static void main(String[] args) {
        int[] nums = {12, 1234, 234, 5563, 1245, 23212, 4552, 211, 3445, 9087};
        int answer = findNumbers(nums);
        System.out.println(answer);

        // Output = 7;
    }

    private static int findNumbers(int[] array) {
        int count = 0;
        for (int number : array) {
            if (isEven(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isEven(int number) {
        int noOfDigits = digits(number);
        return noOfDigits % 2 == 0;
    }

    private static int digits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number = number/10;
        }
        return count;
    }
}
