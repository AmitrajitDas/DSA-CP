// TC :- O(N), SC :- O(1) 

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n = nums.size(), count = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) nums[count++] = nums[i]; // storing non-zero elements first
        }
        while(count < n) nums[count++] = 0; // storing zeroes at the end
    }
};