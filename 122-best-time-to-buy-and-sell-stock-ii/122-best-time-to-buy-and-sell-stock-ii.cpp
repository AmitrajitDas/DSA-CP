class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<int> next(2, 0), curr(2, 0);
        
        next[0] = next[1] =  0; //base case
        
        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy) {
                    int buy = -prices[ind] + next[0];
                    int notBuy = next[1];
                    profit = max(buy, notBuy);
                } else {
                    int sell = prices[ind] + next[1];
                    int notSell = next[0];
                    profit = max(sell, notSell);
                }
                
                curr[buy] = profit;
            }
            
            next = curr;
        }
        
        return next[1];
    }
};


// class Solution {
// public:
//     int maxProfit(vector<int>& prices) {
//         int n = prices.size();
//         vector<vector<int>> dp(n + 1, vector<int> (2, 0));
        
//         dp[n][0] = dp[n][1] =  0; //base case
        
//         for(int ind = n - 1; ind >= 0; ind--) {
//             for(int buy = 0; buy <= 1; buy++) {
//                 int profit = 0;
//                 if(buy) {
//                     int buy = -prices[ind] + dp[ind + 1][0];
//                     int notBuy = dp[ind + 1][1];
//                     profit = max(buy, notBuy);
//                 } else {
//                     int sell = prices[ind] + dp[ind + 1][1];
//                     int notSell = dp[ind + 1][0];
//                     profit = max(sell, notSell);
//                 }
                
//                 dp[ind][buy] = profit;
//             }
//         }
        
//         return dp[0][1];
//     }
// };

// class Solution {
// public:
    
//     int memo(int ind, int buy, vector<int>& prices, vector<vector<int>> &dp) {
        
//         if(ind == prices.size()) return 0;
//         if(dp[ind][buy] != -1) return dp[ind][buy];
        
//         int profit = 0;
//         if(buy) {
//             int buy = -prices[ind] + memo(ind + 1, 0, prices, dp);
//             int notBuy = memo(ind + 1, 1, prices, dp);
//             profit = max(buy, notBuy);
//         } else {
//             int sell = prices[ind] + memo(ind + 1, 1, prices, dp);
//             int notSell = memo(ind + 1, 0, prices, dp);
//             profit = max(sell, notSell);
//         }
        
//         return dp[ind][buy] = profit;
//     }
    
    
//     int maxProfit(vector<int>& prices) {
//         int n = prices.size();
//         vector<vector<int>> dp(n, vector<int> (2, -1));
//         return memo(0, 1, prices, dp);
//     }
// };
