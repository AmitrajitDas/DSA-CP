class Solution {

    // Helper function to recursively calculate the sum of XORs of all subsets
    private int rec(int level, int currentXOR, int[] nums) {
        // Base case: if we've considered all elements
        if (level == nums.length) {
            return currentXOR; // Return the XOR value of the current subset
        }

        // Recursively calculate the XOR sum if we include the current element in the subset
        int take = rec(level + 1, currentXOR ^ nums[level], nums);

        // Recursively calculate the XOR sum if we do not include the current element in the subset
        int notTake = rec(level + 1, currentXOR, nums);

        // Return the sum of both possibilities
        return take + notTake;
    }

    // Public method to start the recursion from the initial state
    public int subsetXORSum(int[] nums) {
        return rec(0, 0, nums); // Start recursion with level 0 and initial XOR value 0
    }
}
