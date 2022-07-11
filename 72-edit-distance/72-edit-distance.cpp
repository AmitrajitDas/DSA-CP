class Solution {
public:
    
    int memo(int i, int j, string word1, string word2, vector<vector<int>> &dp) {
        
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        
        if(dp[i][j] != -1) return dp[i][j];
        if(word1[i] == word2[j]) return dp[i][j] = memo(i - 1, j - 1, word1, word2, dp);
        else {
            int insert = memo(i, j - 1, word1, word2, dp);
            int del =  memo(i - 1, j, word1, word2, dp);
            int replace = memo(i - 1, j - 1, word1, word2, dp);
            
            return dp[i][j] = 1 + min(insert, min(del, replace));
        }
    }
    
    int minDistance(string word1, string word2) {
        int n = word1.size(), m = word2.size();
        vector<vector<int>> dp(n, vector<int>(m + 1, -1));
        return memo(n - 1, m - 1, word1, word2, dp);
    }
};