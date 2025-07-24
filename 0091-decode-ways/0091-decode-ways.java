class Solution {
    private int memo(int idx, int n, String s, int[] dp) {
        if(idx == n) return 1;  // Base case: reached end successfully
        if(s.charAt(idx) == '0') return 0; // Invalid: can't start with 0
        if(dp[idx] != -1) return dp[idx];
        
        // Single digit decoding
        int res = memo(idx + 1, n, s, dp);
        
        // Two digit decoding (10-26)
        if(idx < n - 1 && (s.charAt(idx) == '1' || 
           (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7'))) {
            res += memo(idx + 2, n, s, dp);
        }
        
        return dp[idx] = res;
    }
    
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return memo(0, n, s, dp);
    }
}