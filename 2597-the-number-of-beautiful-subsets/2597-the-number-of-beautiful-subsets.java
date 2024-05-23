class Solution {
    private int count = 0;
    private void genSubsets(int idx, int[] nums, int k, Map<Integer, Integer> mp) {
        if (idx == nums.length) {
            return;
        }

        // Check if we can include nums[idx] in the current subset
        if (!mp.containsKey(nums[idx] - k) && !mp.containsKey(nums[idx] + k)) {
            mp.put(nums[idx], mp.getOrDefault(nums[idx], 0) + 1);
            count++;  // Increment count as we found a valid subset
            genSubsets(idx + 1, nums, k, mp);
            mp.put(nums[idx], mp.get(nums[idx]) - 1);  // Backtrack
            if (mp.get(nums[idx]) == 0) {
                mp.remove(nums[idx]);
            }
        }

        // Generate subsets without including nums[idx]
        genSubsets(idx + 1, nums, k, mp);
    }

    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        // Start generating subsets from index 0
        genSubsets(0, nums, k, mp);
        return count;
    }
}