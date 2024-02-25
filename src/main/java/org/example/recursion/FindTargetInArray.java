package org.example.recursion;

import java.util.ArrayList;

//Find the target in an array
public class FindTargetInArray {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] numbers = {15, 6, 11, 13, 7, 10, 10, 7, 9, 5, 2, 21, 10};
        System.out.println(findTargetIndex(numbers, 221, 0));
        System.out.println(isTargetExists(numbers, 212, 0));
        System.out.println(findTargetIndexReverse(numbers, 2, numbers.length - 1));
        System.out.println(findAllIndexes(numbers, 10, 0));

    }

    private static int findTargetIndex(int[] number, int target,  int index) {
        if (index == number.length) {
            return -1;
        }
        if (number[index] == target) {
            return index;
        }
        return findTargetIndex(number, target, index + 1);
    }

    //When searched from starting
    private static boolean isTargetExists(int[] number, int target, int index) {
        if (index == number.length) {
            return false;
        }
        return number[index] == target || isTargetExists(number, target, index + 1);
    }

    //When searched from ending
    private static int findTargetIndexReverse(int[] numbers, int target, int index) {
        if (index == -1) {
            return -1;
        }
         if (numbers[index] == target) {
             return index;
         }
         return findTargetIndexReverse(numbers, target, index - 1);
    }

    //print list of indexes if the target is repeated
    private static ArrayList<Integer> findAllIndexes(int[] numbers, int target, int index) {
        if (index == numbers.length) {
            return list;
        }
        if (numbers[index] == target) {
            list.add(index);
        }
        return findAllIndexes(numbers, target, index + 1);
    }
}
