class Solution {
public:
    
    void dfs(vector<vector<char>> &grid, int i, int j) {
        
        if(i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        dfs(grid, i - 1, j); // Top
        dfs(grid, i, j + 1); // Right
        dfs(grid, i + 1, j); // Down
        dfs(grid, i, j - 1); // Left
    }
    
    int numIslands(vector<vector<char>>& grid) {
        
        int islands = 0;
        
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid[0].size(); j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return islands;
    }
};