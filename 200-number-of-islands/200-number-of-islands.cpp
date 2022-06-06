//////// BFS SOLUTION ///////////

class Solution
{
public:
    int numIslands(vector<vector<char>> &grid)
    {
        int m = grid.size(), n = grid[0].size(), islands = 0;
        int dir[] = {-1, 0, 1, 0, -1}; // offset array for directions

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == '1')
                {
                    islands++;
                    grid[i][j] = '0'; // replace the 1s with 0s
                    queue<pair<int, int>> q;
                    q.push({i, j});
                    while (!q.empty())
                    {
                        pair<int, int> p = q.front();
                        q.pop();
                        for (int k = 0; k < 4; k++)
                        {
                            // adding the offsets to reach each direction from current index
                            int r = p.first + dir[k], c = p.second + dir[k + 1]; 
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1')
                            {
                                q.push({r, c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
};

//////// DFS SOLUTION ///////////

// class Solution {
// public:
    
//     void dfs(vector<vector<char>> &grid, int i, int j, int rows, int cols) {
        
//         if(i < 0 || i >= rows || j < 0 || j >= cols|| grid[i][j] == '0')
//             return;
        
//         grid[i][j] = '0';
//         dfs(grid, i - 1, j); // Top
//         dfs(grid, i, j + 1); // Right
//         dfs(grid, i + 1, j); // Down
//         dfs(grid, i, j - 1); // Left
//     }
    
//     int numIslands(vector<vector<char>>& grid) {
        
//         int m = grid.size(), n = grid[0].size(), 
//         int islands = 0;
        
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(grid[i][j] == '1') {
//                     islands++;
//                     dfs(grid, i, j, m, n);
//                 }
//             }
//         }
        
//         return islands;
//     }
// };