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

// class Solution {    
//     public int uniquePaths(int m, int n) {
//         // Initialize memoization table with -1 (uncomputed)
//         int[][] dp = new int[m][n];
//         dp[m - 1][n - 1] = 1;

//         for(int i = m - 1; i >= 0; i--) {
//             for(int j = n - 1; j >= 0; j--) {
//                 if (i == m - 1 && j == n - 1) continue;
//                 int down = i + 1 < m ? dp[i + 1][j] : 0;
//                 int right = j + 1 < n ? dp[i][j + 1] : 0;
//                 dp[i][j] = down + right;
//             }
//         }

//         return dp[0][0];
//     }
// }


// class Solution {
//     private int explorePaths(int i, int j, int m, int n, int[][] dp) {
//         // Base case: reached destination
//         if(i == m - 1 && j == n - 1) return 1;
        
//         // Base case: out of bounds
//         if(i >= m || j >= n) return 0;
        
//         // Check if already computed
//         if(dp[i][j] != -1) return dp[i][j];
        
//         // Compute and store result
//         int right = explorePaths(i + 1, j, m, n, dp);
//         int down = explorePaths(i, j + 1, m, n, dp);
        
//         dp[i][j] = right + down;
//         return dp[i][j];
//     }
    
//     public int uniquePaths(int m, int n) {
//         // Initialize memoization table with -1 (uncomputed)
//         int[][] dp = new int[m][n];
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 dp[i][j] = -1;
//             }
//         }
        
//         return explorePaths(0, 0, m, n, dp);
//     }
// }