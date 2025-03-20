class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, maxLen = 1, currMask = 0; // Initialize pointers, max length, and bitmask
        
        // Iterate through the array with the right pointer
        for(int right = 0; right < n; right++) {
            // If adding nums[right] causes a conflict (common bits set), shrink the window
            while((currMask & nums[right]) != 0) {  
                currMask ^= nums[left]; // Remove nums[left] from the bitmask
                left++; // Move left pointer to shrink the window
            }
            
            // Add nums[right] to the bitmask
            currMask |= nums[right];
            
            // Update max length of a "nice" subarray
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen; // Return the maximum length of the nice subarray
    }
}
