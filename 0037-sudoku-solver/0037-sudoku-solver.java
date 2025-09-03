class Solution {
    private Set<Character>[] rows;
    private Set<Character>[] cols;
    private Set<Character>[] boxes;

    private boolean isValid(int row, int col, char num) {
        int boxIndex = (row / 3) * 3 + (col / 3);
        return !rows[row].contains(num) &&
                !cols[col].contains(num) &&
                !boxes[boxIndex].contains(num);
    }

    private boolean backtrack(char[][] board) {
        // Find next empty cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    // Try numbers 1-9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(i, j, num)) {
                            // Place number
                            board[i][j] = num;
                            rows[i].add(num);
                            cols[j].add(num);
                            boxes[boxIndex].add(num);

                            // Recurse
                            if (backtrack(board)) {
                                return true;
                            }

                            // Backtrack - remove number
                            board[i][j] = '.';
                            rows[i].remove(num);
                            cols[j].remove(num);
                            boxes[boxIndex].remove(num);
                        }
                    }

                    // No valid number found for this cell
                    return false;
                }
            }
        }

        // All cells filled successfully
        return true;
    }

    public void solveSudoku(char[][] board) {
        // Initialize sets as class variables
        rows = new HashSet[9];
        cols = new HashSet[9];
        boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Fill sets with existing numbers
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char num = board[i][j];
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    rows[i].add(num);
                    cols[j].add(num);
                    boxes[boxIndex].add(num);
                }
            }
        }

        backtrack(board);
    }

}