package org.example.dynamicProgramming;

//https://leetcode.com/problems/jump-game/description/?envType=problem-list-v2&envId=dynamic-programming
public class LC55JumpGame {
    public static void main(String[] args) {
        int[] input = {3, 3, 1, 0, 4, 5, 1, 1, 1, 2, 1, 0, 1, 1};
        System.out.println(canJump(input));
    }

    private static boolean canJump(int[] numbers) {
        if (numbers.length == 1) return true;
        int maxJump = 0;
        /* Max jump you can do in the array can be stored in MaxJump.
        // But if the array contains index which is more than your max jump, how can you jump to the end of the array?
        // So, return false when your index is greater than maxJump.
        */
        for (int index = 0; index < numbers.length; index++) {
            if (index > maxJump) {
                return false;
            }
            maxJump = Math.max(maxJump, index + numbers[index]);
        }
        return true;
    }
}
