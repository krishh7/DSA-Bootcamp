package org.example.recursion.maze;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        System.out.println(findWaysToGoAtTheEndOfTheMaze(3, 3));
        System.out.println("--------------------------------------------");
        printPaths("", 3, 3);
        System.out.println("--------------------------------------------");
        System.out.println(returnPaths("", 3, 3));
        System.out.println("--------------------------------------------");
        System.out.println(returnPathsWith3Ways("", 3, 3));
    }

    private static int findWaysToGoAtTheEndOfTheMaze(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int leftRecursion = findWaysToGoAtTheEndOfTheMaze(row - 1, col);
        int rightRecursion = findWaysToGoAtTheEndOfTheMaze(row, col - 1);
        return leftRecursion + rightRecursion;
    }

    //print the paths
    private static void printPaths(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(processed);
            return;
        }
        if (row > 1) {
            printPaths(processed + 'D', row - 1, col);
        }
        if (col > 1) {
            printPaths(processed + 'R', row, col - 1);
        }
    }
    //return paths if you only wants to go Down and Right
    private static ArrayList<String> returnPaths(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> answer = new ArrayList<>();

        if (row > 1) {
            answer.addAll(returnPaths(processed + 'D', row - 1, col));
        }
        if (col > 1) {
            answer.addAll(returnPaths(processed + 'R', row, col - 1));
        }
        return answer;
    }

    //IF you can go diagonally along with Vertical and horizontal
    private static ArrayList<String> returnPathsWith3Ways(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> answer = new ArrayList<>();
        if (row > 1) {
            answer.addAll(returnPathsWith3Ways(processed + 'V', row - 1, col));
        }
        if (col > 1) {
            answer.addAll(returnPathsWith3Ways(processed + 'H', row, col - 1));
        }
        if (row > 1 && col > 1) {
            answer.addAll(returnPathsWith3Ways(processed + 'D', row - 1, col - 1));
        }
        return answer;
    }
}
