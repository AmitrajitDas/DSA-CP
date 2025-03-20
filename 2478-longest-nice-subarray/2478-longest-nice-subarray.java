class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, maxLen = 1, currMask = 0;

        for(int right = 0; right < n; right++) {
            while((currMask & nums[right]) != 0) {
                currMask ^= nums[left];
                left++;
            }
            currMask |= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}