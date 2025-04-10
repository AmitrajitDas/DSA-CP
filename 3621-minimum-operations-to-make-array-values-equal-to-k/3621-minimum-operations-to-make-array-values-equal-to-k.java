class Solution {
    public int minOperations(int[] nums, int k) {
        // Sort unique values greater than k
        Set<Integer> uniqueValues = new HashSet<>();
        for (int num : nums) {
            if (num > k) {
                uniqueValues.add(num);
            } else if (num < k) {
                // If there's at least one value less than k, it's impossible
                return -1;
            }
        }
        
        // Return the number of unique values greater than k
        return uniqueValues.size();
    }
}