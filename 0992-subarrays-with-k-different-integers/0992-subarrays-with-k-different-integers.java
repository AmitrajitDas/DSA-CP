class Solution {
    private int atMost(int[] nums, int k) {
        if(k == 0) return 0;
        int i = 0, res = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int j = 0; j < nums.length; j++) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            while(mp.size() > k) {
                mp.computeIfPresent(nums[i], (key, val) -> val - 1 <= 0 ? null : val - 1);
                i++;
            }

            res += j - i + 1;
        }

        return res;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        if(k == 0) return 0;
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}