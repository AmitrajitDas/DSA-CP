class Solution {    
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            
            int res = dp[i + 1];
            if(i < n - 1 && (s.charAt(i) == '1' || 
            (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                res += dp[i + 2];
            }

            dp[i] = res;
        }

        return dp[0];
    }
}