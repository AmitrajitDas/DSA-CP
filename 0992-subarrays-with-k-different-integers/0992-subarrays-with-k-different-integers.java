class Solution {
    
    // Helper function to count all subarrays containing AT MOST 'k' distinct integers
    private int atMost(int[] nums, int k) {
        // A subarray cannot contain at most 0 distinct elements from an integer array
        if (k == 0) return 0;
        
        int i = 0, res = 0;
        // Map to track the frequency of each integer in the current window
        Map<Integer, Integer> mp = new HashMap<>();

        // Expand the window using the right pointer 'j'
        for (int j = 0; j < nums.length; j++) {
            // Include nums[j] in the window and increment its frequency
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            
            // If the window has more than 'k' distinct elements, shrink it from the left
            while (mp.size() > k) {
                // Decrement the frequency of nums[i]. If it hits 0, computeIfPresent removes the key (returns null)
                mp.computeIfPresent(nums[i], (key, val) -> val - 1 <= 0 ? null : val - 1);
                i++; // Move left pointer forward
            }

            // All subarrays ending at 'j' and starting between 'i' and 'j' are valid.
            // The number of such valid subarrays is exactly equal to the current window size.
            res += j - i + 1;
        }

        return res;
    }

    // Main function to find subarrays with EXACTLY 'k' distinct integers
    public int subarraysWithKDistinct(int[] nums, int k) {
        if (k == 0) return 0;
        
        // Exact(K) = AtMost(K) - AtMost(K - 1)
        // Subtracting everything with at most K-1 elements leaves only subarrays with exactly K elements.
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}