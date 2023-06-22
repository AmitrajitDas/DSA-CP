class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int n = prices.size();
        vector<vector<int>> dp(n + 1, vector<int> (2, 0));
        // dp[n][0] = dp[n][1] = 0; already gets handled in initialization

        for(int idx = n - 1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy) {
                    int bought = -prices[idx] + dp[idx + 1][0];
                    int notBought = dp[idx + 1][buy];
                    profit = max(bought, notBought);
                } else {
                    int sold = prices[idx] - fee + dp[idx + 1][1];
                    int notSold = dp[idx + 1][buy];
                    profit = max(sold, notSold);
                }

                dp[idx][buy] = profit;
            }
        }

        return dp[0][1];
    }
};