class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        long cnt = 0; int left = 0;
        for (int i = 0; i < nums.length; i++) {
            k -= mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
            while (k <= 0) {
                mpp.put(nums[left], mpp.get(nums[left]) - 1);
                k += mpp.get(nums[left++]);
            }
            cnt += left;
        }
        return cnt;
    }
}