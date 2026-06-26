class Solution {
    
    private boolean isValid(char[][] board, int row, int col, int n) {
        // check same column, upper-left, upper-right diagonals
        for (int i = row - 1; i >= 0; i--) {
            int diff = row - i;
            if (board[i][col] == 'Q') return false;
            if (col - diff >= 0 && board[i][col - diff] == 'Q') return false;
            if (col + diff < n && board[i][col + diff] == 'Q') return false;
        }
        return true;
    }
    
    private void backtrack(char[][] board, int row, int n, List<List<String>> res) {
        // base case
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            res.add(solution);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, n, res);
                board[row][col] = '.';  // undo
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0, n, res);
        return res;
    }
}