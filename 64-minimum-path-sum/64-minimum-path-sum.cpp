class Solution {
public:
    
    int recur(int i, int j, vector<vector<int>> &grid, vector<vector<int>> &dp) {
        
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return 1e9;
        if(dp[i][j] != - 1) return dp[i][j];
        
        int up = grid[i][j] + recur(i - 1, j, grid, dp);
        int left = grid[i][j] + recur(i, j - 1, grid, dp);
        
        return dp[i][j] = min(up, left);
    }
    
    int minPathSum(vector<vector<int>> &grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, -1));
        return recur(m - 1, n - 1, grid, dp);
    }
};

////// RECURSION //////

// class Solution {
// public:
    
//     int recur(int i, int j, vector<vector<int>>& grid) {
        
//         if(i == 0 && j == 0) return grid[0][0];
//         if(i < 0 || j < 0) return INT_MAX;
        
//         int up = grid[i][j] + recur(i - 1, j, grid);
//         int left = grid[i][j] + recur(i, j - 1, grid);
        
//         return min(up, left);
//     }
    
//     int minPathSum(vector<vector<int>>& grid) {
//         int m = grid.size();
//         int n = grid[0].size();
//         return recur(m - 1, n - 1, grid);
//     }
// };