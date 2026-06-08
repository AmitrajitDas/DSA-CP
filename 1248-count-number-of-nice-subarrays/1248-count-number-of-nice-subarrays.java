class Solution {
    // Helper function to count the number of subarrays with AT MOST 'k' odd numbers
    private int atMost(int[] nums, int k) {
        // A negative constraint is impossible, so 0 valid subarrays exist
        if (k < 0) return 0;
        
        int i = 0, count = 0, res = 0;

        // j acts as the right bound of our sliding window
        for(int j = 0; j < nums.length; j++) {
            // If the incoming number is odd, increment our odd number tracker
            if(nums[j] % 2 != 0) count++;

            // If we have more than 'k' odd numbers, shrink the window from the left
            while(count > k) {
                // If the number leaving the window is odd, decrement our tracker
                if(nums[i] % 2 != 0) count--;
                i++; // Move left bound forward
            }

            // (j - i + 1) represents the number of valid subarrays ending precisely at index j.
            // All subarrays from nums[i...j], nums[i+1...j], ..., down to nums[j...j] 
            // are guaranteed to have at most 'k' odd numbers.
            res += j - i + 1;
        }

        return res;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        // Math Trick:
        // (Subarrays with <= k odds) - (Subarrays with <= k - 1 odds) 
        // leaves us with EXACTLY the subarrays containing 'k' odd numbers.
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}