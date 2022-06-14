class Solution {
public:
    
    bool canPartition(vector<int>& nums) {
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        vector<vector<bool>> dp(n, vector<bool> (target + 1, false));
        
        for(int i = 0; i < n; i++) dp[i][0] = true;
                               
        if(nums[0] <= target) dp[0][nums[0]] = true;
                               
        for(int i = 1; i < n; i++) {
            for(int k = 1; k <= target; k++) {
                
                bool notTaken = dp[i - 1][k];
                bool taken  = false;
                
                if(nums[i] <= k)
                    taken = dp[i - 1][k - nums[i]];
                
                dp[i][k] = notTaken || taken;
            }
        }
                                
        return dp[n - 1][target];
    }
};


///// MEMOIZATION /////

// class Solution {
// public:
    
//     bool recurse(vector<int> &nums, int idx, int target, vector<vector<int>> &dp) {
        
//         if(target == 0) return true;
//         if(idx == 0) return nums[idx] == target;
        
//         if(dp[idx][target] != -1) return dp[idx][target];
        
//         bool notTaken = recurse(nums, idx - 1, target, dp);
//         bool taken = false;
        
//         if(nums[idx] <= target)
//             taken = recurse(nums, idx - 1, target - nums[idx], dp);
        
//         return dp[idx][target] = notTaken || taken;
//     }
    
//     bool canPartition(vector<int>& nums) {
//         int n = nums.size();
//         int sum = accumulate(nums.begin(), nums.end(), 0);
//         if(sum % 2 != 0) return false;
//         int k = sum / 2;
//         vector<vector<int>> dp(n, vector<int> (k + 1, -1));
//         return recurse(nums, n - 1, k, dp); 
//     }
// };