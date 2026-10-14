
class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Fill board with empty spaces
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0);

        return result;
    }

    void backtrack(char[][] board, int row) {

        // All queens are placed
        if (row == board.length) {
            result.add(createBoard(board));
            return;
        }

        // Try every column in this row
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                // Choose
                board[row][col] = 'Q';

                // Explore
                backtrack(board, row + 1);

                // Undo
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(char[][] board, int row, int col) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    List<String> createBoard(char[][] board) {

        List<String> configuration = new ArrayList<>();

        for (char[] row : board) {
            configuration.add(new String(row));
        }

        return configuration;
    }
}