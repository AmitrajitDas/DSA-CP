class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base case: when i = 0 (all of s1 processed)
        // Need to delete all remaining characters in s2
        for (int j = 1; j <= n; j++) {
            dp[0][j] = s2.charAt(j - 1) + dp[0][j - 1];
        }
        
        // Base case: when j = 0 (all of s2 processed)
        // Need to delete all remaining characters in s1
        for (int i = 1; i <= m; i++) {
            dp[i][0] = s1.charAt(i - 1) + dp[i - 1][0];
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int delete_s1_i = s1.charAt(i - 1) + dp[i - 1][j];
                    int delete_s2_j = s2.charAt(j - 1) + dp[i][j - 1];
                    dp[i][j] = Math.min(delete_s1_i, delete_s2_j);
                }
            }
        }

        return dp[m][n];
    }
}