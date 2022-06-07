////////// TABULATION /////////

class Solution
{
public:
    int cherryPickup(vector<vector<int>> &grid)
    {
        int n = grid.size(), m = grid[0].size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(m)));

        for (int j1 = 0; j1 < m; j1++)
        {
            for (int j2 = 0; j2 < m; j2++)
            {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--)
        {
            for (int j1 = 0; j1 < m; j1++)
            {
                for (int j2 = 0; j2 < m; j2++)
                {
                    int res = -1e9;
                    for (int dj1 = -1; dj1 <= 1; dj1++)
                    {
                        for (int dj2 = -1; dj2 <= 1; dj2++)
                        {
                            int ans = 0;
                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];
                            
                            if(j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m)
                                ans += dp[i + 1][j1 + dj1][j2 + dj2];
                            else
                                ans += -1e9;

                            res = max(res, ans);
                        }
                    }
                    
                    dp[i][j1][j2] = res;
                }
            }
        }
        
        return dp[0][0][m-1];
    }
};
/////////// MEMOIZATION //////////

// class Solution {
// public:
    
//     int recur(vector<vector<int>> &grid, vector<vector<vector<int>>> &dp, int i, int j1, int j2, int rows, int cols) {
        
//         if(j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols) // out of bounds base case
//             return -1e9;
        
//         if(i == rows - 1) { // base case for last row which will yield final answer
//             if(j1 == j2)
//                 return grid[i][j1];
//             else
//                 return grid[i][j1] + grid[i][j2];
//         }
        
//         if(dp[i][j1][j2] != -1) return dp[i][j1][j2]; // handling overlapping subproblems
        
//         int res = -1e9;
        
//         for(int dj1 = -1; dj1 <= 1; dj1++) {
//             for(int dj2 = -1; dj2 <= 1; dj2++) {
//                 int ans;
//                 if(j1 == j2)
//                     ans = grid[i][j1] + recur(grid, dp, i + 1, j1 + dj1, j2 + dj2, rows, cols);
//                 else 
//                     ans = grid[i][j1] + grid[i][j2] + recur(grid, dp, i + 1, j1 + dj1, j2 + dj2, rows, cols);
                
//                 res = max(res, ans); 
//             }
//         }
        
//         return dp[i][j1][j2] = res;
//     }
    
//     int cherryPickup(vector<vector<int>>& grid) {
//         int n = grid.size(), m = grid[0].size();
//         vector<vector<vector<int>>> dp(n, vector<vector<int>> (m, vector<int> (m, -1)));
//         return recur(grid, dp, 0, 0, m - 1, n, m);
//     }
// };


/////////// RECURSION //////////

// class Solution {
// public:
    
//     int recur(vector<vector<int>>& grid, int i, int j1, int j2, int rows, int cols) {
        
//         if(j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols)
//             return -1e9;
        
//         if(i == rows - 1) {
//             if(j1 == j2)
//                 return grid[i][j1];
//             else
//                 return grid[i][j1] + grid[i][j2];
//         }
        
//         int res = -1e9;
        
//         for(int dj1 = -1; dj1 <= 1; dj1++) {
//             for(int dj2 = -1; dj2 <= 1; dj2++) {
//                 int ans;
//                 if(j1 == j2)
//                     ans = grid[i][j1] + recur(grid, i + 1, j1 + dj1, j2 + dj2, rows, cols);
//                 else 
//                     ans = grid[i][j1] + grid[i][j2] + recur(grid, i + 1, j1 + dj1, j2 + dj2, rows, cols);
                
//                 res = max(res, ans); 
//             }
//         }
        
//         return res;
//     }
    
//     int cherryPickup(vector<vector<int>>& grid) {
//         int n = grid.size(), m = grid[0].size();
//         return recur(grid, 0, 0, m - 1, n, m);
//     }
// };