class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(n + 1, vector<int> (2, -1));
        dp[n][0] = dp[n][1] =  0; //base case

        for(int idx = n - 1; idx >= 0; idx--) {
            for(int buy = 0; buy < 2; buy++) {
                int profit = 0;
                if(buy) {
                    int bought = -prices[idx] + dp[idx + 1][0];
                    int notBought = dp[idx + 1][buy];
                    profit = max(bought, notBought);
                } else {
                    int sold = prices[idx] + dp[idx + 1][1];
                    int notSold = dp[idx + 1][buy];
                     profit = max(sold, notSold);
                }

                dp[idx][buy] = profit;
            }
        }

        return dp[0][1];
    }
};

// class Solution {
// private:
//     int dfs(int idx, bool buy, vector<int>& prices, vector<vector<bool>>& dp) {
//         if(idx == prices.size()) return 0;
//         if(dp[idx][buy] != -1) return dp[idx][buy];

//         int profit = 0; // min profit
//         if(buy) {
//             int bought = -prices[idx] + dfs(idx + 1, false, prices, dp);
//             int notBought = dfs(idx + 1, buy, prices, dp);
//             profit = max(bought, notBought);
//         } else {
//             int sold = prices[idx] + dfs(idx + 1, true, prices, dp);
//             int notSold = dfs(idx + 1, buy, prices, dp);
//             profit = max(sold, notSold);
//         }

//         return dp[idx][buy] = profit;
//     }
// public:
//     int maxProfit(vector<int>& prices) {
//         int n = prices.size();
//         vector<vector<int>> dp(n, vector<bool> (2, -1));
//         return dfs(0, true, prices, dp);
//     }
// };