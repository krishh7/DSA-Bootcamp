package org.example.arrays;

public class EvenNumberOfDigits {
    public static void main(String[] args) {
        int[] input = {437,315,322,431,686,264,442};
        System.out.println(findNumbers(input));
    }

    public static int findNumbers(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            int count = 0;
            while (num > 0) {
                num = num / 10;
                count++;
            }
            if (count % 2 == 0) {
                answer++;
            }
        }
        return answer;
    }

}
