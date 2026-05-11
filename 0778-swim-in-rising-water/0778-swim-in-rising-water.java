class Solution {
    // Direction arrays for moving up, down, left, right
    int[] drow = {1, 0, -1, 0};
    int[] dcol = {0, 1, 0, -1};

    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // Tracks the maximum elevation encountered along the current best path
        int res = Integer.MIN_VALUE;

        // Min-heap: stores {elevation, row, col}, prioritized by lowest elevation
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][m];

        // Start from top-left cell
        pq.offer(new int[]{grid[0][0], 0, 0});

        while (!pq.isEmpty()) {
            // Always process the cell with the lowest elevation first (Dijkstra-like)
            int[] curr = pq.poll();
            int elevation = curr[0], row = curr[1], col = curr[2];

            // Skip already visited cells
            if (vis[row][col]) continue;
            vis[row][col] = true;

            // The answer is the max elevation seen so far on this path
            res = Math.max(res, elevation);

            // Reached bottom-right — return the bottleneck elevation of this path
            if (row == n - 1 && col == m - 1) return res;

            // Explore all 4 neighbors
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                // Add valid, unvisited neighbors to the heap
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    pq.offer(new int[]{grid[nrow][ncol], nrow, ncol});
                }
            }
        }

        // Should never reach here for a valid grid
        return -1;
    }
}