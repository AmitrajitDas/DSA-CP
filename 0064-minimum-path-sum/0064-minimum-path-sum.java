class Solution {
    private int dfs(int i, int j, int m, int n, int[][] dp, int[][] grid) {
        if(i >= m || j >= n) return 100000;
        if(i == m - 1 && j == n - 1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int right = grid[i][j] + dfs(i, j + 1, m, n, dp, grid);
        int down = grid[i][j] + dfs(i + 1, j, m, n, dp, grid);

        return dp[i][j] = Math.min(right, down);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(0, 0, m, n, dp, grid);
    }
}