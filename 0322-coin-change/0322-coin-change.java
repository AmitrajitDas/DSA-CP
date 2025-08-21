class Solution {
    private int memo(int idx, int sum, int[] coins, int[][] dp) {
        // Base case: if sum becomes 0, no more coins needed
        if (sum == 0) return 0;
        
        // Base case: if we've exhausted all coins or sum becomes negative
        if (idx < 0 || sum < 0) return Integer.MAX_VALUE;
        
        // Check if already computed
        if (dp[idx][sum] != -1) return dp[idx][sum];
        
        // Option 1: Don't take current coin
        int notTake = memo(idx - 1, sum, coins, dp);
        
        // Option 2: Take current coin (if possible)
        int take = Integer.MAX_VALUE;
        if (sum >= coins[idx]) {
            int result = memo(idx, sum - coins[idx], coins, dp);  // idx stays same (unlimited coins)
            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }
        
        // Store and return minimum
        dp[idx][sum] = Math.min(notTake, take);
        return dp[idx][sum];
    }
    
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];  // amount + 1 for 0-based indexing
        
        // Initialize with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int result = memo(n - 1, amount, coins, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}