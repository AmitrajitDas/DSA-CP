class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int n = s1.size(), m = s2.size();
        if(s1.size() + s2.size() != s3.size()) return false;
        vector<vector<bool>> dp(n + 1, vector<bool> (m + 1, false));
        
        dp[n][m] = true; // when both of the strings are evaluated
        
        for(int i = n; i >=0; i--) {
            for(int j = m; j >=0; j--) {
                if(i < n && s1[i] == s3[i + j] && dp[i + 1][j])
                    dp[i][j] = true;
                if(j < m && s2[j] == s3[i + j] && dp[i][j + 1])
                   dp[i][j] = true;
            }
        }
        
        return dp[0][0];
    }
};

// class Solution {
// public:
    
//     bool dfs(int i, int j, string &s1, string &s2, string &s3, vector<vector<int>> &dp) {
//         if(i == s1.size() && j == s2.size()) return true;
//         if(dp[i][j] != -1) return dp[i][j];

//         if(i < s1.size() && s1[i] == s3[i + j] && dfs(i + 1, j, s1, s2, s3, dp))
//             return true;
//         if(j < s2.size() && s2[j] == s3[i + j] && dfs(i, j + 1, s1, s2, s3, dp))
//             return true;
        
//         dp[i][j] = false;
//         return false;
//     }
    
//     bool isInterleave(string s1, string s2, string s3) {
//         int n = s1.size(), m = s2.size();
//         if(s1.size() + s2.size() != s3.size()) return false;
//         vector<vector<int>> dp(n + 1, vector<int> (m + 1, -1));
//         return dfs(0, 0, s1, s2, s3, dp);
//     }
// };