class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, i = 0, j = 0, maxLen = 0;

        while(j < n) {
            // 1. Process the incoming element FIRST
            if(nums[j] == 0) k--;
            
            // 2. If we've used more flips than allowed, shrink from the left
            while(k < 0) {
                // Check the element leaving the window (nums[i]!)
                if(nums[i] == 0) k++;
                i++;
            }
            
            // 3. Now the window is guaranteed to be valid, so update maxLen
            maxLen = Math.max(maxLen, j - i + 1);
            
            // 4. Expand the window
            j++;
        }

        return maxLen;
    }
}