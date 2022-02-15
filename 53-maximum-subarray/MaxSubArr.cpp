class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        
        int res = nums[0];
        int maxEnding = nums[0];
        
        for(int i = 1; i < nums.size(); i++)
        {
            maxEnding = max(maxEnding + nums[i], nums[i]);
            res = max(res, maxEnding);
        }
        
        return res;
    }
};
