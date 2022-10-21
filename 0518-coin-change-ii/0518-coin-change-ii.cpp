class Solution {
private:
    int combos(int idx, int target, vector<int> &coins, vector<vector<int>> &dp) {
        if(idx == 0) {
            return target % coins[idx] == 0;
        }
        
        if(dp[idx][target] != -1) return dp[idx][target];
        
        int notPick = combos(idx - 1, target, coins, dp);
        int pick = 0;
        if(target >= coins[idx]) pick = combos(idx, target - coins[idx], coins, dp);
        
        return dp[idx][target] = notPick + pick;
    }
public:
    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<vector<int>> dp(n, vector<int> (amount + 1, -1));
        return combos(n - 1, amount, coins, dp);
    }
};