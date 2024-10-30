class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            dp[i][m - 1] = 0;
        }

        for(int col = m - 2; col >= 0; col--) {
            for(int row = n - 1; row >= 0; row--) {
                int maxMoves = 0;

                if(row > 0 && grid[row - 1][col + 1] > grid[row][col]) {
                    maxMoves = Math.max(maxMoves, 1 + dp[row - 1][col + 1]);
                }
                if(grid[row][col + 1] > grid[row][col]) {
                    maxMoves = Math.max(maxMoves, 1 + dp[row][col + 1]);
                }
                if(row < n - 1 && grid[row + 1][col + 1] > grid[row][col]) {
                    maxMoves = Math.max(maxMoves, 1 + dp[row + 1][col + 1]);
                }

                dp[row][col] = maxMoves;
            }
        }

        int maxMoves = 0;
        for (int row = 0; row < n; row++) {
            maxMoves = Math.max(maxMoves, dp[row][0]);
        }

        return maxMoves;
    }
}