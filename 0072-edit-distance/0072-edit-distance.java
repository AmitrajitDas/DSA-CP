class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // Create a 2D DP array to store the minimum edit distance between substrings of word1 and word2.
        // dp[i][j] represents the minimum edit distance between the first i characters of word1 and the first j characters of word2.
        int[][] dp = new int[n + 1][m + 1];

        // Base case: If one of the strings is empty, the edit distance is the length of the other string.
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        // Fill the DP array using bottom-up dynamic programming approach.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If the characters at the current positions are equal, no operation is needed (cost = 0)
                // So, the minimum edit distance is the same as the previous substring (dp[i - 1][j - 1]).
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the characters are not equal, we have three options:
                    // 1. Insert: dp[i][j - 1] represents the minimum edit distance when inserting a character from word2.
                    // 2. Delete: dp[i - 1][j] represents the minimum edit distance when deleting a character from word1.
                    // 3. Replace: dp[i - 1][j - 1] represents the minimum edit distance when replacing a character in word1 with a character from word2.
                    // We choose the minimum of these options and add 1 to represent the current operation (insert, delete, or replace).
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        // The final result is stored in dp[n][m], which represents the minimum edit distance between the entire word1 and word2.
        return dp[n][m];
    }
}
