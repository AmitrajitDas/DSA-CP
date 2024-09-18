class Solution {
    // Helper function to count how many subarrays we can create with sum <= limit
    private int countSum(int[] nums, int limit) {
        int count = 1, sum = 0;  // Start with one subarray and an initial sum of 0
        for (int num : nums) {
            if (sum + num > limit) {  // If adding num exceeds the current limit
                count++;  // We need a new subarray
                sum = num;  // Start a new subarray with the current num
            } else {
                sum += num;  // Otherwise, add num to the current subarray sum
            }
        }
        return count;  // Return the number of subarrays created
    }

    public int splitArray(int[] nums, int k) {
        // Step 1: Initialize the binary search boundaries
        int low = Arrays.stream(nums).max().getAsInt();  // Minimum possible limit is the largest element
        int high = Arrays.stream(nums).sum();  // Maximum possible limit is the sum of all elements

        // Step 2: Binary search for the smallest maximum subarray sum
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Calculate the mid-point of the current range

            // Check if we can split the array into k or fewer subarrays with each subarray sum <= mid
            if (countSum(nums, mid) > k) {
                low = mid + 1;  // If we need more than k subarrays, increase the minimum limit
            } else {
                high = mid - 1;  // Otherwise, try a smaller limit
            }
        }

        // Step 3: Return the smallest possible maximum subarray sum
        return low;
    }
}
