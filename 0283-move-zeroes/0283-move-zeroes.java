class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, count = 0;
        for(int num : nums) {
            if(num != 0) {
                nums[count++] = num;
            }
        }

        while(count < n) {
            nums[count++] = 0;
        }
    }
}