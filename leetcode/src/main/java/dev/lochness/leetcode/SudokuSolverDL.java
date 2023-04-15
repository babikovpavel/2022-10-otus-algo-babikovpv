package dev.lochness.leetcode;

import java.util.*;

public class SudokuSolverDL {

    public static void main(String[] args) {
        /*char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };*/
        /*char[][] board = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };*/
        char[][] board = {
                {'.', '.', '.', '2', '.', '.', '.', '6', '3'},
                {'3', '.', '.', '.', '.', '5', '4', '.', '1'},
                {'.', '.', '1', '.', '.', '3', '9', '8', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '3', '8', '.', '.', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '6', '3', '.', '.', '5', '.', '.'},
                {'5', '.', '3', '7', '.', '.', '.', '.', '8'},
                {'4', '7', '.', '.', '.', '1', '.', '.', '.'}
        };
        solveSudoku(board);
        printSudoku(board);
    }

    private static void solveSudoku(char[][] board) {
        final int length = board.length;
        int emptyCells = length * length;
        List<PartialSolvery> partialSolveries = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (char k = '1'; k <= '9'; k++) {
                    var quad = j / 3 + (i / 3 * 3);
                    partialSolveries.add(new PartialSolvery(k, i, j, quad));
                }
            }
        }
        //check all known solves and drop conflicts
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                var digit = board[row][col];
                if (digit != '.') {
                    var quad = col / 3 + (row / 3 * 3);
                    emptyCells--;
                    partialSolveries.removeAll(getAdjancent(partialSolveries, digit, row, col, quad));
                }
            }
        }
        while (emptyCells > 0 && !partialSolveries.isEmpty()) {
            var absoluteSolvery = getAbsoluteSolvery(partialSolveries);
            if (absoluteSolvery.isEmpty()) {
                System.out.println("No more absolute solveries!");
                printSudoku(board);
                var bestGuessSolvery = guessSolvery(partialSolveries);
                boolean isGuessCorrect = trySolve(new LinkedList<>(partialSolveries), bestGuessSolvery,
                        emptyCells, board);
                if (isGuessCorrect) {
                    System.out.println("Sudoku solved!");
                    return;
                } else {
                    System.out.println("Failed to solve with solvery: " + bestGuessSolvery);
                    partialSolveries.remove(bestGuessSolvery);
                }
            } else {
                System.out.println("Found absolute solvery: " + absoluteSolvery.get());
                fillAndCleanAdjancent(board, partialSolveries, absoluteSolvery.get());
                emptyCells--;
            }
        }
    }

    private static void fillAndCleanAdjancent(char[][] board,
                                              List<PartialSolvery> partialSolveries,
                                              PartialSolvery solvery) {
        board[solvery.row][solvery.col] = solvery.digit;
        partialSolveries.removeAll(getAdjancent(partialSolveries, solvery));
        partialSolveries.remove(solvery);
    }

    private static boolean trySolve(List<PartialSolvery> testSolveries,
                                    PartialSolvery testSolvery,
                                    int emptyCells,
                                    char[][] board) {
        System.out.println("Trying solvery: " + testSolvery);
        fillAndCleanAdjancent(board, testSolveries, testSolvery);
        emptyCells--;
        Deque<PartialSolvery> history = new ArrayDeque<>();
        while (emptyCells > 0 && !testSolveries.isEmpty()) {
            var absoluteSolvery = getAbsoluteSolvery(testSolveries);
            if (absoluteSolvery.isEmpty()) {
                System.out.println("No more absolute solveries!");
                printSudoku(board);
                var nextSolvery = guessSolvery(testSolveries);
                if(nextSolvery == null) {
                    System.out.println("No more solveries!");
                    return false;
                }
                boolean isGuessCorrect = trySolve(new LinkedList<>(testSolveries), nextSolvery, emptyCells, board);
                if (isGuessCorrect) {
                    return true;
                } else {
                    testSolveries.remove(nextSolvery);
                }
            } else {
                System.out.println("Found absolute solvery: " + absoluteSolvery.get());
                history.push(absoluteSolvery.get());
                fillAndCleanAdjancent(board, testSolveries, absoluteSolvery.get());
                emptyCells--;
            }
        }
        if(emptyCells != 0) {
            System.out.println("Failed to solve! Reset back.");
            resetFaults(history, board);
        }
        return emptyCells == 0;
    }

    private static void resetFaults(Deque<PartialSolvery> history, char[][] board) {
        while(!history.isEmpty()) {
            var partialSolvery = history.poll();
            board[partialSolvery.row][partialSolvery.col] = '.';
        }
    }

    private static List<PartialSolvery> getAdjancent(List<PartialSolvery> partialSolveries,
                                                     PartialSolvery nextSolvery) {
        return getAdjancent(partialSolveries, nextSolvery.digit, nextSolvery.row, nextSolvery.col, nextSolvery.quad);
    }

    private static PartialSolvery guessSolvery(List<PartialSolvery> partialSolveries) {
        int min = 10;
        PartialSolvery bestGuess = null;
        for (var partialSolvery : partialSolveries) {
            long variantsCount = partialSolveries.stream()
                    .filter(ps -> ps.row == partialSolvery.row && ps.col == partialSolvery.col)
                    .count();
            if(variantsCount == 2) {
                return partialSolvery;
            }
            if (variantsCount < min) {
                min = (int) variantsCount;
                bestGuess = partialSolvery;
            }
        }
        return bestGuess;
    }

    private static Optional<PartialSolvery> getAbsoluteSolvery(List<PartialSolvery> partialSolveries) {
        for (var partialSolvery : partialSolveries) {
            long variantsCount = partialSolveries.stream()
                    .filter(ps -> ps.row == partialSolvery.row && ps.col == partialSolvery.col)
                    .count();
            if (variantsCount == 1) {
                return Optional.of(partialSolvery);
            }
        }
        return Optional.empty();
    }

    private static List<PartialSolvery> getAdjancent(List<PartialSolvery> partialSolveries,
                                                     char digit,
                                                     int row,
                                                     int col,
                                                     int quad) {
        return partialSolveries.stream()
                .filter(partialSolvery -> isSameDigitAndArea(digit, row, col, quad, partialSolvery)
                        || isSameCell(row, col, partialSolvery))
                .toList();
    }

    private static boolean isSameCell(int row, int col, PartialSolvery partialSolvery) {
        return partialSolvery.row == row && partialSolvery.col == col;
    }

    private static boolean isSameDigitAndArea(char digit, int row, int col, int quad, PartialSolvery partialSolvery) {
        return partialSolvery.digit == digit
                && (partialSolvery.row == row || partialSolvery.col == col || partialSolvery.quad == quad);
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

    private static void printSolveries(List<PartialSolvery> partialSolveries) {
        System.out.println("----");
        System.out.println("Partial solveries:");
        for(var partialSolvery : partialSolveries) {
            System.out.println(partialSolvery);
        }
        System.out.println("----");
    }

    static class PartialSolvery {
        private final char digit;
        private final int row;
        private final int col;
        private final int quad;

        public PartialSolvery(char digit, int row, int col, int quad) {
            this.digit = digit;
            this.row = row;
            this.col = col;
            this.quad = quad;
        }

        public String toString() {
            return "[digit=" + this.digit + ", row=" + this.row + ", col=" + this.col + ", quad=" + this.quad + "]";
        }
    }
}
