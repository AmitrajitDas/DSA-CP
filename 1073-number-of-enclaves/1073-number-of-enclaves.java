class Solution {
    // Dimensions of the grid
    int n, m;

    // Direction arrays for moving up, right, down, and left
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};

    // Depth-First Search (DFS) function to mark all reachable land cells
    private void dfs(int row, int col, boolean[][] vis, int[][] grid) {
        // Mark the current cell as visited
        vis[row][col] = true;

        // Traverse in all 4 possible directions
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i]; // New row
            int ncol = col + dcol[i]; // New column

            // Check bounds, unvisited status, and land condition (grid[nrow][ncol] == 1)
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid); // Recursive DFS call
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        // Get the grid dimensions
        n = grid.length;
        m = grid[0].length;

        // Visited array to track processed cells
        boolean[][] vis = new boolean[n][m];

        // Step 1: Traverse the boundary rows and columns
        // Process the first and last columns of each row
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && grid[i][0] == 1) { 
                // Mark all land cells connected to the left boundary
                dfs(i, 0, vis, grid); 
            }
            if (!vis[i][m - 1] && grid[i][m - 1] == 1) { 
                // Mark all land cells connected to the right boundary
                dfs(i, m - 1, vis, grid); 
            }
        }

        // Process the first and last rows of each column
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && grid[0][j] == 1) { 
                // Mark all land cells connected to the top boundary
                dfs(0, j, vis, grid); 
            }
            if (!vis[n - 1][j] && grid[n - 1][j] == 1) { 
                // Mark all land cells connected to the bottom boundary
                dfs(n - 1, j, vis, grid); 
            }
        }

        // Step 2: Count the remaining unvisited land cells
        int count = 0; // Counter for enclave cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Increment the count if the cell is a land cell and not visited
                if (!vis[i][j] && grid[i][j] == 1) {
                    count++;
                }
            }
        }

        // Return the count of enclave land cells
        return count;
    }
}
