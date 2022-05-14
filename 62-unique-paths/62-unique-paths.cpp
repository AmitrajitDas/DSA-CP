class Solution {
public:
    
    int rec(int i, int j, vector<vector<int>> &dp) {
        
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int up = rec(i - 1, j, dp);
        int left = rec(i, j - 1, dp);
        
        return dp[i][j] = up + left;
    }
    
    int uniquePaths(int m, int n) {
        
        vector<vector<int>> dp(m,vector<int>(n,-1));
        return rec(m - 1, n - 1, dp);
    }
};

/////// RECURSION ///////

// class Solution {
// public:
    
//     int rec(int i, int j) {
        
//         if(i == 0 && j == 0) return 1;
//         if(i < 0 || j < 0) return 0;
        
//         int up = uniquePaths(i - 1, j);
//         int left = uniquePaths(i, j - 1);
        
//         return up + left;
//     }
    
//     int uniquePaths(int m, int n) {
//         return rec(m - 1, n - 1);
//     }
// };