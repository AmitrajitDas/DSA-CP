class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<vector<int>>> dp(n + 1, vector<vector<int>> (2, vector<int>(3, 0)));
        
        // As dp array is intialized to 0, we have already covered the base case
        
        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
               for(int count = 1; count <= 2; count++) {
                   if(buy) dp[ind][buy][count] = max(-prices[ind] + dp[ind + 1][0][count], dp[ind + 1][1][count]);
                   else dp[ind][buy][count] = max(prices[ind] + dp[ind + 1][1][count - 1], dp[ind + 1][0][count]);
               } 
            }
        }
        
        return dp[0][1][2];
    }
};

////// MEMO /////

// class Solution {
// public:
    
//     int findMaxProfit(int ind, int buy, int count, vector<int> &prices, vector<vector<vector<int>>> &dp) {
        
//         if(count == 0 || ind == prices.size()) return 0;
//         if(dp[ind][buy][count] != -1) return dp[ind][buy][count];
        
//         if(buy) return dp[ind][buy][count] = max(-prices[ind] + findMaxProfit(ind + 1, 0, count, prices, dp), findMaxProfit(ind + 1, 1, count, prices, dp));
        
//         return dp[ind][buy][count] = max(prices[ind] + findMaxProfit(ind + 1, 1, count - 1, prices, dp), findMaxProfit(ind + 1, 0, count, prices, dp));
//     }
    
//     int maxProfit(vector<int>& prices) {
//         int n = prices.size();
//         vector<vector<vector<int>>> dp(n, vector<vector<int>> (2, vector<int>(3, -1)));
//         return findMaxProfit(0, 1, 2, prices, dp);
//     }
// };