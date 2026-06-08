class Solution {
    private int atMost(int[] nums, int k) {
        int i = 0, count = 0, res = 0;

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] % 2 != 0) count++;

            while(count > k) {
                if(nums[i] % 2 != 0) count--;
                i++;
            }

            res += j - i + 1;
        }

        return res;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
}