class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        
        // STEP 1: Initialize base cases
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 0;  // 0 coins needed for amount 0
                } else if (i == 0) {
                    dp[i][j] = Integer.MAX_VALUE;  // Impossible with 0 coins
                } else {
                    dp[i][j] = Integer.MAX_VALUE;  // Initialize to impossible
                }
            }
        }
        
        // STEP 2: Fill the DP table
        for (int i = 1; i <= n; i++) {          // For each coin type
            for (int j = 1; j <= amount; j++) {  // For each amount
                
                // Option 1: Don't take current coin (i-1)
                dp[i][j] = dp[i - 1][j];
                
                // Option 2: Take current coin (i-1) if possible
                if (coins[i - 1] <= j && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        
        // STEP 3: Return result
        return dp[n][amount] == Integer.MAX_VALUE ? -1 : dp[n][amount];
    }
}