class Solution {
    int n, m;
    int[] drow = {-1, 0, 1, 0};
    int[] dcol = {0, 1, 0, -1};

    private void dfs(int row, int col, boolean[][] vis, int[][] grid) {
        vis[row][col] = true;
        for(int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow>= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i][0] && grid[i][0] == 1) {
                dfs(i, 0, vis, grid);
            }
            if(!vis[i][m - 1] && grid[i][m - 1] == 1) {
                dfs(i, m - 1, vis, grid);
            }
        }

        for(int j = 0; j < m; j++) {
            if(!vis[0][j] && grid[0][j] == 1) {
                dfs(0, j, vis, grid);
            }
            if(!vis[n - 1][j] && grid[n - 1][j] == 1) {
                dfs(n - 1, j, vis, grid);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}