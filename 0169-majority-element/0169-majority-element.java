class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        int ele = 0;

        // moore's voting algo
        for(int num : nums) {
            if(count == 0) {
                count = 1;
                ele = num;
            } else if(ele == num) {
                count++;
            } else {
                count--;
            }
        }

        return ele;
    }
}