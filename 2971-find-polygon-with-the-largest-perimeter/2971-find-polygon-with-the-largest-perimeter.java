class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0, res = -1;

        for(int i = 0; i < nums.length; i++) {
            if(sum > nums[i]) res = sum + nums[i];
            sum += nums[i];
        }

        return res;
    }
}