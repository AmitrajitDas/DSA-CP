class Solution {
    // Find the smallest index where nums[index] >= target
    private int findLowerBound(int[] nums, int left, int right, int target) {
        int result = right + 1; // Default if no element >= target
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1; // Look for smaller index
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    // Find the largest index where nums[index] <= target
    private int findUpperBound(int[] nums, int left, int right, int target) {
        int result = left - 1; // Default if no element <= target
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= target) {
                result = mid;
                left = mid + 1; // Look for larger index
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Sort the array first
        Arrays.sort(nums);
        long count = 0;
        
        // For each element, find the range of valid pairs
        for (int i = 0; i < nums.length - 1; i++) {
            // Find the smallest index j > i where nums[i] + nums[j] >= lower
            int leftBound = findLowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);
            
            // Find the largest index j > i where nums[i] + nums[j] <= upper
            int rightBound = findUpperBound(nums, i + 1, nums.length - 1, upper - nums[i]);
            
            // If valid range exists, add count of elements in range
            if (leftBound <= rightBound) {
                count += (rightBound - leftBound + 1);
            }
        }
        
        return count;
    }
}