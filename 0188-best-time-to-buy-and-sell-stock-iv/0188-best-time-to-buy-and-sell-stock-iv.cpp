class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        vector<vector<vector<int>>> dp(n + 1, vector<vector<int>> (2, vector<int> (k + 1, 0)));

        for(int idx = n - 1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int count = 1; count <= k; count++) {
                    if(buy) dp[idx][buy][count] = max(-prices[idx] + dp[idx + 1][0][count], dp[idx + 1][1][count]);
                    else dp[idx][buy][count] = max(prices[idx] + dp[idx + 1][1][count - 1], dp[idx + 1][0][count]);
                }
            }
        }

        return dp[0][1][k];
    }
};