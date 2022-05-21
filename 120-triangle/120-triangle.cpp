class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        vector<int> next(n);
        
        for(int j = 0; j < n; j++)
            next[j] = triangle[n - 1][j];
        
        for(int i = n - 2; i >= 0; i--) {
            vector<int> curr(n);
            for(int j = i; j >= 0; j--) {
                int down = 0, diag = 0;
                
                down = triangle[i][j] + next[j];
                diag = triangle[i][j] + next[j + 1];
                
                curr[j] = min(down, diag);
            }
            
            next = curr;
        }
        
        return next[0];
    }
};

////// TABULATION //////

// class Solution {
// public:
//     int minimumTotal(vector<vector<int>>& triangle) {
//         int n = triangle.size();
//         vector<vector<int>> dp(n, vector<int> (n));
        
//         for(int j = 0; j < n; j++)
//             dp[n - 1][j] = triangle[n - 1][j];
        
//         for(int i = n - 2; i >= 0; i--) {
//             for(int j = i; j >= 0; j--) {
//                 int down = 0, diag = 0;
                
//                 down = triangle[i][j] + dp[i + 1][j];
//                 diag = triangle[i][j] + dp[i + 1][j + 1];
                
//                 dp[i][j] = min(down, diag);
//             }
//         }
        
//         return dp[0][0];
//     }
// };

/////// MEMOIZATION //////

// class Solution {
// public:
    
//     int recur(int i, int j, vector<vector<int>> &triangle, vector<vector<int>> &dp) 
//     {
        
//         if(i == triangle.size() - 1) return triangle[i][j];
//         if(dp[i][j] != -1) return dp[i][j];
        
//         int down = triangle[i][j] + recur(i + 1, j, triangle,dp);
//         int diag = triangle[i][j] + recur(i + 1, j + 1, triangle, dp);
        
//         return dp[i][j] = min(down, diag);
//     }
    
//     int minimumTotal(vector<vector<int>>& triangle) {
//         int n = triangle.size();
//         vector<vector<int>> dp(n, vector<int> (n, -1));
//         return recur(0, 0, triangle,dp);
//     }
// };

/////// RECURSION ///////

// class Solution {
// public:
    
//     int recur(int i, int j, vector<vector<int>> &triangle) {
        
//         if(i == triangle.size() - 1) return triangle[i][j];
        
//         int down = triangle[i][j] + recur(i + 1, j, triangle);
//         int diag = triangle[i][j] + recur(i + 1, j + 1, triangle);
        
//         return min(down, diag);
//     }
    
//     int minimumTotal(vector<vector<int>>& triangle) {
//         int n = triangle.size();
        
//         return recur(0, 0, triangle);
//     }
// };