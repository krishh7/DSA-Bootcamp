package org.example.recursion.maze;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean [][] maze  = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };
        mazeWithRestrictions("", maze, 0, 0);
        System.out.println("-------------------------------------");
        System.out.println(mazeWithRestrictionsReturn("", maze, 0, 0));
        System.out.println("-------------------------------------");
        System.out.println(mazeAllDirectionsBacktracking("", maze, 0, 0));
        System.out.println("-------------------------------------");

        int[][] path = new int[maze.length][maze[0].length];
        mazePathPrintsInMatrix("", maze, 0, 0, path, 1);
    }

    private static void mazeWithRestrictions(String processed, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }
        if (!maze[row][col]) {
            return;
        }
        if (row < maze.length - 1) {
            mazeWithRestrictions(processed + 'D', maze, row + 1, col);
        }
        if (col < maze[0].length - 1) {
            mazeWithRestrictions(processed + 'R', maze, row, col + 1);
        }
    }

     //This method is only used when you want to go either right or down
    private static ArrayList<String> mazeWithRestrictionsReturn(String processed, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> answer = new ArrayList<>();

        if (!maze[row][col]) {
            return new ArrayList<>();
        }
        if (row < maze.length - 1) {
            answer.addAll(mazeWithRestrictionsReturn(processed + 'D', maze, row + 1, col));
        }
        if (col < maze[0].length - 1) {
            answer.addAll(mazeWithRestrictionsReturn(processed + 'R', maze, row, col + 1));
        }
        return answer;
    }

    //What if you wants to go in all directions?
    // This will cause you stackoverflow error coz if you can go in all directions
    // you will land in origin and the process continues in loop.
    private static ArrayList<String> mazeAllDirections(String processed, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> answer = new ArrayList<>();

        if (!maze[row][col]) {
            return new ArrayList<>();
        }
        //down
        if (row < maze.length - 1) {
            answer.addAll(mazeAllDirections(processed + 'D', maze, row + 1, col));
        }
        //right
        if (col < maze[0].length - 1) {
            answer.addAll(mazeAllDirections(processed + 'R', maze, row, col + 1));
        }
        //Left
        if (col > 0) {
            answer.addAll(mazeAllDirections(processed + 'L', maze, row, col - 1));
        }
        //Up
        if (row > 0) {
            answer.addAll(mazeAllDirections(processed + 'U', maze, row - 1, col));
        }
        return answer;
    }

    private static ArrayList<String> mazeAllDirectionsBacktracking(String processed, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> answer = new ArrayList<>();

        if (!maze[row][col]) {
            return new ArrayList<>();
        }
        //if above if clause is not false, then I'm considering this block in my path. so I will set it as false.
        maze[row][col] = false;

        //down
        if (row < maze.length - 1) {
            answer.addAll(mazeAllDirectionsBacktracking(processed + 'D', maze, row + 1, col));
        }
        //right
        if (col < maze[0].length - 1) {
            answer.addAll(mazeAllDirectionsBacktracking(processed + 'R', maze, row, col + 1));
        }
        //Left
        if (col > 0) {
            answer.addAll(mazeAllDirectionsBacktracking(processed + 'L', maze, row, col - 1));
        }
        //Up
        if (row > 0) {
            answer.addAll(mazeAllDirectionsBacktracking(processed + 'U', maze, row - 1, col));
        }

        //But when I am getting out from here, at the return position
        //this line where the function  will be over
        // So before the function gets removed also remove the changes that were made by that function.
        maze[row][col] = true;
        return answer;
    }

    //What if you wants to print the path array that describes te path
    private static void mazePathPrintsInMatrix(String processed, boolean[][] maze, int row, int col, int[][] path, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            path[row][col] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            return;
        }
        if (!maze[row][col]) {
            return;
        }
        //if above if clause is not false, then I'm considering this block in my path. so I will set it as false.
        maze[row][col] = false;
        path[row][col] = step;

        //down
        if (row < maze.length - 1) {
            mazePathPrintsInMatrix(processed + 'D', maze, row + 1, col, path, step + 1);
        }
        //right
        if (col < maze[0].length - 1) {
            mazePathPrintsInMatrix(processed + 'R', maze, row, col + 1, path, step + 1);
        }
        //Left
        if (col > 0) {
            mazePathPrintsInMatrix(processed + 'L', maze, row, col - 1, path, step + 1);
        }
        //Up
        if (row > 0) {
            mazePathPrintsInMatrix(processed + 'U', maze, row - 1, col, path, step + 1);
        }

        //But when I am getting out from here, at the return position
        //this line where the function  will be over
        // So before the function gets removed also remove the changes that were made by that function.
        maze[row][col] = true;
        path[row][col] = 0;
    }

}
