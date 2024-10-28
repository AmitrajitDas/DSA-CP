class Solution {
    public int longestSquareStreak(int[] nums) {
        // Map to store the longest streak ending at each number
        Map<Integer, Integer> mp = new HashMap<>();
        int res = -1; // Initialize result as -1 to handle cases where no square streak exists
        
        // Step 1: Sort the array to process numbers in increasing order
        Arrays.sort(nums);

        // Step 2: Iterate over each number in the sorted array
        for (int num : nums) {
            // Calculate the integer square root of the current number
            int sqrt = (int) Math.sqrt(num);
            
            // Check if `num` is a perfect square and its square root exists in the map (i.e., `sqrt * sqrt == num`)
            if (sqrt * sqrt == num && mp.containsKey(sqrt)) {
                // If the square root's streak exists, update `num`'s streak by extending `sqrt`'s streak
                mp.put(num, mp.get(sqrt) + 1);
                
                // Update the result to keep track of the longest square streak found so far
                res = Math.max(res, mp.get(num));
            } else {
                // If `num` is not part of an existing square streak, initialize its streak as 1
                mp.put(num, 1);
            }
        }

        // Return the longest square streak found, or -1 if none exists
        return res;
    }
}