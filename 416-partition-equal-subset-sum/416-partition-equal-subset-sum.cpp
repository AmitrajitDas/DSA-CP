class Solution {
public:
    
    bool recurse(vector<int> &nums, int idx, int target, vector<vector<int>> &dp) {
        
        if(target == 0) return true;
        if(idx == 0) return nums[idx] == target;
        
        if(dp[idx][target] != -1) return dp[idx][target];
        
        bool notTaken = recurse(nums, idx - 1, target, dp);
        bool taken = false;
        
        if(nums[idx] <= target)
            taken = recurse(nums, idx - 1, target - nums[idx], dp);
        
        return dp[idx][target] = notTaken || taken;
    }
    
    bool canPartition(vector<int>& nums) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if(sum % 2 != 0) return false;
        int k = sum / 2;
        vector<vector<int>> dp(n, vector<int> (k + 1, -1));
        return recurse(nums, n - 1, k, dp); 
    }
};