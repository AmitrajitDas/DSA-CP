class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int sum = 0, maxSum = nums[0];
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
}