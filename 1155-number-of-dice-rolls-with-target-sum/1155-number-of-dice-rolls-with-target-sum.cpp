// class Solution {
// private:
//     const int MOD = 1e9 + 7;
//     int rec(int n, int k, int target, vector<vector<int>> &dp) {
//         if(target == 0 && n == 0) return 1;
//         if(n == 0 || target <= 0) return 0;
//         if(dp[n][target] != -1) return dp[n][target] % MOD;

//         int ways = 0;
//         for(int i = 1; i <= k; i++) {
//             ways = (ways + rec(n - 1, k, target - i, dp)) % MOD;
//         }
        
//         return dp[n][target] = ways % MOD;
//     }

// public:
//     int numRollsToTarget(int n, int k, int target) {
//         vector<vector<int>> dp(n + 1, vector<int> (target + 1, - 1));
//         return rec(n, k, target, dp);
//     }
// };

class Solution {
public:
    int numRollsToTarget(int n, int k, int target) {
        const int MOD = 1e9 + 7;
        vector<vector<int>> dp(n + 1, vector<int> (target + 1));
        dp[0][0] = 1;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= target; ++j) {
                for (int x = 1; x <= k && x <= j; ++x) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % MOD;
                }
            }
        }
        
        return dp[n][target] % MOD;

    }
};