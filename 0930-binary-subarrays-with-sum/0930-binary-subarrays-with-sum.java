class Solution {
    private int subArrays(int[] nums, int goal) {
        if(goal < 0) return 0;

        int i = 0, sum = 0, res = 0;

        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while(sum > goal) {
                sum -= nums[i++];
            }
            res += j - i + 1;
        }

        return res;
     }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return subArrays(nums, goal) - subArrays(nums, goal - 1);
    }
}