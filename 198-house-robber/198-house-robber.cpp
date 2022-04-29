class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n, -1);
        dp[0] = nums[0];
        
        for(int i = 1; i < n; i++) {
            
            int pick = nums[i];
            if(i > 1) pick += dp[i-2];
            int notPick = 0 + dp[i-1];
            
            dp[i] = max(pick, notPick);
        }
        
        return dp[n-1];
    }
};


////////////////// TABULATION /////////////////


// class Solution {
// public:
//     int rob(vector<int>& nums) {
//         int n = nums.size();
//         vector<int> dp(n, -1);
//         dp[0] = nums[0];
        
//         for(int i = 1; i < n; i++) {
            
//             int pick = nums[i];
//             if(i > 1) pick += dp[i-2];
//             int notPick = 0 + dp[i-1];
            
//             dp[i] = max(pick, notPick);
//         }
        
//         return dp[n-1];
//     }
// };

////////////////// MEMOIZATION /////////////////

// class Solution {
    
//     int maxSum(int i, vector<int>& nums, vector<int> &dp) {
        
//         if(i == 0) return nums[i];
//         if(i < 0) return 0;
//         if(dp[i] != -1) return dp[i];
        
//         int pick = nums[i] + maxSum(i-2, nums, dp);
//         int notPick = 0 + maxSum(i-1, nums, dp);
        
//         return dp[i] = max(pick, notPick);
//     }
    
// public:
//     int rob(vector<int>& nums) {
//         int n = nums.size();
//         vector<int> dp(n, -1);
//         return maxSum(n-1, nums, dp);
//     }
// };

////////////////// RECURSION /////////////////

// class Solution {
    
//     int maxSum(int i, vector<int>& nums) {
        
//         if(i == 0) return nums[i];
//         if(i < 0) return 0;
        
//         int pick = nums[i] + maxSum(i-2, nums);
//         int notPick = 0 + maxSum(i-1, nums);
        
//         return max(pick, notPick);
//     }
    
// public:
//     int rob(vector<int>& nums) {
//         int n = nums.size();
//         return maxSum(n-1, nums);
//     }
// };