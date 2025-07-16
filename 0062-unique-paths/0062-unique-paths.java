class Solution {
    private int explorePaths(int i, int j, int m, int n, int[][] dp) {
        // Base case: reached destination
        if(i == m - 1 && j == n - 1) return 1;
        
        // Base case: out of bounds
        if(i >= m || j >= n) return 0;
        
        // Check if already computed
        if(dp[i][j] != -1) return dp[i][j];
        
        // Compute and store result
        int right = explorePaths(i + 1, j, m, n, dp);
        int down = explorePaths(i, j + 1, m, n, dp);
        
        dp[i][j] = right + down;
        return dp[i][j];
    }
    
    public int uniquePaths(int m, int n) {
        // Initialize memoization table with -1 (uncomputed)
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return explorePaths(0, 0, m, n, dp);
    }
}