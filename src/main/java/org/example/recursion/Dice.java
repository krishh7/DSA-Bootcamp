package org.example.recursion;

import java.util.ArrayList;

//When a dice is thrown in how many ways we can form a number 4
public class Dice {
    public static void main(String[] args) {
        dice("", 1);
        System.out.println(dice2("", 4));
    }

    private static void dice(String processed, int target) {
        if (target == 0) {
            System.out.println(processed);
            return;
        }
        for (int i = 1; i <= 6 && i <= target ; i++) {
            dice(processed + i, target - i);
        }
    }

    private static ArrayList<String> dice2(String processed, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            answer.addAll(dice2(processed+i, target - i));
        }
        return answer;
    }
}
