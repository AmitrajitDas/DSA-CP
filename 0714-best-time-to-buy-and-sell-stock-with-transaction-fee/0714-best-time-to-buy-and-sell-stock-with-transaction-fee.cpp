class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int n = prices.size();
        vector<vector<int>> dp(n+1,vector<int>(2,0));    
        for(int ind= n-1; ind>=0; ind--){
            dp[ind][0] = max(0+dp[ind+1][0], -prices[ind] + dp[ind+1][1]);
            dp[ind][1] = max(0+dp[ind+1][1], prices[ind] -fee + dp[ind+1][0]);
        }
        
        return dp[0][0];
    }
};