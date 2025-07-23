class Solution {
    private int findDistance(int i, int j, int m, int n, int[][] dp, String word1, String word2) {
        // Base case 1: If we've processed all of word1, we need to insert remaining characters of word2
        if(i >= m) return n - j;
        
        // Base case 2: If we've processed all of word2, we need to delete remaining characters of word1  
        if(j >= n) return m - i;
        
        // Check memoization
        if(dp[i][j] != -1) return dp[i][j];
        
        // If characters match, move both pointers forward
        if(word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = findDistance(i + 1, j + 1, m, n, dp, word1, word2);
        } else {
            // Three operations:
            int insert = findDistance(i, j + 1, m, n, dp, word1, word2);      // Insert word2[j]
            int delete = findDistance(i + 1, j, m, n, dp, word1, word2);      // Delete word1[i]
            int replace = findDistance(i + 1, j + 1, m, n, dp, word1, word2); // Replace word1[i] with word2[j]
            
            return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
    }
    
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        
        // Handle edge cases
        if(m == 0) return n;
        if(n == 0) return m;
        
        int[][] dp = new int[m][n];
        
        // Initialize DP table with -1
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return findDistance(0, 0, m, n, dp, word1, word2);
    }
}