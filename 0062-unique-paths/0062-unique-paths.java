class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize last row and last column to 1
        // There's only one way to reach destination from these cells
        for(int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;  // Last column
        }
        for(int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;  // Last row
        }
        
        
        // Fill the dp table from bottom-right to top-left
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        
        return dp[0][0];
    }
}