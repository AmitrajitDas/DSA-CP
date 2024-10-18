class Solution {
    // Helper method that uses backtracking to find the number of subsets with maximum OR value
    private int backtrack(int idx, int currOr, int maxOr, int[] nums) {
        // Base case: if we've processed all elements in the array
        if (idx >= nums.length) {
            // If the current OR value matches the maximum OR value, return 1 (this is a valid subset)
            return currOr == maxOr ? 1 : 0;
        }
        
        int count = 0;
        
        // Case 1: Include the current element in the subset and compute OR with the current OR value
        count += backtrack(idx + 1, currOr | nums[idx], maxOr, nums);
        
        // Case 2: Exclude the current element from the subset (i.e., keep the current OR value unchanged)
        count += backtrack(idx + 1, currOr, maxOr, nums);
        
        // Return the total count of valid subsets from both cases
        return count;
    }

    // Main method to count the number of subsets that achieve the maximum OR value
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        
        // Step 1: Calculate the maximum possible OR value across all elements in the array
        // This is done by taking the OR of all elements in the array
        for (int num : nums) {
            maxOr |= num;  // Perform OR operation to accumulate the maximum OR value
        }
        
        // Step 2: Use backtracking to find the number of subsets that achieve this max OR value
        return backtrack(0, 0, maxOr, nums);
    }
}