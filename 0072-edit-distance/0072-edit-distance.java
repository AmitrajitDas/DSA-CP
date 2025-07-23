class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        
        // Handle edge cases
        if (m == 0) return n;
        if (n == 0) return m;
        
        // DP table: dp[i][j] represents min operations to convert word1[i...m-1] to word2[j...n-1]
        // We need (m+1) x (n+1) to handle cases where we go beyond string boundaries
        int[][] dp = new int[m + 1][n + 1];
        
        // Base cases: Fill the last row and last column
        // dp[m][j] = operations needed to convert empty string to word2[j...n-1]
        for (int j = 0; j <= n; j++) {
            dp[m][j] = n - j; // Insert remaining characters of word2
        }
        
        // dp[i][n] = operations needed to convert word1[i...m-1] to empty string  
        for (int i = 0; i <= m; i++) {
            dp[i][n] = m - i; // Delete remaining characters of word1
        }
        
        // Fill the DP table from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    // Characters match, no operation needed
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    // Characters don't match, try all three operations
                    int insert = dp[i][j + 1];     // Insert word2[j]
                    int delete = dp[i + 1][j];     // Delete word1[i]
                    int replace = dp[i + 1][j + 1]; // Replace word1[i] with word2[j]
                    
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        
        return dp[0][0];
    }
}