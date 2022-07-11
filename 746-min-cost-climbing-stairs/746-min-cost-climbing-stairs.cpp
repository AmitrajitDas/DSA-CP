class Solution {
public:
    
    int memo(int ind, vector<int> &cost, vector<int> &dp) {
        
        if(ind == 1 || ind == 0) return cost[ind];
        if(dp[ind] != - 1) return dp[ind];
        return dp[ind] = cost[ind] + min(memo(ind - 1, cost, dp), memo(ind - 2, cost, dp));
    }
    
    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size();
        vector<int> dp(n, -1);
        return min(memo(n - 1, cost, dp), memo(n - 2, cost, dp));
    }
};