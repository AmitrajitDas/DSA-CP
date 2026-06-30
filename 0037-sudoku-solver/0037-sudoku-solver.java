class Solution {
    private boolean[][] rows = new boolean[9][9]; // rows[r][d] = digit d used in row r
    private boolean[][] cols = new boolean[9][9]; // cols[c][d] = digit d used in col c
    private boolean[][] boxes = new boolean[9][9]; // boxes[b][d] = digit d used in box b

    private int boxIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }

    private boolean backtrack(int row, int col, char[][] board) {
        int n = board.length;
        if (row == n) return true;

        int nextRow = col == n - 1 ? row + 1 : row;
        int nextCol = col == n - 1 ? 0 : col + 1;

        if (board[row][col] != '.') return backtrack(nextRow, nextCol, board);

        int b = boxIndex(row, col);
        for (int digit = 1; digit <= 9; digit++) {
            int d = digit - 1; // 0-indexed for arrays
            if (!rows[row][d] && !cols[col][d] && !boxes[b][d]) {
                board[row][col] = (char) (digit + '0');
                rows[row][d] = cols[col][d] = boxes[b][d] = true;

                if (backtrack(nextRow, nextCol, board)) return true;

                board[row][col] = '.';
                rows[row][d] = cols[col][d] = boxes[b][d] = false;
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int d = board[r][c] - '1';
                    int b = boxIndex(r, c);
                    rows[r][d] = cols[c][d] = boxes[b][d] = true;
                }
            }
        }
        backtrack(0, 0, board);
    }
}