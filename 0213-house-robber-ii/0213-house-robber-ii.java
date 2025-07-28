class Solution {
     private int robLinear(int[] nums, int start, int end) {
        int prevRob = 0, prevNotRob = 0;
        
        for (int i = start; i <= end; i++) {
            int currRob = prevNotRob + nums[i];
            int currNotRob = Math.max(prevRob, prevNotRob);
            
            prevRob = currRob;
            prevNotRob = currNotRob;
        }
        
        return Math.max(prevRob, prevNotRob);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        return Math.max(
            robLinear(nums, 0, n - 2),  // Rob houses 0 to n-2 (exclude last)
            robLinear(nums, 1, n - 1)   // Rob houses 1 to n-1 (exclude first)
        );
    }
}