class Solution {
public:
    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<vector<int>> dp(n, vector<int> (amount + 1));
        
        for(int i = 0; i <= amount; i++) {
                dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }
        
        for(int idx = 1; idx < n; idx++) {
            for(int target = 0; target <= amount; target++) {
                int notPick = dp[idx - 1][target];
                int pick = 0;
                if(target >= coins[idx]) pick = dp[idx][target - coins[idx]];
                
                dp[idx][target] = notPick + pick;
            }
        }
        
        return dp[n - 1][amount];
    }
};