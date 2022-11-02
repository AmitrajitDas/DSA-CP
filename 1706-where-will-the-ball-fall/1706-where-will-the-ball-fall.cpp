class Solution {
private:
    bool isValid(int row, int col, int n, int m) {
       if(row < 0 || col < 0 || row >= n || col >= m) return false;
        return true;
    }
    
    int dfs(int row, int col, vector<vector<int>>& grid) {
        if(row == grid.size()) return col;
        
        if(isValid(row, col, grid.size(), grid[0].size())) {
            if(grid[row][col] == 1) {
                if(isValid(row, col + 1, grid.size(), grid[0].size()) && grid[row][col + 1] == 1)
                    return dfs(row + 1, col + 1, grid);
            } else {
                if(isValid(row, col - 1, grid.size(), grid[0].size()) && grid[row][col - 1] == -1)
                    return dfs(row + 1, col - 1, grid);
            }
        }
        
        return -1;
    }
    
public:
    vector<int> findBall(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size(); 
        vector<int> res(m, 0);
        for(int i = 0; i < m; i++) res[i] = dfs(0, i, grid);
        
        return res;
    }
};