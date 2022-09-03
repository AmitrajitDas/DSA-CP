class Solution {
public:
    
    void dfs(int row, int col, vector<vector<char>>& board, vector<vector<bool>> &vis, int delRow[], int delCol[]) {
        int n = board.size(), m = board[0].size();
        vis[row][col] = true;
        
        for(int i = 0; i < 4; i++) {
            int currRow = row + delRow[i];
            int currCol = col + delCol[i];
            if(currRow >= 0 && currRow < n && currCol >= 0 && currCol < m && !vis[currRow][currCol] &&                      board[currRow][currCol] == 'O') {
                dfs(currRow, currCol, board, vis, delRow, delCol);
            }
        }
    }
    
    void solve(vector<vector<char>>& board) {
        int n = board.size(), m = board[0].size();
        vector<vector<bool>> vis(n, vector<bool> (m, false));
        
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        
        for(int i = 0; i < n; i++) { // row boundaries
            
            if(!vis[i][0] && board[i][0] == 'O') dfs(i, 0, board, vis, delRow, delCol);
            if(!vis[i][m - 1] && board[i][m - 1] == 'O') dfs(i, m - 1, board, vis, delRow, delCol);
        }
        
        for(int j = 0; j < m; j++) { // column boundaries
            
            if(!vis[0][j] && board[0][j] == 'O') dfs(0, j, board, vis, delRow, delCol);
            if(!vis[n - 1][j] && board[n - 1][j] == 'O') dfs(n - 1, j, board, vis, delRow, delCol);
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
};