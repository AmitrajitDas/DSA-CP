class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        // Handle edge case: obstacle at start or destination
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        
        int[][] dp = new int[m][n];
        
        // Initialize destination
        dp[m - 1][n - 1] = 1;
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                // Skip the destination cell (already initialized)
                if(i == m - 1 && j == n - 1) continue;
                
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int down = (i + 1 < m) ? dp[i + 1][j] : 0;
                    int right = (j + 1 < n) ? dp[i][j + 1] : 0;
                    dp[i][j] = down + right;
                }
            }
        }
        
        return dp[0][0];
    }
}

// class Solution {
//     private int dfs(int i, int j, int m, int n, int[][] dp, int[][] obstacleGrid) {
//         // Check bounds first
//         if (i >= m || j >= n) return 0;

//         // Check if current cell is an obstacle
//         if (obstacleGrid[i][j] == 1) return 0;

//         // Base case: reached destination
//         if (i == m - 1 && j == n - 1) return 1;

//         if(dp[i][j] != -1) return dp[i][j];

//         int right = dfs(i, j + 1, m, n, dp, obstacleGrid);
//         int down = dfs(i + 1, j, m, n, dp, obstacleGrid);

//         return dp[i][j] = right + down;
//     }

//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         // Handle edge case: obstacle at start or destination
//         if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
//             return 0;
//         }

//         int[][] dp = new int[m][n];
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         return dfs(0, 0, m, n, dp, obstacleGrid);
//     }
// }