class Solution {
    int[] drow = { -1, 0, 1, 0 };
    int[] dcol = { 0, 1, 0, -1 };

    public int minimumObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // Min-heap ordered by number of obstacles removed so far (Dijkstra)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][m];

        // Start at (0,0) with 0 obstacles removed
        pq.offer(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], row = curr[1], col = curr[2];

            // Skip stale heap entries
            if (vis[row][col]) continue;
            vis[row][col] = true;

            // Reached destination — return minimum obstacles removed
            if (row == n - 1 && col == m - 1) return cost;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    // grid[nrow][ncol] is 0 (empty) or 1 (obstacle)
                    // cost only increases when we remove an obstacle
                    pq.offer(new int[] { cost + grid[nrow][ncol], nrow, ncol });
                }
            }
        }

        return -1;
    }
}