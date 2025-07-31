class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        // Initialize the last row
        for(int j = 0; j < n; j++) {
            dp[m - 1][j] = matrix[m - 1][j];
        }
        
        // Fill dp table from bottom to top
        for(int i = m - 2; i >= 0; i--) {
            for(int j = 0; j < n; j++) {
                int down = matrix[i][j] + dp[i + 1][j];
                
                int diagLeft = Integer.MAX_VALUE;
                if(j - 1 >= 0) {
                    diagLeft = matrix[i][j] + dp[i + 1][j - 1];
                }
                
                int diagRight = Integer.MAX_VALUE;
                if(j + 1 < n) {
                    diagRight = matrix[i][j] + dp[i + 1][j + 1];
                }
                
                dp[i][j] = Math.min(down, Math.min(diagLeft, diagRight));
            }
        }
        
        // Find minimum from the first row
        int result = dp[0][0];
        for(int j = 1; j < n; j++) {
            result = Math.min(result, dp[0][j]);
        }
        
        return result;
    }
}