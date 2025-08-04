class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        // Calculate total sum of all elements
        int sum = Arrays.stream(nums).sum();
        
        // If sum is odd, we cannot partition into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }
        
        // Target sum for each subset (half of total sum)
        int target = sum / 2;
        
        // DP table: dp[i][j] = can we achieve sum j using elements from index i to n-1
        boolean[][] dp = new boolean[n + 1][target + 1]; // Fixed: was int instead of boolean
        
        // Base case: sum 0 is always achievable (by taking no elements)
        for (int i = 0; i <= n; i++) { // Fixed: should go up to n (inclusive)
            dp[i][0] = true;
        }
        
        // Fill DP table from bottom-up (last element to first)
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 0; j <= target; j++) {
                // Option 1: Don't take current element nums[i]
                boolean notTake = dp[i + 1][j];
                
                // Option 2: Take current element nums[i] (if possible)
                boolean take = false;
                if(nums[i] <= j) {
                    take = dp[i + 1][j - nums[i]];
                }
                
                // Current state is true if either option works
                dp[i][j] = take || notTake;
            }
        }
        
        // Answer: can we achieve target sum using all elements (starting from index 0)
        return dp[0][target];
    }
}