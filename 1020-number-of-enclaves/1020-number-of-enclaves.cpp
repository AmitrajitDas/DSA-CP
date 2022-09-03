class Solution {
public:
    void dfs(int row, int col, vector<vector<int>> &grid, vector<vector<bool>> &vis, int delRow[], int delCol[]) {
        int n = grid.size(), m = grid[0].size();
        vis[row][col] = true;
        
        for(int i = 0; i < 4; i++) {
            int currRow = row + delRow[i];
            int currCol = col + delCol[i];
            if(currRow >= 0 && currRow < n && currCol >= 0 && currCol < m && !vis[currRow][currCol] && grid[currRow][currCol] == 1) {
                dfs(currRow, currCol, grid, vis, delRow, delCol);
            }
        }
    }
    
    int numEnclaves(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        vector<vector<bool>> vis(n, vector<bool> (m, false));
        
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        
        for(int i = 0; i < n; i++) { // row boundaries
            
            if(!vis[i][0] && grid[i][0] == 1) dfs(i, 0, grid, vis, delRow, delCol);
            if(!vis[i][m - 1] && grid[i][m - 1] == 1) dfs(i, m - 1, grid, vis, delRow, delCol);
        }
        
        for(int j = 0; j < m; j++) { // column boundaries
            
            if(!vis[0][j] && grid[0][j] == 1) dfs(0, j, grid, vis, delRow, delCol);
            if(!vis[n - 1][j] && grid[n - 1][j] == 1) dfs(n - 1, j, grid, vis, delRow, delCol);
        }
        
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) count++;
            }
        }
        
        return count;
    }
};