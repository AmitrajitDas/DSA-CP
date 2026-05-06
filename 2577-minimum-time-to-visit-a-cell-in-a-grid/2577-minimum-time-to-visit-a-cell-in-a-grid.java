class Solution {
    int[] drow = { -1, 0, 1, 0 };
    int[] dcol = { 0, 1, 0, -1 };

    public int minimumTime(int[][] grid) {
        // Edge case: if both neighbors of (0,0) are blocked (value > 1),
        // we can never leave the start cell
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int n = grid.length, m = grid[0].length;

        // Min-heap ordered by time — always process the cell reachable in least time first (Dijkstra)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][m];

        // Start at (0,0) at time 0
        pq.offer(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0], row = curr[1], col = curr[2];

            // Skip if already visited with a smaller time (stale entry in heap)
            if (vis[row][col]) continue;
            vis[row][col] = true;

            // Reached destination
            if (row == n - 1 && col == m - 1) return currTime;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    int next = grid[nrow][ncol]; // minimum time required to enter neighbor

                    if (next <= currTime + 1) {
                        // Can step in directly — neighbor is already unlocked
                        pq.offer(new int[] { currTime + 1, nrow, ncol });
                    } else {
                        // Neighbor is locked — must wait by bouncing back and forth
                        // Each bounce costs 2 time units, so parity must match
                        // wait % 2 == 0 → parity mismatch → need one extra step (next + 1)
                        // wait % 2 == 1 → parity matches  → enter exactly at next
                        int wait = next - currTime;
                        pq.offer(new int[] { wait % 2 == 0 ? next + 1 : next, nrow, ncol });
                    }
                }
            }
        }

        return -1;
    }
}