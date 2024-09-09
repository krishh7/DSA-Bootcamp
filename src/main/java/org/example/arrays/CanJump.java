package org.example.arrays;

public class CanJump {
    public static void main(String[] args) {
        int[] input = {3, 2, 1, 0, 4};
        System.out.println(canJump(input));
    }

    private static boolean canJump(int[] numbers) {
        int maxJump = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i > maxJump) {
                return false;
            }
            maxJump = Math.max(maxJump, i + numbers[i]);
        }
        return true;
    }
}
