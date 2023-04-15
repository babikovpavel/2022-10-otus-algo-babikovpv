package dev.lochness.leetcode;

// https://leetcode.com/problems/valid-sudoku/
public class SudokuValidator {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isRowValid(i, board) || !isColumnValid(i, board) || !isSquareValid(i, board))
                return false;
        }
        return true;
    }

    public boolean isRowValid(int rowNum, char[][] board) {
        char[] row = board[rowNum];
        CustomHashTable nums = new CustomHashTable(9);
        for (char num : row) {
            if (num != '.') {
                if (nums.get(num) == null) {
                    nums.put(num);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isColumnValid(int colNum, char[][] board) {
        CustomHashTable nums = new CustomHashTable(9);
        for (int i = 0; i < board[colNum].length; i++) {
            char num = board[i][colNum];
            if (num != '.') {
                if (nums.get(num) == null) {
                    nums.put(num);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSquareValid(int squareNum, char[][] board) {
        CustomHashTable nums = new CustomHashTable(9);
        int rowLimit = squareNum / 3;
        int colLimit = squareNum % 3;
        for (int i = colLimit * 3; i < colLimit * 3 + 3; i++) {
            for (int j = rowLimit * 3; j < rowLimit * 3 + 3; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (nums.get(num) == null) {
                        nums.put(num);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class CustomHashTable {

        private final Bag[] values;

        protected final Object stub;

        public CustomHashTable(int capacity) {
            values = new Bag[capacity];
            stub = new Object();
        }

        public Object get(char key) {
            int i = Math.abs(key % values.length);
            Bag bag = values[i];
            while (bag != null) {
                if (bag.key == key) {
                    return bag.value;
                }
                bag = bag.nextElem;
            }
            return null;
        }

        public void put(char key) {
            int i = Math.abs(key % values.length);
            Bag bag = values[i];
            if (bag == null) {
                values[i] = new Bag(key, stub);
            } else {
                boolean exists;
                do {
                    exists = bag.key == key;
                    if (exists) {
                        bag.value = stub;
                        return;
                    }
                    bag = bag.nextElem;
                } while (bag != null);
                Bag newBag = new Bag(key, stub);
                newBag.nextElem = values[i];
                values[i] = newBag;
            }
        }

        static class Bag {
            private final int key;
            private Object value;
            private Bag nextElem;

            Bag(char key, Object value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
