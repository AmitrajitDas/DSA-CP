class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            int pick = nums[i] + dp[i + 2];
            int notPick = dp[i + 1];

            dp[i] = Math.max(pick, notPick);
        }

        return dp[0];
    }
}