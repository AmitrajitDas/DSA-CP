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
        vector<int> dp(m + 1, 0);
        
        dp[0] = 1;
        // for(int j = 1; j <= m; j++) dp[0][j] = 0;
        
        for(int i = 1; i <= n; i++) {
            for(int j = m; j >= 1; j--) {
                if(s[i - 1] == t[j - 1]) dp[j] = (dp[j - 1] + dp[j])%MOD;
            }
        }
        
        return  dp[m];
    }
};