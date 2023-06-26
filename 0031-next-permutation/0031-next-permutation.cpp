class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        int breakpoint;
        // finding the breakpoint of decrement
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                breakpoint = i;
                break;
            } 
        }
        /* breakpoint won't be found if the order is in decreasing ie last permutation.
        So we reverse the order to get the first permutation */
        if(breakpoint < 0) reverse(nums.begin(), nums.end());
        else {
            // finding the next greater number than the number found on breakpoint index
            for(int i = n - 1; i > breakpoint; i--) { // doing it reverse to get the increasing order
                if(nums[i] > nums[breakpoint]) {
                    swap(nums[i], nums[breakpoint]);
                    break;
                } 
            }
            // sorting the subarray after breakpoint so that the order gets increasing
            reverse(nums.begin() + breakpoint + 1, nums.end());
        }
    }
};