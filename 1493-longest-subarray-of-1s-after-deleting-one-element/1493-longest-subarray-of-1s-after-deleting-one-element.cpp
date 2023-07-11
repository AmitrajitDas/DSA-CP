class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int maxLen = 0;
        int n = nums.size();
        int i = 0, zeroes = 0;
        
        for(int j = 0; j < n; j++) {
            if(nums[j] == 0) zeroes++;
            while(zeroes > 1) { // sliding the window
                if(nums[i] == 0) zeroes--;
                i++;
            }
            maxLen = max(maxLen, j - i); // j - i because we need to delete one element always
        }
        return maxLen;
    }
};