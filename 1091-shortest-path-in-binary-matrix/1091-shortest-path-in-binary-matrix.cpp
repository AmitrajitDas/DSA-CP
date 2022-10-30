class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        if(grid[0][0] != 0) return -1;
        
        int n = grid.size(), m = grid[0].size();
        vector<vector<int>> dist(n, vector<int>(m, INT_MAX));
        dist[0][0] = 0;
        queue<pair<int, pair<int, int>>> q;
        q.push({0, {0, 0}});
        
        int drow[8] = {-1, -1, 0, 1, 1, 1, 0, -1};
        int dcol[8] = {0, 1, 1, 1, 0, -1, -1, -1};
        
        while(!q.empty()) {
            auto it = q.front();
            int dis = it.first;
            int row = it.second.first, col = it.second.second;
            q.pop();
            
            if(row == n-1 && col == m-1) return dis + 1;
            
            for(int i = 0; i < 8; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && dis + 1 < dist[nrow][ncol]) {
                    dist[nrow][ncol] = dis + 1;
                    q.push({dis + 1, {nrow, ncol}});
                }
            }
        }
        
        return -1;
    }
};