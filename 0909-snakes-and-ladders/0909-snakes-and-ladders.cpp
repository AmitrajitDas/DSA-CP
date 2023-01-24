class Solution {
private:
    void getCoords(int n, int s, int &row, int &col) {
        row = n - 1 - (s - 1)/n; // to get actual rows from bottom, we need to subtract it from n-1
        col = (s - 1)%n;
        // when (n and row_from_bottom are even) or (n and row_from_bottom are odd), the column number starts from right to left
        if((row % 2 == 0 && n % 2 == 0) || (row % 2 == 1 && n % 2 == 1)) col = n - 1 - col;
    }
public:
    int snakesAndLadders(vector<vector<int>>& board) {
        int n = board.size();
        queue<pair<int, int>> q;
        vector<bool> vis(n * n + 1,false);
        q.push({1, 0});
        vis[1] = true;
        while(!q.empty()) {
            int row, col, s = q.front().first;
            int moves = q.front().second;
            q.pop();
            if(s == n * n) return moves;
            for(int i = 1; i <= 6 && s + i <= n * n; i++) {
                getCoords(n, s + i, row, col);
                int sq = board[row][col] == -1 ? s + i : board[row][col];
                if(!vis[sq]) {
                    vis[sq] = true;
                    q.push({sq, moves + 1});
                }
            }
        }
        
        return -1;
    }
};