class Solution {
public:
    
    int recur(int i, int j, vector<vector<int>> &matrix, vector<vector<int>> &dp) {
        
        if(j < 0 || j >= matrix[0].size()) return 1e9;
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != -1) return dp[i][j];
        int up = matrix[i][j] + recur(i - 1, j, matrix, dp);
        int ld = matrix[i][j] + recur(i - 1, j - 1, matrix, dp);
        int rd = matrix[i][j] + recur(i - 1, j + 1, matrix, dp);
        
        return dp[i][j] = min(up, min(ld, rd));
    }
    
    int minFallingPathSum(vector<vector<int>>& matrix) {
       
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<int>> dp(n, vector<int>(m, -1));
        int res = INT_MAX;
        
        for(int j = 0; j < m; j++) {
            int temp = recur(n - 1, j, matrix, dp);
            res = min(res, temp);
        }
        
        return res;
    }
};

/////// RECURSION ///////

// class Solution {
// public:
    
//     int recur(int i, int j, vector<vector<int>> &matrix) {
        
//         if(j < 0 || j >= matrix[0].size()) return 1e9;
//         if(i == 0) return matrix[0][j];
        
//         int up = matrix[i][j] + recur(i - 1, j, matrix);
//         int ld = matrix[i][j] + recur(i - 1, j - 1, matrix);
//         int rd = matrix[i][j] + recur(i - 1, j + 1, matrix);
        
//         return min(up, min(ld, rd));
//     }
    
//     int minFallingPathSum(vector<vector<int>>& matrix) {
       
//         int n = matrix.size();
//         int m = matrix[0].size();
//         int res = INT_MAX;
        
//         for(int j = 0; j < m; j++) {
//             int temp = recur(n - 1, j, matrix);
//             res = min(res, temp);
//         }
        
//         return res;
//     }
// };