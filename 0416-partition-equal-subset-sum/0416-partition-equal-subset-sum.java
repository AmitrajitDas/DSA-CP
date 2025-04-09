class Solution {
    /**
     * Recursive memoization function to determine if a subset with given target sum exists
     *
     * @param idx Current index in the array we're considering
     * @param target Remaining target sum to achieve
     * @param dp Memoization table to avoid recalculating subproblems
     * @param nums Input array of numbers
     * @return True if subset exists, false otherwise
     */
    private boolean memo(int idx, int target, int[][] dp, int[] nums) {
        // Base case 1: If target becomes 0, we found a valid subset
        if (target == 0) {
            return true;
        }
        
        // Base case 2: If we're at the first element, check if it equals target
        if (idx == 0) {
            return nums[idx] == target;
        }
        
        // If we've already computed this state, return the cached result
        // We use 1 for true and 0 for false in our dp table
        if (dp[idx][target] != -1) {
            return dp[idx][target] == 1;
        }
        
        // Option 1: Skip the current element
        boolean notTaken = memo(idx - 1, target, dp, nums);
        
        // Option 2: Include the current element (if possible)
        boolean taken = false;
        if (nums[idx] <= target) {
            taken = memo(idx - 1, target - nums[idx], dp, nums);
        }
        
        // Store result in dp table (1 for true, 0 for false)
        dp[idx][target] = (notTaken || taken) ? 1 : 0;
        
        return dp[idx][target] == 1;
    }
    
    /**
     * Main function to determine if the array can be partitioned into two equal sum subsets
     *
     * @param nums Array of positive integers
     * @return True if equal partition is possible, false otherwise
     */
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
        
        // Initialize dp table with -1 (unprocessed states)
        // dp[i][j] will store whether it's possible to make sum j using first i+1 elements
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        // Start recursive calculation from last index with target k
        return memo(n - 1, k, dp, nums);
    }
}