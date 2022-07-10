class Solution {
public:
    
//     int memoize(int i, int j, string s, string t, vector<vector<int>> &dp) {
//         if(j == 0) return 1;
//         if(i == 0) return 0;
//         if(dp[i][j] != -1) return dp[i][j];
        
//         if(s[i - 1] == t[j - 1]) return dp[i][j] = memoize(i - 1, j - 1, s, t, dp) + memoize(i - 1, j, s, t, dp);
//         return dp[i][j] = memoize(i - 1, j, s, t, dp);
//     }
    int MOD = 1e9+7;
    int numDistinct(string s, string t) {
        int n = s.size(), m = t.size();
        vector<vector<int>> dp(n + 1, vector<int> (m + 1, 0));
        
        for(int i = 0; i <= n; i++) dp[i][0] = 1;
        // for(int j = 1; j <= m; j++) dp[0][j] = 0;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s[i - 1] == t[j - 1]) dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j])%MOD;
                else dp[i][j] = dp[i - 1][j];
            }
        }
        
        return  dp[n][m];
    }
};