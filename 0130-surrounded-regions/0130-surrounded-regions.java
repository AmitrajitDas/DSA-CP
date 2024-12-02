class Solution {
    // Direction arrays to navigate up, right, down, and left
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};
    int n, m; // Dimensions of the board

    // DFS function to mark connected 'O's from the boundary
    private void dfs(int row, int col, boolean[][] vis, char[][] board) {
        // Mark the current cell as visited
        vis[row][col] = true;

        // Explore the four possible directions
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i]; // New row
            int ncol = col + dcol[i]; // New column

            // Check bounds, unvisited status, and 'O' character
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && !vis[nrow][ncol] && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, vis, board); // Recursive DFS call
            }
        }
    }

    public void solve(char[][] board) {
        // Get the dimensions of the board
        n = board.length;
        m = board[0].length;

        // Visited array to keep track of processed cells
        boolean[][] vis = new boolean[n][m];

        // Step 1: Traverse the boundary rows and columns
        // Process the first and last columns of each row
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && board[i][0] == 'O') {
                dfs(i, 0, vis, board); // Mark all connected 'O's
            }
            if (!vis[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, board); // Mark all connected 'O's
            }
        }

        // Process the first and last rows of each column
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && board[0][j] == 'O') {
                dfs(0, j, vis, board); // Mark all connected 'O's
            }
            if (!vis[n - 1][j] && board[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, board); // Mark all connected 'O's
            }
        }

        // Step 2: Modify the board based on the visited array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the cell is 'O' and not visited, it's surrounded, so convert it to 'X'
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
