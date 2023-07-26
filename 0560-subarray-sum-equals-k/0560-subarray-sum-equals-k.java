class Solution {
    public int subarraySum(int[] nums, int k) {
        // Create a hashmap to store the prefix sum frequencies
        Map<Integer, Integer> prefixSumFreq = new HashMap<Integer, Integer>();
        int prefixSum = 0, count = 0;
        // Initialize the prefix sum 0 with frequency 1, this is for subarrays starting from the beginning
        prefixSumFreq.put(0, 1); 

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i]; // Calculate the prefix sum up to the current element
            // Check if there exists a subarray with sum equal to k
            // If prefixSum - k exists in the hashmap, it means there is a subarray from that point to the current index with sum equals k
            // So, we add the frequency of prefixSum - k to the count
            count += prefixSumFreq.getOrDefault(prefixSum - k, 0);

            // Update the frequency of the current prefix sum in the hashmap
            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return count; // Return the count of subarrays with sum equals k
    }
}
