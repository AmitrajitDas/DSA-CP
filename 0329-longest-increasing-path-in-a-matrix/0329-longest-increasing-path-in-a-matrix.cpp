class Solution {
private:
    int dfs(int row, int col, int prev, vector<vector<int>> &matrix, vector<vector<int>> &dp) {
        if(row < 0 || row == matrix.size() || col < 0 || col == matrix[row].size() || matrix[row][col] <= prev) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        
        return dp[row][col] = 1 + max({
            dfs(row - 1, col, matrix[row][col], matrix, dp),
            dfs(row, col + 1, matrix[row][col], matrix, dp),
            dfs(row, col - 1, matrix[row][col], matrix, dp),
            dfs(row + 1, col, matrix[row][col], matrix, dp)
        });
    }
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int rows = matrix.size(), cols = matrix[0].size();
        int lip;
        vector<vector<int>> dp(rows, vector<int> (cols, -1));
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
               lip = max(dfs(i, j, -1, matrix, dp), lip);
            }
        }
        return lip;
    }
};