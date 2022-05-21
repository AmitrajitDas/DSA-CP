class Solution {
public:
    
    int recur(int i, int j, vector<vector<int>> &triangle, vector<vector<int>> &dp) 
    {
        
        if(i == triangle.size() - 1) return triangle[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        
        int down = triangle[i][j] + recur(i + 1, j, triangle,dp);
        int diag = triangle[i][j] + recur(i + 1, j + 1, triangle, dp);
        
        return dp[i][j] = min(down, diag);
    }
    
    int minimumTotal(vector<vector<int>>& triangle) {
        int n = triangle.size();
        vector<vector<int>> dp(n, vector<int> (n, -1));
        return recur(0, 0, triangle,dp);
    }
};

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