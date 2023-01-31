class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int i = 0, j = 0, res = 0, n = nums.size();

        while(j < n) {
            if(nums[j] == 0) k--; // decreasing k
            if(k < 0 && nums[i++] == 0) k++; // increasing it again to reset the window
            j++;
        }

        return j - i;
    }
};