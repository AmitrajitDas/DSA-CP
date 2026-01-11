class Solution {
    private int calculateLength(int idx, int prevIdx, int[] nums, int[][] dp) {
        if (idx >= nums.length) return 0;
        if (dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];
        
        int take = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            take = 1 + calculateLength(idx + 1, idx, nums, dp);
        }
        
        int skip = calculateLength(idx + 1, prevIdx, nums, dp);

        dp[idx][prevIdx + 1] = Math.max(take, skip);
        return dp[idx][prevIdx + 1];
    }
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // int[][] dp = new int[n][n];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }

        // return calculateLength(0, -1, nums, dp);

        // int[][] dp = new int[n + 1][n + 1];

        // for(int idx = n - 1; idx >= 0; idx--) {
        //     for(int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
        //         int take = 0;
        //         if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
        //             take = 1 + dp[idx + 1][idx + 1];
        //         }
                
        //         int skip = dp[idx + 1][prevIdx + 1];

        //         dp[idx][prevIdx + 1] = Math.max(take, skip);
        //     }
        // }

        // return dp[0][0];

        int[] dp = new int[n];
        Arrays.fill(dp, 1);  // Each element is an LIS of length 1
        
        int maxLen = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        return maxLen;
    }
}