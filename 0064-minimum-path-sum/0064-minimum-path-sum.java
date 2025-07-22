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
        dp[m - 1][n - 1] = grid[m - 1][n - 1];

        for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if(i == m - 1 && j == n - 1) continue;
				else {
					int right = 0, down = 0;
					right = grid[i][j] + (j + 1 < n ? dfs(i, j + 1, m, n, dp, grid) : 100000);
                    down = grid[i][j] + (i + 1 < m ? dfs(i + 1, j, m, n, dp, grid) : 100000);
					dp[i][j] = Math.min(right, down);
				}
			}
		}

		return dp[0][0];
    }
}