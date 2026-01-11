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
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return calculateLength(0, -1, nums, dp);
    }
}