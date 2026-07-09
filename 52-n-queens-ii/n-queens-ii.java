class Solution {

    int count =0;
    public int totalNQueens(int n) {
        

    char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board);

        return count;
    }

    private void solve(int row, char[][] board) {

        // All queens placed
        if (row == board.length) {
            count++;
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(row, col, board)) {

                // Choose
                board[row][col] = 'Q';

                // Explore
                solve(row + 1, board);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {

        int r, c;

        // Same column
        r = row;
        while (r >= 0) {
            if (board[r][col] == 'Q')
                return false;
            r--;
        }

        // Upper-left diagonal
        r = row;
        c = col;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c--;
        }

        // Upper-right diagonal
        r = row;
        c = col;

        while (r >= 0 && c < board.length) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c++;
        }

        return true;
    }
}
