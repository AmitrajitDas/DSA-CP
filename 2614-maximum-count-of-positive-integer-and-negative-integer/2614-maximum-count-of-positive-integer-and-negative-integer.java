class Solution {
    // Modified binary search: high is set to nums.length so that if no non-negative is found,
    // it returns nums.length.
    private int findFirstNonNegative(int[] nums) {
        int low = 0, high = nums.length; // high is now nums.length
        while(low < high) {
            int mid = low + (high - low) / 2;
            // If current element is negative, search right.
            if(nums[mid] < 0) {
                low = mid + 1;
            } else {
                // Otherwise, search left (including mid).
                high = mid;
            }
        }
        return low; // returns nums.length if all elements are negative
    }
    
    // Similarly, modified binary search for the first positive element.
    private int findFirstPositive(int[] nums) {
        int low = 0, high = nums.length; // high is now nums.length
        while(low < high) {
            int mid = low + (high - low) / 2;
            // If current element is non-positive, search right.
            if(nums[mid] <= 0) {
                low = mid + 1;
            } else {
                // Otherwise, search left.
                high = mid;
            }
        }
        return low; // returns nums.length if no positive element is found
    }
    
    public int maximumCount(int[] nums) {
        // Count of negatives is the index of the first non-negative element.
        int negativeCount = findFirstNonNegative(nums);
        // Count of positives is total length minus the index of the first positive element.
        int positiveCount = nums.length - findFirstPositive(nums);
        return Math.max(negativeCount, positiveCount);
    }
}
