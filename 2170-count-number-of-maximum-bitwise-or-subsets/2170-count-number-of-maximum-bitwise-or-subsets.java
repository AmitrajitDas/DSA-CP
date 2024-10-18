class Solution {
    private int backtrack(int idx, int currOr, int maxOr, int[] nums) {
        if(idx >= nums.length) {
            return currOr == maxOr ? 1 : 0;
        }
        int count = 0;
        count += backtrack(idx + 1, currOr | nums[idx], maxOr, nums);
        count += backtrack(idx + 1, currOr, maxOr, nums);
        return count;
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int num : nums) {
            maxOr |= num;
        }
        return backtrack(0, 0, maxOr, nums);
    }
}