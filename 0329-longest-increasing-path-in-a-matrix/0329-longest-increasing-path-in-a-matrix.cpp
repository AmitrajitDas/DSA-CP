class Solution {
private:
    int dfs(int row, int col, int prev, vector<vector<int>> &matrix, vector<vector<int>> &dp) {
        if(row < 0 || row == matrix.size() || col < 0 || col == matrix[row].size() || matrix[row][col] <= prev) return 0;
        if(dp[row][col] != -1) return dp[row][col];

        int res = 1;
        res = max(1 + dfs(row - 1, col, matrix[row][col], matrix, dp), res);
        res = max(1 + dfs(row, col + 1, matrix[row][col], matrix, dp), res);
        res = max(1 + dfs(row, col - 1, matrix[row][col], matrix, dp), res);
        res = max(1 + dfs(row + 1, col, matrix[row][col], matrix, dp), res);
        dp[row][col] = res;
        return res;
    }
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int rows = matrix.size(), cols = matrix[0].size();
        vector<vector<int>> dp(rows, vector<int> (cols, -1));
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                dfs(i, j, -1, matrix, dp);
            }
        }

        int lip;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
               lip = max(dp[i][j], lip);
            }
        }

        return lip;
    }
};