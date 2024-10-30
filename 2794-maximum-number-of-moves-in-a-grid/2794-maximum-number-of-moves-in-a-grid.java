class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length, m = grid[0].length;  // Get the number of rows (n) and columns (m) of the grid
        int[][] dp = new int[n][m];  // DP table to store the max moves possible from each cell

        // Initialize the last column cells with 0 moves (base case)
        // Cells in the last column have no cells to the right to move into, so max moves from them are 0
        for(int i = 0; i < n; i++) {
            dp[i][m - 1] = 0;
        }

        // Fill the DP table from the second-last column to the first column
        for(int col = m - 2; col >= 0; col--) {  // Start from the second-last column and move leftward
            for(int row = n - 1; row >= 0; row--) {  // For each row, move bottom to top
                int maxMoves = 0;  // Variable to track max moves from the current cell

                // Check up-right move
                if(row > 0 && grid[row - 1][col + 1] > grid[row][col]) {
                    maxMoves = Math.max(maxMoves, 1 + dp[row - 1][col + 1]);
                }
                
                // Check right move
                if(grid[row][col + 1] > grid[row][col]) {
                    maxMoves = Math.max(maxMoves, 1 + dp[row][col + 1]);
                }
                
                // Check down-right move
                if(row < n - 1 && grid[row + 1][col + 1] > grid[row][col]) {
                    maxMoves = Math.max(maxMoves, 1 + dp[row + 1][col + 1]);
                }

                // Store the maximum moves possible from the current cell (row, col)
                dp[row][col] = maxMoves;
            }
        }

        // Extract the result by finding the maximum moves possible starting from any cell in the first column
        int maxMoves = 0;
        for (int row = 0; row < n; row++) {
            maxMoves = Math.max(maxMoves, dp[row][0]);
        }

        return maxMoves;
    }
}