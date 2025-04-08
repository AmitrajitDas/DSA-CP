class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        // Calculate the total sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // Using streams (alternative):
        // int sum = IntStream.of(nums).sum();

        // If the sum is odd, we cannot partition it into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        // dp[i][k] will be true if the sum k can be formed using items up to index i
        // Dimensions: n rows (for items 0 to n-1), target + 1 columns (for sums 0 to target)
        boolean[][] dp = new boolean[n][target + 1];

        // Base case: A sum of 0 is always possible (by taking no items)
        // Although the C++ code initializes all i, only dp[0][0] is truly needed 
        // before the first item's specific initialization. Let's follow the C++ logic directly.
        for (int i = 0; i < n; i++) {
            dp[i][0] = true; 
        }

        // Handle the first item specifically
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) { // Iterate through items starting from the second item
            for (int k = 1; k <= target; k++) { // Iterate through possible sums
                // Option 1: Don't take the current item nums[i]
                // The result is the same as for the previous item dp[i-1][k]
                boolean notTaken = dp[i - 1][k];

                // Option 2: Take the current item nums[i]
                // This is only possible if the current sum k is >= nums[i]
                boolean taken = false;
                if (nums[i] <= k) {
                    // If we take nums[i], we need to check if the remaining sum (k - nums[i])
                    // could be formed using previous items (up to index i-1)
                    taken = dp[i - 1][k - nums[i]];
                }

                // dp[i][k] is true if we can achieve the sum k either by taking or not taking nums[i]
                dp[i][k] = taken || notTaken;
            }
        }

        // The final answer is whether the target sum can be achieved using items up to index n-1
        return dp[n - 1][target];
    }
}