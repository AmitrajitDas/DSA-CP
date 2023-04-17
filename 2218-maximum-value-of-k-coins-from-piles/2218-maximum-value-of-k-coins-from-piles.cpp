class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        int n = piles.size();
        vector<vector<int>> dp(n + 1, vector<int>(k + 1));
        
        for(int i = 1; i<= n; i++) {
            for(int coins = 0; coins <= k; coins++) {
                int sum = 0;
                for(int currCoins = 0; currCoins <= min((int)piles[i - 1].size(), coins); currCoins++) {
                    if(currCoins > 0) sum += piles[i-1][currCoins-1];
                    
                    dp[i][coins] = max(dp[i][coins], sum + dp[i-1][coins - currCoins]);
                    
                }
            }
        }
        
        return dp[n][k];
        
    }
};

// class Solution {
//     int n;
//     int dp[1001][2001];
// private:
//     int rec(int i, int k, vector<vector<int>>& piles) {
//         if(i >= n) return 0;
//         if(dp[i][k] != -1) return dp[i][k]; 
//         int notTaken = rec(i + 1, k, piles);
//         int taken = 0, sum = 0;
//         for(int j = 0; j < min(k, (int)piles[i].size()); j++) {
//             sum += piles[i][j];
//             taken = max(taken, sum + rec(i + 1, k - (j + 1), piles));
//         }
//         return dp[i][k] = max(notTaken, taken);
//     }
// public:
//     int maxValueOfCoins(vector<vector<int>>& piles, int k) {
//         n = piles.size();
//         memset(dp, -1, sizeof(dp));
//         return rec(0, k, piles);
//     }
// };