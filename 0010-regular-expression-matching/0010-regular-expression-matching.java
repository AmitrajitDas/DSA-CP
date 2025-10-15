class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] means s[0...i-1] matches p[0...j-1]
        // We use i+1, j+1 size to handle empty string cases
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Fill first row: empty string with pattern
        // Pattern like "a*", "a*b*" can match empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);
                
                if (pChar == '*') {
                    // '*' matches with preceding character
                    char prevChar = p.charAt(j - 2);
                    
                    // Option 1: Match zero occurrences (skip char*)
                    dp[i][j] = dp[i][j - 2];
                    
                    // Option 2: Match one or more occurrences
                    if (prevChar == sChar || prevChar == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // Regular character or '.'
                    if (pChar == sChar || pChar == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}