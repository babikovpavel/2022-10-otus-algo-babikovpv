package dev.lochness.leetcode;

public class SudokuSolver {

    public static void main(String[] args) {
        SudokuValidator validator = new SudokuValidator();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        printSudoku(board);
        boolean isValidSudoku = solveSudoku(board, validator);
        System.out.println(isValidSudoku);
        printSudoku(board);
    }

    private static boolean solveSudoku(char[][] board, SudokuValidator validator) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        board[i][j] = k;
                        if (validator.isValidSudoku(board) && solveSudoku(board, validator)) {
                            return true;
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return validator.isValidSudoku(board);
    }

    private static void printSudoku(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%c", board[i][j]);
            }
            System.out.println();
        }
    }
}
