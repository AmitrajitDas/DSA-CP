class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        // Calculate total sum of array
        int sum = Arrays.stream(nums).sum();
        
        // If sum is odd, equal partition is impossible
        if (sum % 2 != 0) {
            return false;
        }
        
        // Our target is half of the total sum
        int k = sum / 2;
        
        // Initialize dp table
        // dp[i][j] represents whether we can form a sum of j using elements up to index i
        boolean[][] dp = new boolean[n][k + 1];
        
        // Base case: It's always possible to form a sum of 0 (by taking no elements)
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        
        // Special case for the first element
        // If the first element is less than or equal to k, we can form that sum
        if (nums[0] <= k) {
            dp[0][nums[0]] = true;
        }
        
        // Fill the dp table using bottom-up approach
        for (int idx = 1; idx < n; idx++) {
            for (int target = 1; target <= k; target++) {
                // Option 1: Skip the current element (use result from previous row)
                boolean notTaken = dp[idx - 1][target];
                
                // Option 2: Include the current element if possible
                boolean taken = false;
                if (nums[idx] <= target) {
                    taken = dp[idx - 1][target - nums[idx]];
                }
                
                // Can form the target if either option works
                dp[idx][target] = notTaken || taken;
            }
        }
        
        // Final answer is whether we can form sum k using all elements
        return dp[n - 1][k];
    }
}