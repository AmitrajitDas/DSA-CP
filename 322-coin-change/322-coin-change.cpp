class Solution {
public:
    
    int recurse(int idx, int target, vector<int> &coins, vector<vector<int>> &dp)
    {
        if(idx == 0)
        {
            if(target % coins[idx] == 0) return target / coins[idx];
            else return 1e9;
        }
        
        if(dp[idx][target] != -1) return dp[idx][target];
        
        int notTake = 0 + recurse(idx - 1, target, coins, dp);
        int take = 1e9;
        if(coins[idx] <= target)
            take = 1 + recurse(idx, target - coins[idx], coins, dp);
        
        return dp[idx][target] = min(notTake, take);
    }
    
    int coinChange(vector<int>& coins, int amount) 
    {
        int n = coins.size();
        vector<vector<int>> dp(n, vector<int> (amount + 1, -1));
        int res = recurse(n - 1, amount, coins, dp);
        return res == 1e9 ? -1 : res;
    }
};