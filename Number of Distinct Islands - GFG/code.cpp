class Solution {
  public:
  
    void dfs(int row, int col, vector<vector<int>> &grid, vector<pair<int, int>> &pos, vector<vector<bool>> &vis, int baseRow, int baseCol) {
        int n = grid.size(), m = grid[0].size();
        vis[row][col] = true;
        
        pos.push_back({row - baseRow, col - baseCol});
        
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};    
            
        for(int i = 0; i < 4; i++) {
            int currRow = row + delRow[i];
            int currCol = col + delCol[i];
            if(currRow >= 0 && currRow < n && currCol >= 0 && currCol < m && !vis[currRow][currCol] && grid[currRow][currCol] == 1) {
                dfs(currRow, currCol, grid, pos, vis, baseRow, baseCol);
            }
        }
    }
  
    int countDistinctIslands(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        set<vector<pair<int, int>>> st;
        vector<vector<bool>> vis(n, vector<bool>(m , false));
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    vector<pair<int, int>> pos;
                    dfs(i, j, grid, pos, vis, i, j);
                    st.insert(pos);
                }
            }
        }
        
        return st.size();
    }
};
