package org.example.recursion.queens;

public class NQueens {
    public static void main(String[] args) {
        int n = 6;
        boolean[][] board = new boolean[n][n];
        System.out.println(nQueens(board, 0));
    }

    private static int nQueens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        //Placing the Queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            //Place the Queen if it is safe to place
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += nQueens(board, row + 1);
                board[row][col] = false; //backtrack when you are coming out of the function call
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false; //not safe to place
            }
        }
        //diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]) {
                return false;
            }
        }
        //diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row-i][col+i]) {
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }

    }
}
