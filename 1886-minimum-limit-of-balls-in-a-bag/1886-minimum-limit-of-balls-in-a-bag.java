class Solution {
    // Helper function to check if it is possible to divide the bags such that 
    // the maximum size of any bag is <= `pen` using at most `maxOps` operations.
    private boolean canDivideWithPenalty(int pen, int maxOps, int[] nums) {
        int ops = 0; // Track the number of operations used
        for (int num : nums) {
            if (num > pen) { 
                // Calculate how many operations are needed to make the current bag's size <= `pen`.
                ops += (num - 1) / pen; // Use ceiling logic for operations
                if (ops > maxOps) { 
                    // If the operations exceed `maxOps`, it's not feasible
                    return false;
                }
            }
        }
        // If all numbers can be divided within `maxOps` operations, return true
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        // Define the search space for the penalty:
        // The smallest penalty is `1` (minimum possible bag size),
        // and the largest penalty is the maximum number in `nums`.
        int low = 1, high = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);

        // Binary search to find the minimum penalty
        while (low < high) {
            int mid = low + (high - low) / 2; // Calculate mid safely to avoid overflow
            
            // Check if we can divide the bags such that the penalty <= `mid`
            if (canDivideWithPenalty(mid, maxOperations, nums)) {
                high = mid; // If yes, we try to lower the penalty further
            } else {
                low = mid + 1; // Otherwise, increase the penalty
            }
        }

        // After the loop, `low` will hold the minimum penalty
        return low;
    }
}
