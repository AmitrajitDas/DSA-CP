class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        int n = grid.size(), m = grid[0].size();
        queue<vector<int>> q; // {row, col, steps, currKeyStat}
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '@') q.push({i, j, 0, 0}); // starting point
                else if(grid[i][j] >= 'a' && grid[i][j] <= 'z') count++;
            }
        }

        int finalKeyStat = (1 << count) - 1; // to convert in binary format
        vector<vector<vector<int>>> vis(n, vector<vector<int>>(m, vector<int>(finalKeyStat + 1, 0)));

        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        while(!q.empty()) {
            auto it = q.front();
            q.pop();

            int row = it[0], col = it[1], steps = it[2], currKeyStat = it[3];

            if(currKeyStat == finalKeyStat) return steps;

            for(int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] != '#') {
                    char ch = grid[nrow][ncol];

                    if(ch >= 'a' && ch <= 'f') { // key
                        int newKeyStat = currKeyStat | (1 << (ch - 'a'));
                        if(!vis[nrow][ncol][newKeyStat]) {
                            vis[nrow][ncol][newKeyStat] = 1;
                            q.push({nrow, ncol, steps + 1, newKeyStat});
                        }
                    } else if(ch >= 'A' && ch <= 'F') { // lock
                        // Already have the key then we unlock
                        if(((currKeyStat >> (ch - 'A')) & 1) == 1) {
                            if(!vis[nrow][ncol][currKeyStat]) {
                                vis[nrow][ncol][currKeyStat] = 1;
                                q.push({nrow, ncol, steps + 1, currKeyStat});
                            }
                        }
                    } else { // blank
                        if(!vis[nrow][ncol][currKeyStat]) {
                            vis[nrow][ncol][currKeyStat] = 1;
                            q.push({nrow, ncol, steps + 1, currKeyStat});
                        } 
                    }
                } 
            }
        }

        return -1;
    }
};
