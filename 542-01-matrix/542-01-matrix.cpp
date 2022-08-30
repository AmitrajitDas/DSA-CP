class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>&grid) {
        int n = grid.size(), m = grid[0].size();
	    vector<vector<bool>> vis(n, vector<bool> (m, false));
	    vector<vector<int>> dist(n, vector<int> (m, 0));
	    
	    queue<pair<pair<int, int>, int>> q;
	    int rowOffset[] = {-1, 0, +1, 0};
	    int colOffset[] = {0, +1, 0, -1};
	    
	    // handling only the 1s
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < m; j++) {
	            if(grid[i][j] == 0) {
	                vis[i][j] = true;
	                q.push({{i, j}, 0});
	            }
	        }
	    }
	    
	    while(!q.empty()) {
	        int currRow = q.front().first.first;
	        int currCol = q.front().first.second;
	        int currDis = q.front().second;
	        q.pop();
	        
	        dist[currRow][currCol] = currDis;
	        
	        for(int i = 0; i < 4; i++) {
	            int row = currRow + rowOffset[i];
	            int col = currCol + colOffset[i];
	            if(row >= 0 && row < n && col >= 0 && col < m && !vis[row][col]) {
	                q.push({{row, col}, currDis + 1});
	                vis[row][col] = true;
	            }
	        }
	    }
	    
	    return dist;
    }
};