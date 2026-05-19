class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long max = 0, windowSum = 0;
        int start = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int end = 0; end < n; end++) {
            if(mp.containsKey(nums[end]) && mp.get(nums[end]) >= start) {
                int prevIndex = mp.get(nums[end]);
                while(start <= prevIndex) {
                    windowSum -= nums[start];
                    start++;
                }
            }

            windowSum += nums[end];
            mp.put(nums[end], end);

            if(end - start + 1 == k) {
                max = Math.max(max, windowSum);
                windowSum -= nums[start];
                start++;
            }
        }

        return max;
    }
}