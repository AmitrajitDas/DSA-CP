class Solution {
public:
    int longestPalindromeSubseq(string s) {
        
        int n = s.size();
        string srev = string(s.rbegin(), s.rend());
        
        vector<int> prev(n + 1, 0), curr(n + 1, 0);
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s[i - 1] == srev[j - 1]) curr[j] = 1 + prev[j - 1];
                else curr[j] = max(prev[j], curr[j - 1]);
            }
            
            prev = curr;
        }
        
        return prev[n];
    }
};

// class Solution {
// public:
//     int longestPalindromeSubseq(string s1) {
//         int n = s1.size();
//         string s2 = string(s1.rbegin(), s1.rend());
        
//         vector<vector<int>> dp(n + 1, vector<int> (n + 1, 0));

//         for(int j = 0; j <= n; j++) dp[0][j] = 0;
//         for(int i = 0; i <= n; i++) dp[i][0] = 0;

//         for(int i = 1; i <= n; i++) {
//             for(int j = 1; j <= n; j++) {
//                 if(s1[i - 1] == s2[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
//                 else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
//             }
//         }

//         return dp[n][n];
//     }
// };
