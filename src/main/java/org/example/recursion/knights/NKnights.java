package org.example.recursion.knights;


public class NKnights {
    public static void main(String[] args) {
        int n = 6;
        boolean[][] board = new boolean[n][n];
        int count = nKnights(board, 0, 0, n);
        System.out.println("Total ways to place Knights: " + count);
    }

    private static int nKnights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return 1;
        }

        //if your col is out of bound, just skip it
        if (row == board.length - 1 && col == board.length) {
            return 0;
        }

        //if you are at the end of the column try for next line
        if (col == board.length) {
            return nKnights(board, row + 1, 0, knights);
        }

        int count = 0;
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += nKnights(board, row, col + 1, knights - 1);
            board[row][col] = false; //backtrack when you are coming out of the function call
        }
        count += nKnights(board, row, col + 1, knights); //if not safe, just move ahead and don't reduce knights because we did not place
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 2)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        return true;
    }

    //Do not repeat yourself, hence created this function
    private static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    private static void display(boolean[][] board) {
        for (boolean[] rows : board) {
            for (boolean element : rows) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
