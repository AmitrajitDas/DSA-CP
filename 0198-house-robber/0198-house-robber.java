class Solution {
    private int memo(int i, int n, int[] nums, int[] dp) {
        if(i >= n) return 0;
        if(i == n - 1) return nums[i];
        if(dp[i] != -1) return dp[i];

        int pick = nums[i] + memo(i + 2, n, nums, dp);
        int notPick = memo(i + 1, n, nums, dp);

        return dp[i] = Math.max(pick, notPick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return memo(0, n, nums, dp);
    }
}